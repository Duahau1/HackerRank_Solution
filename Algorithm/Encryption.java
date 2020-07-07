import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    /*
    You just moving up from the lower bound to check whether the number of rows multiply the number of cols is greater than or equal to the length of string s  
    */
    
    static String encryption(String s) {
        int low_bound = (int)Math.floor(Math.sqrt(s.length()));
        int up_bound = (int)Math.ceil(Math.sqrt(s.length()));
        int rows=0;
        int cols=0;
        for(int i=low_bound ; i<= up_bound;i++){
            if(i*up_bound>=s.length()){
                rows=i;
                cols=up_bound;
                 break;
            }
        }
        String retVal ="";
        String[] compose = new String[cols];
        Arrays.fill(compose, "");
        char[][] hash = new char[rows][cols];
        int count=0;
        for(int i =0; i< rows; i++){
            for(int j =0; j< cols && count<s.length(); j++){
                hash[i][j]=s.charAt(count);
                count++;
            }
        }
        for(int i =0; i<cols; i++){
            for(int j = 0; j<rows; j++){
                compose[i]+=hash[j][i];
            }
        }
        for(String x: compose){
            retVal += x.trim() +" ";
        }
        return retVal.trim();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
