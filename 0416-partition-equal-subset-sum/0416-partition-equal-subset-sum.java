class Solution { 


    public static boolean solve (int target, int index , int[] arr, int[][] dp ){
        if( index == -1  )return target ==0;

        if( dp[index][target] != -1) return dp[index][target] ==1;


        if (arr[index] <= target){
            if( solve(target - arr[index], index -1, arr, dp)){
                dp[index][target] =1;
                return true;
            }
            
        }

        dp[index][target] =  solve(target, index -1, arr, dp) ? 1: 0;
        return dp[index][target] ==1;
    }




    public boolean canPartition(int[] nums) {
         int sum = 0 ;
        for( int x : nums){
           sum += x;
        }

        if( sum %2 ==1) return false;

        int [][] dp = new int [nums.length +1][sum +1];
        for ( int i = 0 ; i < dp.length; i++)
            {Arrays.fill(dp[i],-1);}

        return solve(sum/2, nums.length -1,nums,dp);
    }
}