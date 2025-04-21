class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return helper(root, 1, totalNodes);
    }
    public boolean helper(TreeNode root, int i, int totalNodes){
        if(root == null) return true;
        if(i>totalNodes) return false;

        //Recursion call        
        boolean isLeftComplete = helper(root.left, 2*i, totalNodes);
        boolean isRightComplete = helper(root.right, 2*i + 1, totalNodes);
        return isLeftComplete && isRightComplete;
    }
    public int countNodes(TreeNode root){
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
