package stack_queue_assignment_5;

import java.util.Scanner;
import java.util.Stack;
/*
Design a stack that supports push,pop,top,retrieving the minimum element in constant time.

Input Format
First line of input contains integer n denoting the size of the string array. Next line of input contains n space separated string where i-th string represent i-th operation.(i.e, push,pop,top,getMin)

Constraints
Functions pop, top and getMin operations will always be called on non-empty stacks.

Output Format
Print the answer according to input operations.

Sample Input
7
push push push getMin pop top getMin
-2 0 -3
Sample Output
-3 0 -2
Explanation
push -2
push 0
push -3
print -3 (getMin)
pop -3
print 0 (top)
print -2 (getMin)
 */
public class Min_Stack {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String a[]=new String[n];
        for(int i=0;i<n;i++){
            a[i]=sc.next();
        }
        St s=new St();
        for(int i=0;i<a.length;i++){
            if(a[i].equals("push")){
                int v=sc.nextInt();
                s.push(v);
            }
            if(a[i].equals("pop")){
                s.pop();
            }
            if(a[i].equals("top")){
                System.out.print(s.top()+" ");
            }
            if(a[i].equals("getMin")){
                System.out.print(s.getMin()+" ");
            }
        }

    }
}
class St{
    private Stack<Integer> s;
    private int min;
    St(){
        s=new Stack<Integer>();
    }
    int top(){
        int a=s.peek();
        if(a<min){
            return min;
        }
        else return a;
    }
    int pop(){
        int a=s.pop();
        int x=min;
        if(a<min){
            min=2*min-a;
            return x;
        }
        else return a;
    }
    int getMin(){
        return min;
    }
    void push(int v){
        if(s.isEmpty()){
            s.push(v);
            min=v;
            return;
        }
        if(v<min){
            s.push(2*v-min);
            min=v;
        }
        else s.push(v);
    }
}
