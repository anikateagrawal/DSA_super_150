package recursion_assignment_4;

import java.util.Scanner;
/*
Take as input N, a number. Write a recursive function to find Nth triangle where 1st triangle is 1, 2nd triangle is 1 + 2 = 3, 3rd triangle is 1 + 2 + 3 = 6, so on and so forth. Print the value returned.

Input Format
Integer N is the single line of input.

Constraints
1 <= N <= 100

Output Format
Print the output as a single integer which is the nth triangle.

Sample Input
3
Sample Output
6
 */
public class nth_triangle {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fun(n));
    }
    static int fun(int n){
        if(n==1)return n;
        return fun(n-1)+n;
    }
}
