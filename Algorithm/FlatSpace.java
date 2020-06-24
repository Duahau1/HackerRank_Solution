import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
            List<Integer> retVal = new ArrayList();
            HashMap<Integer,Integer> map = new HashMap();
            for(int i=0;i<n;i++){
                map.put(i,0);
            }
            for(int i=0;i<c.length;i++){
                if(map.containsKey(c[i])){
                    map.put(c[i],map.get(c[i])+1);
                }
            }
            for(int i=0;i<n;i++){
                if(map.get(i)>0){
                        retVal.add(0);
                        continue;
                    }
                    System.out.println(i);
                   int  min=Math.abs(i-c[0]);
                for(int j=0;j<c.length;j++){
                    if(Math.abs(i-c[j])<=min){
                    min=Math.abs(i-c[j]);
                    }
                }
                    retVal.add(min);
            }
           Collections.sort(retVal,Collections.reverseOrder());
           return retVal.get(0); 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
