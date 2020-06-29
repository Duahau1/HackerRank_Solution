 import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int sum  (int n){
        if(n==0){
            return 0;
        }
        else{
            return n+sum(n-1);
        }
    }
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String,Integer> map = new HashMap();
        int match =0;
        for(int i =0; i<s.length();i++){
            for(int j =i; j< s.length();j++){
                String temp = s.substring(i,j+1);
                char [] x = temp.toCharArray();
                Arrays.sort(x);
                String input = new String(x);
                if(!map.containsKey(input)){
                    map.put(input, 0);
                }
                else{
                    map.put(input,map.get(input)+1);
                }
            }
        }
        for(Map.Entry<String,Integer> p : map.entrySet()){
            System.out.println(p.getKey()+" "+p.getValue());
            if(p.getValue()>0){
                match+=sum(p.getValue());
            }
        }
        return match;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
