import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
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
            if(cost[i]>= money){
                continue;
            }
            else{
                int temp = money- cost[i];
                int found=-1;
                if(map.containsKey(temp)&& temp!=cost[i]){
                    found =map.get(temp).get(map.get(temp).size()-1);
                }
                else if(map.containsKey(temp)&&map.get(temp).size()>1) {
                    found =map.get(temp).get(map.get(temp).size()-1);

                }
                if(found!=-1){
                    int print =i+1;
                    System.out.println(print+" "+(found+1));
                    return;
                }

            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
