import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        //At least 1 emptyspace and no odds
        HashMap<String,Integer> map = new HashMap();
        char[] after = b.replaceAll("_", "").toCharArray();
        for(int i =0; i< b.length();i++){
            String input = Character.toString(b.charAt(i));
            if(!map.containsKey(input)){
                map.put(input,1);
            }
            else{
                map.put(input,map.get(input)+1);
            }
        }
       
        for(Map.Entry<String,Integer> pairs : map.entrySet()){
                if(pairs.getValue()%2!=0 && !pairs.getKey().equals("_")){
                    if(pairs.getValue()==1){
                        return "NO";
                    }
                }
        }
         if(map.get("_")==null){
             for(int i =1; i< after.length-1;i++){
                if(after[i]!=after[i-1]&& after[i]!=after[i+1]){
                    return "NO";
                }
             }
             return "YES";
        }
        return "YES";


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
