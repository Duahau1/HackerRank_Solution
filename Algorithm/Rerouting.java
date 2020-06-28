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

class Result {

    /*
     * Complete the 'getMinConnectionChange' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY connection as parameter.
     */
    // Trying DFS on this problem 
    public static int getMinConnectionChange(List<Integer> connection) {
    // Write your code here
       
        //Simple Class to store the vertice and the next vertice they connect to
        class VerticeE{
           private VerticeE connectTo;
           private boolean visited;
           private int verNum; 
           public VerticeE(int verNum){
               this.verNum=verNum;
               this.visited=false;
               this.connectTo=null;
           }
           
            public int getNum(){
                return verNum;
            }
            public VerticeE getConnect(){
                return this.connectTo;
            }
            public void setConnect(VerticeE c){
                this.connectTo=c;
            }
            public void setVisted(boolean value){
                this.visited =value;
            }
            public boolean getVisted(){
                return this.visited;
            }
       }
        // Establish all the vertices in this list
        List<VerticeE> list = new ArrayList();
        for(int i =0;i< connection.size();i++){
            VerticeE newV = new VerticeE(i+1);
            list.add(newV);                    
        }
        for(int i=0;i<connection.size();i++){
            if(i+1!=connection.get(i)){
                list.get(i).setConnect(list.get(connection.get(i)-1));
            }
        }
        
        //Doing DFS to detect cycle 
        int ex=0;
        Stack<VerticeE> s = new Stack();
        HashSet<Integer> set = new HashSet();
        for(VerticeE x: list){
            if(x.getVisted()==false){
                x.setVisted(true);
                s.push(x);
                while(!s.isEmpty()){
                    VerticeE temp =s.pop();
                    if(temp.getConnect()!=null){
                        if(temp.getConnect().getVisted()==true){
                            VerticeE trace = temp.getConnect();
                            int count =0;
                            boolean found=false;
                            while(count!=list.size()){
                                if(set.contains(trace.getNum())){
                                    found=true;
                                    break;
                                }
                                   trace=trace.getConnect();
                                count++;
                            }
                            if(found==false){
                            temp.getConnect().setConnect(null);
                            ex++;
                            set.add(temp.getConnect().getNum()); 
                            }
                            break;
                        }
                        
                        else{
                            temp.getConnect().setVisted(true);
                            s.push(temp.getConnect()); 
                        }
                    }
                    else{
                            set.add(temp.getNum());
                    }
                    
                }
            }
        }
        //If the number of cycle is greater than the number of minimum way return the cycle number
        if(ex>set.size()-1){
            return ex;
        }
        else
        return set.size()-1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> connection = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.getMinConnectionChange(connection);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
