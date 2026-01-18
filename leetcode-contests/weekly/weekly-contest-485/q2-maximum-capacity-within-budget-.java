class Solution {
    private static class Machine{
        int cost;
        int capacity;

        Machine(int cost, int capacity){
            this.cost = cost;
            this.capacity = capacity;
        }
    }
    
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        Machine[] machines = new Machine[n];

        for(int i=0; i<n; i++){
            machines[i] = new Machine(costs[i], capacity[i]);
        }

        Arrays.sort(machines, (m1, m2) -> Integer.compare(m1.cost, m2.cost));

        int[] prefixMax = new int[n];
        prefixMax[0] = machines[0].capacity;
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], machines[i].capacity);
        }

        long maxTotalCapacity = 0;

        for(int i=0; i<n; i++){
            int currentCost = machines[i].cost;
            int currentCap = machines[i].capacity;

            if(currentCost < budget){
                maxTotalCapacity = Math.max(maxTotalCapacity, currentCap);
            }

            int remainingBudget = budget - currentCost;

            if(i>0 && machines[0].cost < remainingBudget){
                int idx = findBestPartner(machines, i-1, remainingBudget);

                if(idx != -1){
                    int bestPartnerCap = prefixMax[idx];
                    maxTotalCapacity = Math.max(maxTotalCapacity, (long) currentCap + bestPartnerCap);
                }
            }
        }

        return (int) maxTotalCapacity;
    }

    private int findBestPartner(Machine[] machines, int highLimit, int maxCost){
        int l = 0;
        int h = highLimit;
        int ans = -1;

        while (l <= h){
            int m = l + (h - l) / 2;

            if(machines[m].cost < maxCost){
                ans = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return ans;
    }

}