import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        class ObjCont {
            int data; 
            int index;
            public ObjCont(int data, int index){
                this.data=data;
                this.index=index;
            }
        }
        int[] sortedArray = arr.clone();
        List<Integer> ret = new ArrayList();
        Queue<ObjCont> arr_cont = new LinkedList();
        Stack<ObjCont> sorted_cont = new Stack(); 
        Arrays.sort(sortedArray);
        for(int i =0; i< arr.length; i++){
            if(arr[i]!=sortedArray[i]){
                arr_cont.add(new ObjCont(arr[i],i));
                sorted_cont.push(new ObjCont(sortedArray[i],i));
            }
        }
        if(arr_cont.size()==2){
            int left =arr_cont.poll().index+1;
            int right =arr_cont.poll().index+1;
            System.out.println("yes");
            System.out.println("swap "+left+" "+right); 
            return;
        }
        while(arr_cont.size()>0){
            ObjCont temp_arr= arr_cont.poll();
            ObjCont temp_sorted = sorted_cont.pop();
            if(temp_arr.data!=temp_sorted.data){
                System.out.println("no");
                return;
                 
            }
            ret.add(temp_arr.index);
        }
        int left =ret.get(0)+1;
        int right = ret.get(ret.size()-1)+1;
        System.out.println("yes");
        System.out.println("reverse " + left +" "+ right);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
