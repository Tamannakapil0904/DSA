class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        int[] prefiSum = new int[n];

        prefiSum[0] = s.charAt(0)-'a'+1;
        for(int i = 1; i < n; i++){
            prefiSum[i] = prefiSum[i-1] + (s.charAt(i) - 'a' + 1);
            
        }
        for(int i = 0; i < n - 1; i++){
            int left = prefiSum[i];
            int right = prefiSum[n-1] - prefiSum[i];
            if(left == right){
                return true;
                
            }
        }
        return false;
    }
}
