import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
            HashMap<Integer,Integer> map = new HashMap();
            HashMap<Integer,Integer> freq = new HashMap();
            List<Integer> ret = new ArrayList();
            for(int[] in : queries){
                int op =in[0];
                int data =in[1];
                if(op==1){
                    if(!map.containsKey(data)){
                        map.put(data,1);
                        if(!freq.containsKey(1)){
                            freq.put(1,1);
                        }
                        else{
                            freq.put(1,freq.get(1)+1);
                        }
                    }
                    else{
                        int x= map.get(data)+1;
                        if(!freq.containsKey(x)){
                            freq.put(x,1);
                            freq.put(map.get(data), freq.get(map.get(data))-1);
                                if(freq.get(map.get(data))==0){
                                    freq.remove(map.get(data));
                                }
                        }
                        else{
                            freq.put(x,freq.get(x)+1);
                            freq.put(map.get(data),freq.get(map.get(data))-1);
                                if(freq.get(map.get(data))==0){
                                    freq.remove(map.get(data));
                                }
                        }
                            map.put(data,map.get(data)+1);
                    }
                }
                else if(op==2){
                    if(map.get(data)!=null){
                        if(map.get(data)==1){
                            if(freq.get(map.get(data))==1){
                                freq.remove(map.get(data));
                            }
                            else{
                                freq.put(1,freq.get(map.get(data))-1);
                            }
                            map.remove(data);
                        }
                        else{
                            int x=map.get(data)-1;
                           if(!freq.containsKey(x)){
                                freq.put(x,1);
                                freq.put(map.get(data), freq.get(map.get(data))-1);
                                if(freq.get(map.get(data))==0){
                                    freq.remove(map.get(data));
                                }
                            }
                            else{
                            freq.put(x,freq.get(x)+1);
                            freq.put(map.get(data), freq.get(map.get(data))-1);
                                if(freq.get(map.get(data))==0){
                                    freq.remove(map.get(data));
                                }
                            }
                            map.put(data,map.get(data)-1);
                        }
                    }
                }
                else{
                    if(freq.containsKey(data)){
                        ret.add(1); 
                    }
                    else{
                        ret.add(0);
                    }
                }
            }
            return ret;

    }

    public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      List<int[]> queries = new ArrayList<>(q);
      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
      for (int i = 0; i < q; i++) {
        int[] query = new int[2];
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          query[0] = Integer.parseInt(m.group(1));
          query[1] = Integer.parseInt(m.group(2));
          queries.add(query);
        }
      }
      List<Integer> ans = freqQuery(queries);
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");
      }
    }
  }
}
