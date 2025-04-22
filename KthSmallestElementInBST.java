class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        InOrder(root, k, list);
        return list.get(k-1);
    }

    public void InOrder(TreeNode root, int k, List<Integer> list){
        if(root == null) return;
        InOrder(root.left, k, list);
        list.add(root.val);
        InOrder(root.right, k, list);
    }
}
