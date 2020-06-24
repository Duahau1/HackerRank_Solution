import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String[] onedigit= {
          "","one","two","three","four","five","six","seven","eight","nine"  
        };
        String[] twodigit={
            "ten","eleven","twelve","thirteen","fourteen","quarter","sixteen",                      "seventeen","eighteen","nineteen","twenty"
        };
        String hour="";
        String min="";
        if(m==0){
           if(h<9){
            hour= onedigit[h];
            }
            else{
            hour=twodigit[h-10];
            }
            min=" o\' clock";
            return hour+min;
        }
        else if(m>=1 && m<=30){
            if(h<9){
            hour= onedigit[h];
            }
            else{
            hour=twodigit[h-10];
            }
            if(m>=1&&m<=9){
                if(m==1){
                    min= onedigit[m]+ " minute past ";
                }
                else{
                    min= onedigit[m]+ " minutes past ";
                }
                return min+hour;
            }
            else if(m>=10&&m<=20) {
                if(m==15){
                    min=twodigit[m-10]+" past ";
                }
                else{
                min=twodigit[m-10]+" minutes past ";
                }
                return min+hour;
            }
            else if(m>20&& m<30){
                m=m%10;
                min="twenty "+onedigit[m]+" minutes past ";
                return min+hour;
            }
            else{
                return "half past "+hour;
            }
        }
        else{
            if(h<9){
                hour= onedigit[h+1];
            }
            else{
            if(h==12){
                hour="one";
            }
            else{
                hour=twodigit[h-9];
            }
            }
            if(60-m>=1&& 60-m<=9){
                if(60-m==1){
                    min= onedigit[60-m]+ " minute to ";
                }
                else{
                    min= onedigit[60-m]+ " minutes to ";
                }
                return min+hour;
            }
            else if(60-m>=10&&60-m<=20){
                if(m==45){
                     min=twodigit[50-m]+" to ";
                }
                else{
                min=twodigit[50-m]+" minutes to ";
                }
                return min+hour;
            }
            else if(60-m>20&& 60-m<30){
                m=(60-m)%10;
                min="twenty "+onedigit[m]+" minutes to ";
                return min+hour;
            }
        }
        return "";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
