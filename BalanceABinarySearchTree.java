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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        return buildBalancedBST(inorder, 0, inorder.size()-1);
    }

    private void inorderTraversal(TreeNode node, List<Integer> inorder){
        if(node == null) return;
        inorderTraversal(node.left, inorder);
        inorder.add(node.val);
        inorderTraversal(node.right, inorder);
    }

    private TreeNode buildBalancedBST(List<Integer> inorder, int left, int right){
        if(left > right) return null;

        int mid = left + (right-left) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));

        root.left = buildBalancedBST(inorder, left, mid-1);
        root.right = buildBalancedBST(inorder, mid+1, right);

        return root;
    }
}
