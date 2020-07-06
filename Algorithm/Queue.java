import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

     static class MyQueue<T>{
        private Queue<T> q;
        public MyQueue(){
            q= new LinkedList<T>();
        }
        public void enqueue(T input){
            q.add(input);
        }
        public T peek(){
            if(q.size()>0){
                return q.peek();
            }
            else{
                return null;
            }
        }
        public void dequeue(){
            if(q.size()>0){
                q.remove();
            }
        }
    }
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
