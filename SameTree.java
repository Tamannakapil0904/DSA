class Solution {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
       if(root1 == null && root2 == null) return true;
       if(root1 == null && root2 != null
       || root1 != null && root2 == null) return false;

       if(root1.val != root2.val) return false;

       boolean isLeftSame = isSameTree(root1.left, root2.left);
       boolean isRightSame = isSameTree(root1.right, root2.right);

       return isLeftSame && isRightSame;
    }
}
