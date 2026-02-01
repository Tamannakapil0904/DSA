class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            for(int j = i+1; j < n; j++){
                minCost = Math.min(minCost, nums[0] + nums[i] + nums[j]);
            }
        }
        return minCost;
    }
}
