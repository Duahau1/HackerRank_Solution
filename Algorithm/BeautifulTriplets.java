import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
    HashMap<Integer,Integer> l = new HashMap();
    List<Integer> h = new ArrayList();
    int retVal=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]>=d){
            h.add(arr[i]);
        }
        if(!l.containsKey(arr[i])){
            l.put(arr[i],1);
        }
        else{
            l.put(arr[i],l.get(arr[i])+1);
        }
    }
    for(Integer temp: h){
        int x= temp+d;
        int y= temp-d;
        if(l.containsKey(y) && l.containsKey(x)){
            retVal+=l.get(y)*l.get(x);
        }
    }
    return retVal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
