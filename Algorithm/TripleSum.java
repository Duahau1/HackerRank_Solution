import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
// My original work is right but it was not efficient. The algorithm for this one is basically just need to care about the middle array as indeed if we are at the end of it we are
//done. There are parts that are repeated that are dependant on b array.
  /*
    static long triplets(int[] ar, int[] br, int[] cr) {
        int[] a = Arrays.stream(ar).sorted().distinct().toArray();
        int[] b = Arrays.stream(br).sorted().distinct().toArray();
        int[] c = Arrays.stream(cr).sorted().distinct().toArray();
        long retVal =0;
        int a_i=0;
        int b_i=0;
        int c_i=0;
        while(b_i<b.length){
            while(a_i<a.length && a[a_i]<=b[b_i]){
                a_i++;
            }
            while(c_i<c.length && c[c_i]<=b[b_i]){
                c_i++;
            }
            retVal+=(long)a_i*(long)c_i;
            b_i++;
        }

        return retVal;

     }
*/
    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        HashMap<String,Integer> map = new HashMap();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int a_i=0;
        int b_i=0;
        int c_i=0;
        long retVal =0;
        while(a_i<a.length){
            // if p <=q 
            if(a[a_i]<=b[b_i]){
                //if r<=q
                if(b[b_i]>=c[c_i]){
                    String temp = a[a_i]+"_"+b[b_i]+"_"+c[c_i];
                    if(!map.containsKey(temp)){
                        map.put(temp,1);
                        retVal++;
                    }
                    if(c_i+1<c.length){
                        c_i++;
                    }
                    else{

                        if(b_i+1<b.length){
                            b_i++;
                            c_i=0;
                        }
                        else {
                            if(a_i+1<a.length){
                            a_i++;
                            b_i=0;
                            c_i=0;
                            }
                            else{
                                break;
                            }
                        }    
                    }
                }
                // if r>q then the rest of r is greater than q
                else{
                    if(b_i+1<b.length){
                        b_i++; 
                        c_i=0;                    
                    }
                    else{
                        if(a_i+1<a.length){
                        a_i++;
                        b_i=0;
                        c_i=0;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            //if p>q
            else {
                if(b_i+1<b.length){
                    b_i++;
                }
                else{
                     break;
                }
            }
        }
        return retVal;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
