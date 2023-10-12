class Solution {

    public boolean jump( int index, int[] nums, int[] dp){
        if( index >= nums.length -1) return true;
        if ( dp[index] != 0) return dp[index] ==1;
        
        for ( int i = 1 ; i <= nums[index]; i ++){
            if(jump(index +i, nums, dp)){
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = -1;
        return false;
    }



    public boolean canJump(int[] nums) {
        if( nums.length ==1) return true;
        int[] dp = new int[nums.length +1 ];
        return jump(0, nums, dp);
    }
}