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
     * Complete the 'receivedText' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING S as parameter.
     */
// This is a partial working solution as it is not efficient.

    public static String receivedText(String s) {
    // WRITE DOWN YOUR CODE HERE
        List<Character> ret = new ArrayList();
        int home=0;
        String retVal="";
        int shome=-1;
        boolean useNumPad=true;
        for(int i =0;i<s.length();i++){
            ret.add(s.charAt(i));
        }
        for(int i=0;i<ret.size();i++){
            if(i==0 && (ret.get(i)=='*'|| ret.get(i)=='<'|| ret.get(i)=='>')){
                ret.remove(i);
                i--;
            }
            else if(i==ret.size()-1 &&(ret.get(i)=='<'|| ret.get(i)=='>'||ret.get(i)=='#')){
                ret.remove(i);
                if(shome!=-1){
                    List<Character> temp= ret.subList(shome,shome+home);
                    List<Character> x= new ArrayList();
                    x.addAll(temp);
                   for(int j=0;j<home;j++){
                        ret.remove(shome);
                    }
                     x.addAll(ret);
                    ret=x;
                    shome=-1;
                    home=0;
                }
                
            }
            //The case "Back Space" : DEL
            else if(ret.get(i)=='*'&& i>0 ){
                if(shome==i){
                    ret.remove(i);
                    i--;
                    continue;
                }
                ret.remove(i-1);
                ret.remove(i-1);
                if(shome!=-1){
                    home--;
                }           
                i-=2;
                
                if(i==ret.size()-1&&shome!=-1){
                   // System.out.println("en");
                    home--;
                    i--;
                }
            }
            // The case "HOME": < 
            else if(ret.get(i)=='<'&& i>0 &&i< ret.size()){
                if(shome!=-1){
                    List<Character> temp= ret.subList(shome,shome+home);
                    List<Character> x= new ArrayList();
                    x.addAll(temp);
                   for(int j=0;j<home;j++){
                        ret.remove(shome);
                    }
                     x.addAll(ret);
                    ret=x;
                    shome=0;
                    home=0;
                    //i--;
                }
                
                ret.remove(i);
                while(i<ret.size()&&ret.get(i)=='*'){
                    ret.remove(i);
                }
                shome=i;
                i--;
                
            }
            // The case "END": >
            else if(ret.get(i)=='>'&& i>0 &&i< ret.size()){
                if(shome!=-1){
                    List<Character> temp= ret.subList(shome,shome+home);
                   // System.out.println(Arrays.asList(temp));
                    List<Character> x= new ArrayList();
                    x.addAll(temp);
                   for(int j=0;j<home;j++){
                        ret.remove(shome);
                    }
                     x.addAll(ret);
                    ret=x;
                    shome=-1;
                    home=0;
                }
                ret.remove(i);
                while(i<ret.size()&&ret.get(i)=='*'){
                    ret.remove(i);
                }
                i--;
            }
            else if (ret.get(i)=='#'){
                if(useNumPad==true){
                    useNumPad=false;
                }
                else if(useNumPad==false){
                    useNumPad=true;
                }
                ret.remove(i);
                i--;
            }
            // CHARACTER INPUT CASE
            else{
                if(Character.isDigit(ret.get(i))&&useNumPad==false){
                    ret.remove(i);
                    i--;
                    continue;
                }
                System.out.println(home);
                if(shome!=-1){
                    home++;
                }
                if(i==ret.size()-1 && shome!=-1){
                    List<Character> temp= ret.subList(shome,shome+home);
                    List<Character> x= new ArrayList();
                    x.addAll(temp);
                   for(int j=0;j<home;j++){
                        ret.remove(shome);
                    }
                     x.addAll(ret);
                    ret=x;
                    shome=-1;
                    home=0;
                }
            }
                System.out.println(Arrays.asList(ret));
        }
        for(int i=0;i<ret.size();i++){
            retVal+=ret.get(i);
        }
        return retVal;
    }
        

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String S = bufferedReader.readLine();

        String result = Result.receivedText(S);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
