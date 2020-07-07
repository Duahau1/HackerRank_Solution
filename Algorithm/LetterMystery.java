import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        Queue<Character> left = new LinkedList();
        Queue<Character> right = new LinkedList();
        int count=0;
      
        if(s.length()%2==0){
            for(int i=0; i< s.length()/2;i++){
                left.add(s.charAt(i));
            }
            for(int i=s.length()-1; i>=s.length()/2;i--){
                right.add(s.charAt(i));
            }
            while(left.size()>0){

    count+=Math.abs(String.valueOf(left.poll()).compareTo(String.valueOf(right.poll())));
            }
            return count;
        }
        else {
            for(int i=0; i< (s.length()-1)/2;i++){
                left.add(s.charAt(i));
                System.out.println("left "+ s.charAt(i));
            }
            for(int i=s.length()-1; i>=((s.length()-1)/2)+1;i--){
                right.add(s.charAt(i));
                 System.out.println("right "+ s.charAt(i));

            }
            while(left.size()>0){
    count+=Math.abs(String.valueOf(left.poll()).compareTo(String.valueOf(right.poll())));
            }
            return count;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
