import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
/*
It is running in O(n) times and there are 3 big  cases to consider
  + Case 1: There are frequencies that are greater than the minFrequency+1
  + Case 2: There is more than 1 frequency that does not match the common frequency and occurs more than 1 time
  + Case 3: The 1 frequency occurs more than 1 time when the commonfrequency is larger than 1
 */
 // Complete the isValid function below.
    static String isValid(String s) {
        int minFrequency= Integer.MAX_VALUE;
        int commonFrequency= Integer.MIN_VALUE;
        int temp =Integer.MIN_VALUE;
        HashMap<String, Integer> map = new HashMap();
        HashMap<Integer,Integer> freq= new HashMap();
        boolean minF=true;
        boolean comF=true;
        boolean enter=false;
        boolean exit =false;
        for(int i =0; i< s.length();i++){
            String input =String.valueOf(s.charAt(i));
            if(!map.containsKey(input)){

                map.put(input,1);
            }
            else{
                map.put(input,map.get(input)+1);
            }
        }
        for(Map.Entry<String,Integer> pair : map.entrySet()){
            if(!freq.containsKey(pair.getValue())){
                freq.put(pair.getValue(),1);
            }
            else{
                freq.put(pair.getValue(),freq.get(pair.getValue())+1);
            }
            if(pair.getValue()<minFrequency){
                minFrequency=pair.getValue();
            }
        }
        for(Map.Entry<String,Integer> pair : map.entrySet()){
            
            if(pair.getValue()>minFrequency){
                if(pair.getValue()==minFrequency+1 && !enter){
                    enter=true;
                    continue;
                }
                minF=false;
                break;
            } 
        }
        for(Map.Entry<Integer,Integer> pair: freq.entrySet()){
                if(pair.getValue()>temp){
                    commonFrequency=pair.getKey();
                    temp=pair.getValue();
                }            
        }
        for(Map.Entry<Integer,Integer> pair: freq.entrySet()){
                if(pair.getValue()==1 && pair.getKey()!=commonFrequency){
                    if(!exit){
                    exit=true;
                    continue;
                    }
                    comF=false;
                    break;
                }
                else if(pair.getKey()==1 && pair.getValue()>1 || freq.get(1)==null){
                    comF=false;
                    break;
                }            
        }
        if(minF||comF){
            return "YES";
        }
        else{
            return "NO";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
