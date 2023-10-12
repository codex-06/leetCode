class Solution {
    public int mincost(int index,int[]cost, int[] dp){
        if( index >= cost.length ) return 0;
        if ( dp[index] != -1) return  dp[index];

        int left = mincost(index +1, cost, dp);
        int right = mincost(index +2, cost, dp);

        dp[index] = Math.min(left, right ) + cost[index];

        return Math.min(left, right ) + cost[index];
    }


    public int minCostClimbingStairs(int[] cost) {

        int [] dp = new int[cost.length];

        Arrays.fill(dp, -1);

        return Math.min(mincost(0, cost, dp), mincost(1, cost, dp));
    }
}