package stack_queue_assignment_5;

import java.util.Scanner;
/*
Reverse a Stack using Recursion. Do not use any extra stack.

Input Format
First line contains an integer N (size of the stack).
Next N lines follow each containing an integer to be stored in the stack where the last integer is at the top of the stack.

Constraints
1 <= N <= 10^4

Output Format
Output the values of the reversed stack with each value in one line each.

Sample Input
3
3
2
1
Sample Output
3
2
1
Explanation
Original Stack = [ 3 , 2 , 1 ] <-TOP
Reverse Stack = [ 1 , 2 , 3 ] <-TOP
 */
public class REVERSE_A_STACK_USING_RECURSION {
    public static void main(String args[]) throws Exception {
        // Your Code Here
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        REVERSE_A_STACK_USING_RECURSION mainobj = new REVERSE_A_STACK_USING_RECURSION();
        StacksUsingArrays obj = mainobj.new StacksUsingArrays(N);
        StacksUsingArrays helper=mainobj.new StacksUsingArrays(N);
        for(int i=1;i<=N;i++){
            obj.push(s.nextInt());
        }
        obj.reverseStack(obj, helper, 0);
        obj.display();

    }

    private class StacksUsingArrays {
        private int[] data;
        private int tos;

        public static final int DEFAULT_CAPACITY = 10;

        public StacksUsingArrays() throws Exception {
            // TODO Auto-generated constructor stub
            this(DEFAULT_CAPACITY);
        }

        public StacksUsingArrays(int capacity) throws Exception {
            if (capacity <= 0) {
                System.out.println("Invalid Capacity");
            }
            this.data = new int[capacity];
            this.tos = -1;
        }

        public int size() {
            return this.tos + 1;
        }

        public boolean isEmpty() {
            if (this.size() == 0) {
                return true;
            } else {
                return false;
            }
        }

        public void reverseStack(StacksUsingArrays stack, StacksUsingArrays helper, int idx) throws Exception {
            rev(stack);
        }
        void insert(StacksUsingArrays s,int v)throws Exception{
            if(s.isEmpty()){
                s.push(v);
                return;
            }
            int p=s.pop();
            insert(s,v);
            s.push(p);
        }
        void rev(StacksUsingArrays s ) throws Exception{
            if(s.isEmpty())return;
            int p=s.pop();
            rev(s);
            insert(s,p);
        }
        public void push(int item) throws Exception {
            if (this.size() == this.data.length) {
                throw new Exception("Stack is Full");
            }
            this.tos++;
            this.data[this.tos] = item;
        }

        public int pop() throws Exception {
            if (this.size() == 0) {
                throw new Exception("Stack is Empty");
            }
            int retVal = this.data[this.tos];
            this.data[this.tos] = 0;
            this.tos--;
            return retVal;
        }

        public int top() throws Exception {
            if (this.size() == 0) {
                throw new Exception("Stack is Empty");
            }
            int retVal = this.data[this.tos];
            return retVal;
        }

        public void display() throws Exception {
            if (this.size() == 0) {
                throw new Exception("Stack is Empty");
            }
            for (int i = this.tos; i >= 0; i--) {
                System.out.println(this.data[i]);
            }

        }

    }

}
