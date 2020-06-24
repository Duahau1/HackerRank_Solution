import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int page=0;
        int match=0;
        int problem=0;
        int oldproblem=0;
        for(int i=0;i<n;i++){
            while(arr[i]-k>0){
                page++;
                problem+=k;
                if(page<=problem && page>=oldproblem+1){
                    System.out.println(oldproblem+" "+page+" "+problem);
                    match++;
                }
                oldproblem=problem;
                arr[i]-=k;
                
            }
            if(arr[i]>0){
                page++;
                if(page<=problem+arr[i] && page>=oldproblem+1){
                    match++;
                }
            }
            oldproblem=0;
            problem=0;   
        }
        return match;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
