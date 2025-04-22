class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        //base case
        if(root == null) return 0;

        if(root.val > high){
            return rangeSumBST(root.left, low, high);

        }
        else if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }
       else{
         //recursion
            int leftRangeSum = rangeSumBST(root.left, low, high);
            int rightRangeSum = rangeSumBST(root.right, low, high);

            return leftRangeSum + rightRangeSum + root.val;
        }
    }
}
