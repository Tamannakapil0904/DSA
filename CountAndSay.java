class Solution {
    public String countAndSay(int n) {
        String curr = "1";
        if(n==1) return curr;
        for(int i = 2; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char ele = curr.charAt(0);
            for(int j=1; j<curr.length(); j++){
                char currChar = curr.charAt(j);
                if(currChar == ele)
                count++;
                else{
                    sb.append(count).append(ele);
                    ele = currChar;
                    count = 1;

                }
            }           sb.append(count).append(ele);
            curr = sb.toString();
        }
        return curr;
    }
}
