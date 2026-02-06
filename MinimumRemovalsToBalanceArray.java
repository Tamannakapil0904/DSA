class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 1;
        int j = 0;

        for(int i = 0; i < n; i++){
            while(j < n && (long) nums[j] <= (long) k * nums[i]){
                j++;
            }
            maxLen = Math.max(maxLen, j-i);
        }
        return n - maxLen;
    }
}
