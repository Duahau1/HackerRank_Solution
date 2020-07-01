import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
// For this problem you go in two different direction as you need to account for the fact that the scores can be in either increasing or decreasing order which will be hard
// to keep track if we are only going 1 direction.
public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] leftMov = new int[arr.length];
        int[] rightMov = new int[arr.length];
        long sum =0;
        Arrays.fill(leftMov,1);
        Arrays.fill(rightMov,1);
        for(int i =1; i< arr.length;i++){
            if(arr[i]>arr[i-1]){
                leftMov[i]=leftMov[i-1]+1;
            }
        }
        for(int i=arr.length-1; i>0;i--){
            if(arr[i-1]>arr[i]){
                rightMov[i-1]= rightMov[i]+1;
            }
        }
        for(int i=0; i< arr.length;i++){
            sum+=Math.max(rightMov[i],leftMov[i]);
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
