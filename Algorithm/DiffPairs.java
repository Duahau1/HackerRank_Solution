import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int money, int[] cost) {
        int retVal=0;
     HashMap<Integer,List<Integer>> map = new HashMap();
       for(int i = 0; i<cost.length; i++){
           if(!map.containsKey(cost[i])){
               List<Integer> listIndex = new ArrayList();
               listIndex.add(i);
               map.put(cost[i],listIndex);
           }
           else{
               map.get(cost[i]).add(i);
           }
       }
        for(int i =0; i < cost.length; i++){
                int temp = money+ cost[i];
                int found=-1;
                if(map.containsKey(temp)&& temp!=cost[i]){
                    found =map.get(temp).get(map.get(temp).size()-1);
                }
                else if(map.containsKey(temp)&&map.get(temp).size()>1) {
                    found =map.get(temp).get(map.get(temp).size()-1);

                }
                if(found!=-1){
                    retVal++;
                }

            
        }
        return retVal;
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

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
