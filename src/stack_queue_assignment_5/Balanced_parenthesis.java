package stack_queue_assignment_5;

import java.util.Scanner;
/*
You are given a string of brackets i.e. '{', '}' , '(' , ')', '[' , ']' . You have to check whether the sequence of parenthesis is balanced or not.
For example, "(())", "(())()" are balanced and "())(", "(()))" are not.

Input Format
A string of '(' , ')' , '{' , '}' and '[' , ']' .

Constraints
1<=|S|<=10^5

Output Format
Print "Yes" if the brackets are balanced and "No" if not balanced.

Sample Input
(())
Sample Output
Yes
Explanation
(()) is a balanced string.
 */
public class Balanced_parenthesis {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        String str = s.next();
        Balanced_parenthesis mainobj = new Balanced_parenthesis();
        StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000);
        if (isBalanced(str, stack)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    public static boolean isBalanced(String str, StacksUsingArrays stack) throws Exception {
        String s=str;
        for(int i=0;i<str.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }
            else if(stack.isEmpty())return false;
            else if(ch==')'&&stack.top()=='(')stack.pop();
            else if(ch=='}'&& stack.top()=='{')stack.pop();
            else if(ch==']'&& stack.top()=='[')stack.pop();
            else return false;
        }
        if(stack.isEmpty())return true;
        return false;

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
