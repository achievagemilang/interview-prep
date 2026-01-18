class AuctionSystem {
    private static class Bid implements Comparable<Bid>{
        int userId;
        int amount;

        public Bid(int userId, int amount){
            this.userId = userId;
            this.amount = amount;
        }

        @Override
        public int compareTo(Bid other){
            if(this.amount != other.amount){
                return Integer.compare(other.amount, this.amount);
            }

            return Integer.compare(other.userId, this.userId);
        }
    }
    private Map<Integer, Map<Integer, Integer>> userBids;
    private Map<Integer, TreeSet<Bid>> leaderboards;

    
    public AuctionSystem() {
        userBids = new HashMap<>();    
        leaderboards = new HashMap<>();    
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        userBids.putIfAbsent(itemId, new HashMap<>());
        leaderboards.putIfAbsent(itemId, new TreeSet<>());

        Map<Integer, Integer> currentItemBids = userBids.get(itemId);
        TreeSet<Bid> currentLeaderboard = leaderboards.get(itemId);

        if(currentItemBids.containsKey(userId)){
            int oldAmount = currentItemBids.get(userId);
            currentLeaderboard.remove(new Bid(userId, oldAmount));
        }

        currentItemBids.put(userId, bidAmount);
        currentLeaderboard.add(new Bid(userId, bidAmount));
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }
    
    public void removeBid(int userId, int itemId) {
        if(!userBids.containsKey(itemId)) return;

        Map<Integer, Integer> currentItemBids = userBids.get(itemId);
        TreeSet<Bid> currentLeaderboard = leaderboards.get(itemId);

        if(currentItemBids.containsKey(userId)){
            int amount = currentItemBids.get(userId);

            currentItemBids.remove(userId);

            currentLeaderboard.remove(new Bid(userId, amount));
        }
    }
    
    public int getHighestBidder(int itemId) {
        if(!leaderboards.containsKey(itemId)) return -1;

        TreeSet<Bid> currentLeaderboard = leaderboards.get(itemId);
        if(currentLeaderboard.isEmpty()) return -1;

        return currentLeaderboard.first().userId;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */