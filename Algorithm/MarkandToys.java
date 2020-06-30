import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    //KnapSack Problem recursive adaption . The time complexity for this method is O(2^n) and can create stack overflow.
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        /*
        if(k<0){
            return -1;
        }
        else if(k==0 || prices.length==0){
            return 0;
        } 
        else{
            int last =prices[prices.length-1];
            prices= Arrays.copyOfRange(prices,0,prices.length-1);
            int temp1 = maximumToys(prices,k-last)+1;
            int temp2= maximumToys(prices,k);
            return Math.max(temp1,temp2);
        } 
        */
        //This method is O(nlog(n)) as it does not go through the entire list 
        Arrays.sort(prices);
        if(prices[0]>k){
            return 0;
        }
        int oldk =k;
        int fit=0;
        int oldfit=fit;
        for(int i =0; i< prices.length;i++){
                k-=prices[i];
                if(k<0){
                    k=oldk;
                    continue;
                }
                else{
                    fit++;
                }
            for(int j=i+1;j< prices.length;j++){
                k-=prices[j];
                if(k<0){
                    k=oldk;
                    break;
                }
                fit++;
            }
            oldfit=Math.max(oldfit,fit);
            fit=0;
        }
        return oldfit;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
