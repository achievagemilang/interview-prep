class RideSharingSystem {
    Deque<Integer> riders;
    Deque<Integer> drivers;
    Set<Integer> cancelledRiders;
    Set<Integer> waitingRiders;

    public RideSharingSystem() {
        riders = new ArrayDeque<>();
        drivers = new ArrayDeque<>();
        cancelledRiders = new HashSet<>();
        waitingRiders = new HashSet<>();
    }
    
    public void addRider(int riderId) {
        riders.add(riderId);
        waitingRiders.add(riderId);
    }
    
    public void addDriver(int driverId) {
        drivers.add(driverId);
        
    }
    
    public int[] matchDriverWithRider() {
        while(!riders.isEmpty() && cancelledRiders.contains(riders.peek())){
            cancelledRiders.remove(riders.poll());
        }
        
        if(riders.isEmpty() || drivers.isEmpty())
            return new int[]{-1, -1};

        int r = riders.poll();
        int d = drivers.poll();
        waitingRiders.remove(r);

        return new int[]{d, r};
    }
    
    public void cancelRider(int riderId) {
        if(waitingRiders.contains(riderId)){
            cancelledRiders.add(riderId);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */©leetcode