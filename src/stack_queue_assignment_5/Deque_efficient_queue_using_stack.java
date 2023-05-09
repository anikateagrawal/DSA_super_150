package stack_queue_assignment_5;
/*
Implement a Queue using two stacks Make it Dequeue efficient.

Input Format
Enter the size of the queue N add 0 - N-1 numbers in the queue

Constraints
Output Format
Display the numbers in the order they are dequeued and in a space separated manner

Sample Input
5
Sample Output
0 1 2 3 4
 */
import java.util.Scanner;
import java.util.Stack;

public class Deque_efficient_queue_using_stack {
    public static void main(String args[]) {
        // Your Code Here
        Scanner scn=new Scanner(System.in);
        MyQueue q=new MyQueue();
        int num=scn.nextInt();

        for(int index=0;index<num;index++)
        {
            q.push(index);
        }
        while(!q.empty()){
            System.out.print(q.pop()+" ");
        }

    }

}

class MyQueue {
    private int front;
    private Stack<Integer> s1 ;
    private Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
        front=-1;
    }

    public void push(int x) {
        if (s1.empty())
            front = x;
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    public int pop() {
        int res = s1.pop();
        if (!s1.empty())
            front = s1.peek();
        return res;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

