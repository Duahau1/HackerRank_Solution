import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */
    // This solution is about going from the base case of empty set and adding one more element per case  
    public static long getWays(int n, List<Long> c) {
    // Write your code here
        Collections.sort (c);
        long [][] matrix = new long[c.size()+1][n+1];
        for( int i =0; i < matrix.length ; i++){
            for (int j =0; j < matrix[0].length ; j++){
                // cases with n =0;
                matrix[i][0]=1;
                // If the array = [] && n > 0
                if(j>0){
                matrix[0][j] =0;
                }
                // If the added element > n -> cannot use it
                if(i>0 && c.get(i-1) > j){
                    matrix[i][j] = matrix[i-1][j];
                }
                // You can choose to use it or not use it 
                else if(i>0){
                matrix[i][j] = matrix[i][(int)(j-c.get(i-1))]+ matrix[i-1][j];
                }
            }

        }
         for( int i =0; i < matrix.length ; i++){
                if(i>0)
                System.out.print(c.get(i-1)+" ");
                else{
                    System.out.print("[] ");
                }
            for (int j =0; j < matrix[0].length ; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println(" ");
         }
        return matrix[matrix.length -1][matrix[0].length-1];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> c = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cTemp[i]);
            c.add(cItem);
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
