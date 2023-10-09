class Solution {

    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;

        while(left <= right){
            int middle = (left + right)/2;

            if(nums[middle] == target) return middle;


            else if( nums[middle] < target){
                left = middle + 1;
            }

            else right = middle -1;
        }

        return -1;
    }


    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums,target);

        if ( index ==-1) return new int[]{-1,-1};

        int i = index;
        while (i < nums.length && nums[i] == target){
            i ++;
        }

        int j = index;
        while( j >=0 && nums[j]== target){
            j --;
        }

        return new int[]{j +1,i -1};
    }
}