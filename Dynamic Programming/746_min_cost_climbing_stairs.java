class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int sec = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            int cur = cost[i] + Math.min(first, sec);
            first = sec;
            sec = cur;
        }
        
        return Math.min(first, sec);
    }
}
