import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
This method consider 3 difference scenerio :
  + The current value at the index 
  + The max value so far you have 
  + The max value from 2 position away from where you at plus the current value you have 
We remember the max value of each index using another linear array 

*/
public class Solution {
    static int max(int a, int b , int c){
        return Math.max(Math.max(a,b),Math.max(b,c));
    }
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        // The value of the max two position away plus the the index 
        int[] currentMax= new int[arr.length];
        currentMax[0]=arr[0];
        // The max value so far
        int maxSoFar=arr[0];
        for(int i =1;i< arr.length;i++){
            //The value at the index
            int posValue=arr[i];
            if(i-2>=0){
                currentMax[i]=currentMax[i-2]+posValue;
                currentMax[i]=maxSoFar=max(posValue, maxSoFar,currentMax[i]);
            }
            else{
                maxSoFar=max(posValue, maxSoFar, currentMax[i-1]);
                currentMax[i]=maxSoFar;
            }
        }
        return maxSoFar;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
