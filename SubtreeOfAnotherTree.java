class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(subRoot == null) return true;

        if(root.val == subRoot.val){
            if(SameTree(root, subRoot))
            return true;
        }
        boolean isLeft = isSubtree(root.left, subRoot);
        boolean isRight = isSubtree(root.right, subRoot);
        return isLeft || isRight;
    }
    public boolean SameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        return SameTree(root1.left, root2.left) && SameTree(root1.right, root2.right);
    }
}
