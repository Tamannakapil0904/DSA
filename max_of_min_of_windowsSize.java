import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while(t-- > 0){
      String line = sc.nextLine();
      String[] input = line.split(" ");
      int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      Solution solution = new Solution();
      ArrayList<Integer> result = solution.maxOfMins(arr);
      for(int val : result) {
        System.out.print(val + " ");
      }
      System.out.println();
      System.out.println("~");
    }
    sc.close();
  }
}

class Solution{
  public ArrayList<Integer> maxOfMins(int[] arr){
    int n = arr.length;
    int[] left = new int[n];
    int[] right = new int[n];

    Arrays.fill(left, -1);
    Arrays.fill(right, n);

  Stack<Integer> s = new Stack<>();

  for(int i = 0; i < n; i++){
    while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
      s.pop();
    }
    if(!s.isEmpty()){
      left[i] = s.peek();
    }
    s.push(i);
  }
    s.clear();
    for(int i = n - 1; i >= 0; i--){
      while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
        s.pop();
      }
      if(!s.isEmpty()){
        right[i] = s.peek();
      }
      s.push(i);
    }

  int[] ans = new int[n+1];
 Arrays.fill(ans, 0);
  for(int i = 0; i < n; i++){
    int length = right[i] - left[i] - 1;
    ans[length] = Math.max(ans[length], arr[i]);
  }

  for(int i = n - 1; i >= 1; i--){
    ans[i] = Math.max(ans[i], ans[i+1]);
  }
    ArrayList<Integer> result = new ArrayList<>();
    for(int i = 1; i <= n; i++){
      result.add(ans[i]);
    }
    return result;
  }
}
