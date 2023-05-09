package recursion_assignment_4;

import java.util.Scanner;
/*
Take as input N, a number. Print odd numbers in decreasing sequence (up until 0) and even numbers in increasing sequence (up until N) using Recursion

Input Format
Constraints
1 <= N <=1000

Output Format
Sample Input
5
Sample Output
5
3
1
2
4
 */
public class odd_even_using_recursion {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        fun(n);
    }
    static void fun(int n){
        if(n==0)return;
        if(n%2==1)
            System.out.println(n);
        fun(n-1);
        if(n%2==0)
            System.out.println(n);
    }
}
