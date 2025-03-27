class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int dom = 0, count = 0, n = nums.size();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > n/2){
                dom = entry.getKey();
                count = entry.getValue();
                break;
            }
        }
int leftCount = 0;
        for(int i = 0; i < n-1; i++){
            if(nums.get(i) == dom) leftCount++;
            int leftSize = i+1;
            int rightSize = n-leftSize;
            int rightCount = count-leftCount;

            if(leftCount > leftSize/2 && rightCount > rightSize/2){
                return i;
            }
        }
        return -1;
    }
}
