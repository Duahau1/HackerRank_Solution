import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the larrysArray function below.
    /*
    This algorithm is based on the odd and even partion where it depends on the number of inversion to make the array satisfy 2 conditions: 
        { 1. a[i]<a[j] 2. i<j} so the inversion happen when the first condition is opposite. If the number of inversion is odd then it means the we cannot invert the array
        back to ascending order whereas if the inversion is even we can rotate between 3 elements and sort it.
        
    */
    static String larrysArray(int[] A) {
        int count=0;
        for(int i =0; i< A.length;i++){
            for(int j=i+1; j< A.length;j++){
                if(A[i]>A[j]){
                    count++;
                }
            }
        }
        if(count%2==0){
            return "YES";
        }
        else{
            return "NO";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            String result = larrysArray(A);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
