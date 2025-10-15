class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] incLen = new int[n];
        incLen[n-1] = 1;
        for(int i = n - 2; i >= 0; i--){
            if(nums.get(i) < nums.get(i+1)){
                incLen[i] = incLen[i+1] + 1;
            }
            else{
                incLen[i] = 1;
            }
        }
        int low = 1, high = n/2, ans = 0;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(check(incLen, mid)){
                ans = mid;
                low = mid+1;
            }
else{
                high = mid-1;
            }
        }
        return ans;
    }
    private boolean check(int[] incLen, int k){
        int n = incLen.length;
        for(int i = 0; i <= n-2*k; i++){
            if(incLen[i] >= k && incLen[i+k] >= k){
                return true;
            }
        }
        return false;
        
    }
}

