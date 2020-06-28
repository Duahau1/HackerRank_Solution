import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    // The code just get the correct number to the correct spot.
    static int minimumSwaps(int[] arr) {
        int [] sorted = arr.clone();
        int temp=0;
        Arrays.sort(sorted);
        int unmatch=0;
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
            if(arr[i]!=sorted[i]){
                temp =arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i] =temp;
                unmatch++;
                i--;
            }
        }
        return unmatch;

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

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
