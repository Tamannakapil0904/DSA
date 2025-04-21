class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Calculate(root, targetSum, res, new ArrayList<>());
        return res;
    }

    private void Calculate(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> list){
       if(root == null) return;
       list.add(root.val);
       if(root.left == null && root.right == null && targetSum == root.val){
            res.add(new ArrayList<>(list));
       }
       else{
        Calculate(root.left, targetSum - root.val, res, list);
        Calculate(root.right, targetSum - root.val, res, list);

       }
       list.remove(list.size() - 1);
    }
}
