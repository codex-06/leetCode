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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> q= new LinkedList<>();

        q.add(root);
        q.add( null);
        int max = Integer.MIN_VALUE;

        while(! q.isEmpty()){
            TreeNode curr = q.poll();

            if( curr== null){
                res.add(max);
                max =Integer.MIN_VALUE;
                if(!q.isEmpty()){
                    q.add(null);
                }
            }

            else{
                max = Math.max(max, curr.val);

                if( curr.left != null) q.add(curr.left);
                if( curr.right != null) q.add(curr.right);
            }

        }

        return res;
    }
}