class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for(int i = 0; i <= n-2*k; i++){
            boolean firstOk = true;
            for(int j = i; j < i+k-1; j++){
                if(nums.get(j) >= nums.get(j+1)){
                    firstOk = false;
                    break;
                }
}
            boolean secondOk = true;
            for(int m = i+k; m < i+2*k-1; m++){
                if(nums.get(m) >= nums.get(m+1)){
                    secondOk = false;
                    break;
                }
            }
            if(firstOk && secondOk) return true;
        }
        return false;
    }
}
