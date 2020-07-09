import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
  /* 
  Cach nay la minh se k quan tam den cai call stack va se dung recursion de tao ra tat ca permuatation cua string sau do minh se sort va tim cai string vua lon hon no */
*/
   static String swap(String s, int a, int b){
            char[] temp = s.toCharArray();
            char c = temp[b];
            temp[b]=temp[a];
            temp[a]=c;
            return new String(temp);
    }
    static void allPermutation(String s,int low, int high ,List<String> ret){
        if(low==high){
            ret.add(s);
        }
        else{
            for(int i =low ; i<=high; i++){
                s=swap(s, low ,i);
                allPermutation(s,low+1,high,ret);
            }
        }

    }
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        List<String> ret = new ArrayList();
        String retVal =" ";
        allPermutation(w, 0, w.length()-1, ret);
        Collections.sort(ret);
        boolean found=false;
        for(String comp : ret){
            if(found==true){
                if(comp.compareTo(w)==0){
                    continue;
                }
                retVal =comp;
                break;
            }
            if(comp.compareTo(w)==0){
                found=true;
            }
        }
        if(retVal==" "){
            return "no answer";
        }
        return retVal;

    }
    /*
    Cach nay don gian la theo thuat toan nayuki.io/page/next-lexicographical-permutation-algorithm 
    
    Chang han nhu t co cac so sau 01235584 va yeu cau ta tim permutation tiep theo lon hon no 
    Dau tien ta se scan day tu phai sang trai va tim increasing order sequence va se nhin ve so ben trai cua no tam goi la pivot. Dua vao pivot,
    Ta se can cu lam va tim so tiep theo o day cu va lon hon so pivot sau do swap 2 cai nay voi nhau de tao ra mot so vua lon hon . Sau do t reverse the increasing order sequence va 
    ta co dc ket qua.
    01235584 -> [84] pivot =5 boi vi 5 < 8 
    01235854 -> [45] boi vi 8 >5 in sequence
    01235845 sau khi reverse [45] de dc [54]
    */
 static String biggerIsGreater(String w) {
        char[] cont = w.toCharArray();
        int p_index = -1;
        for(int i =w.length()-1; i>0; i--){
            if(cont[i]>cont[i-1]){
                p_index= i-1;
                break;
            }
        }
        if(p_index==-1){
            return "no answer";
        }
        else {
            for( int i = w.length() -1; i>0 ;i--){
                if(cont[i]>cont[p_index]){
                    //swap
                    char temp = cont[i];
                    cont[i]=cont[p_index];
                    cont[p_index]= temp; 
                    break;
                }
            }
            char[] right = Arrays.copyOfRange(cont, p_index+1, cont.length);
            char[] left = Arrays.copyOfRange(cont, 0, p_index+1);
            
            String ret2 = new String(right);
            StringBuilder b = new StringBuilder(ret2);
            b =b.reverse();
            String ret1 = new String(left);
            return ret1+b.toString();
        }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
