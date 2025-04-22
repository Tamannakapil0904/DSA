class Solution {
    public boolean isValidBST(TreeNode root) {
    return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(!(min < root.val && root.val < max)) return false;
        boolean isLeftBST = validBST(root.left, min, root.val);
        boolean isRightBST = validBST(root.right, root.val, max);
        return isLeftBST && isRightBST;
    }
}
