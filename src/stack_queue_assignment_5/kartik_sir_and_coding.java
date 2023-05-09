package stack_queue_assignment_5;

import java.util.Scanner;
/*
Kartik sir loves coding. Hence, he took up the position of an instructor and founded Coding Blocks, a startup that serves students with awesome code modules. It is a very famous place and students are always queuing up to have one of those modules. Each module has a cost associated with it. The modules are kept as a pile. The job of an instructor is very difficult. He needs to handle two types of queries:

1) Student Query: When a student demands a module, the code module on the top of the pile is given and the student is charged according to the cost of the module. This reduces the height of the pile by 1. In case the pile is empty, the student goes away empty-handed.

2) Instructor Query: Sir prepares a code module and adds it on top of the pile. And reports the cost of the module. Help him manage this process.

Input Format
First line contains an integer Q, the number of queries. Q lines follow. A Type-1 ( Student ) Query, is indicated by a single integer 1 in the line. A Type-2 ( Instructor ) Query, is indicated by two space separated integers 2 and C (cost of the module prepared) .

Constraints
Q < 10^5

Output Format
For each Type-1 Query, output the price that student has to pay i.e. cost of the module given to the customer in a new line. If the pile is empty, print "No Code" (without the quotes).

Sample Input
7
2 73
2 83
2 43
1
1
2 16
2 48
Sample Output
43
83
Explanation
Iteration 1 :
Input : 2 73
Stack : 73 <- Top

Iteration 2 :
Input : 2 83
Stack : 73, 83 <- Top

Iteration 3 :
Input : 2 43
Stack : 73, 83,43 <- Top

Iteration 4 :
Input : 1
Print and pop 43
Stack : 73, 83 <- Top

Iteration 5 :
Input : 1
Print and pop 83
Stack : 73 <- Top

Iteration 6 :
Input : 2 16
Stack : 73, 16 <- Top

Iteration 7 :
Input : 2 48
Stack : 73, 16, 48 <- Top

 */
public class kartik_sir_and_coding {
    static Scanner s = new Scanner(System.in);
    public static void main(String args[]) throws Exception {
        // Your Code Here
        int q = s.nextInt();
        StacksUsingArrays stack = new StacksUsingArrays();
        Calculate(stack, q);
    }

    public static void Calculate(StacksUsingArrays stack, int q) throws Exception {
        for(int i=0;i<q;i++){
            int qq=s.nextInt();
            if(qq==2){
                stack.push(s.nextInt());
            }
            else {
                try{
                    int v=stack.pop();
                    System.out.println(v);
                }
                catch(Exception e){
                    System.out.println("No Code");
                }

            }
        }
        //Write Your Code Here
        /* Donot initialize another Scanner use the static scanner already declared*/
    }

    private static class StacksUsingArrays {
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

                int[] temp = new int[2 * data.length];
                for(int i = 0;i < data.length;i++){
                    temp[i] = data[i];
                }

                data = temp;
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
