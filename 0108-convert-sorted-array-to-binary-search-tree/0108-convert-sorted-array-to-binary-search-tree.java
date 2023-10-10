/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void maketree (TreeNode root, int left, int right, int[] nums){
   
        int middle = (left+ right)/2;


        root.val = nums[middle];




        if( left <= middle- 1){
            root.left = new TreeNode();
            maketree(root.left , left, middle -1, nums);

        }


        if ( middle+ 1 <= right ){
            root.right = new TreeNode();
            maketree(root.right, middle +1, right, nums);

        }



    }



    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();

        maketree(root, 0, nums.length -1,nums);

        return root;
    }
}