import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        if(s.trim().isEmpty()){
          System.out.println("0");
        }
        else{
            String[] words = s.trim().split("[\\W_]+");
            int count = 0;
            for(int i = 0; i< words.length; i++){
                count++;
            }
            System.out.println(count);
            for(String word : words){ 
              System.out.println(word);
            }
        }
        scan.close();
    
    }
}
