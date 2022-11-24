package stack_queue;

import java.util.Scanner;
import java.util.Stack;
public class stock_span {
    public static void main(String args[])  {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int sp[]=new int[n];
        Stack<Integer> s=new Stack<Integer>();
        for (int i = 0; i < a.length; i++) {
            while(!s.isEmpty()&& a[i]>=a[s.peek()]){
                s.pop();
            }
            if(!s.isEmpty())
                sp[i]=i-s.peek();
            else sp[i]=i+1;
            s.push(i);

        }
        for(int i=0;i<n;i++){
            System.out.print(sp[i]+" ");
        }
        System.out.print("END");
    }

}
