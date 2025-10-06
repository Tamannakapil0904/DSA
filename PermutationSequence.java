class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n];
        StringBuilder sb = new StringBuilder();

        int f = 1;
        for(int i = 0; i < n; i++){
            nums.add(i+1);
            f *= (i+1);
            fact[i] = f;
        }
        k--;

        for(int i = n; i >= 1; i--){
            f = fact[i-1] / i;
            int index = k / f;
            sb.append(nums.get(index));
            nums.remove(index);
            k %= f;
        }
        return sb.toString();
    }
}
