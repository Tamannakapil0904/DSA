class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccurence = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            lastOccurence.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for(int i = 0; i<s.length(); i++){
            end = Math.max(end, lastOccurence.get(s.charAt(i)));
            if(i == end){
                result.add(end-start+1);
                start = i+1;
            }
        }
        return result;
    }
}
