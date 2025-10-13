class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        String prevSorted = "";
        for(String word : words){
          char[] chars = word.toCharArray();
          Arrays.sort(chars);

          String sorted = new String(chars); //can use String.valueOf(chars) for cleaner code
          if(!sorted.equals(prevSorted)){
            list.add(word);
            prevSorted = sorted;
          }  
             
        }
        return list;
    }
}
