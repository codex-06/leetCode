class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0 ;
        if ( nums.length ==1) return nums[0] ==k? 1: 0;
        if ( nums[0] ==k) res++;
        for ( int i = 1 ;i < nums.length ; i ++){
            nums[i] += nums[i -1];
            if ( nums[i] == k) res ++;
        }
        for ( int i = 1; i < nums.length ; i ++ ){
            for( int j = 0; j < i; j ++){
                if( nums[i] -nums[j] ==k) res++;
            }
        }

        return res;
    }
}