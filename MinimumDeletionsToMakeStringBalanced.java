class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int deletions = 0;

        for(char c : s.toCharArray()){
            if(c == 'a'){
                deletions = Math.min(deletions+1, countB);
            }
            else{
                countB++;
            }
        }
        return deletions;
    }
}
