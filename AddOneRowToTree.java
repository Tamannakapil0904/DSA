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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        int currDepth = 1;
        return addRow(root, currDepth, val, depth);
    }    
public TreeNode addRow(TreeNode root, int currDepth, int val, int depth){
        if(root==null) return null;
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        else if(currDepth == depth-1){
            TreeNode a = new TreeNode(val);
            TreeNode b = new TreeNode(val);
            TreeNode oldLeft = root.left;
            TreeNode oldRight = root.right;

            root.left = a;
            root.right = b;

            a.left = oldLeft;
            b.right = oldRight;
            return root;
      }
        else{
            addRow(root.left, currDepth+1, val, depth);
            addRow(root.right, currDepth+1, val, depth);
            return root;
        }
    }
}
