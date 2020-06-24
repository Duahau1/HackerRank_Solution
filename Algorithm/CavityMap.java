import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        int[][]retVal=new int[grid.length][grid[0].length()];
        for(int i=0;i<grid.length;i++){
            for(int j= 0;j<grid[0].length();j++){
                retVal[i][j]=Integer.parseInt(String.valueOf(grid[i].charAt(j)));
            }
        }
        for(int i=1;i<=retVal.length-2;i++){
            for(int j=1;j<=retVal.length-2;j++){
        if(retVal[i-1][j]<retVal[i][j]&&retVal[i][j]>retVal[i+1][j]&&retVal[i][j-1]<retVal[i][j]&& retVal[i][j]>retVal[i][j+1]){
            String temp=grid[i].substring(0,j);
            temp+="X";
            temp+=grid[i].substring(j+1);
            grid[i]=temp;
            System.out.println(temp);
                }   
            }
        }
        return grid;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
