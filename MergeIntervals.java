class Solution {
    public int[][] merge(int[][] intervals) {
        //Sort intervals by start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals){
            //if merged is empty or no overlap, add interval
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]){
                merged.add(interval);
            }
            else{
                //Overlap: merge with last interval
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }
        }
        //convert list to array
        return merged.toArray(new int[merged.size()][]);
    }
}
