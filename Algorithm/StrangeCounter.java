import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
/*
There are 2 ways to do this problem, my way is a more complex way than it should be and one of the guy under the discussion section  offer a very simple nice solution
where you search for which cycle you are in (cycle 1 has 3, cycle 2 has 6 ,...) then you just need to subtract where you are in that cycle and then add one as the countdown 
only goes to 1 not 0. 
*/
    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        /*
        long retVal=0;
        long counter=0;
        long sum = 0;
        while(sum+3*Math.pow(2,counter)<t){
            sum+=3*Math.pow(2,counter);
            counter++;
        }
        retVal = (3*(long)Math.pow(2,counter)-(t-sum-1));
        return retVal;
*/
        long rem = 3;
        while (t > rem){
            t = t-rem;
            rem *= 2;
        }
        return (rem-t+1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
