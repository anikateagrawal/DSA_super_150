package basic_assignment_1;

import java.util.Scanner;
/*
Take the following as input.

A number (N1)
A number (N2)
Write a function which returns the LCM of N1 and N2. Print the value returned.

Input Format
Constraints
0 < N1 < 1000000000
0 < N2 < 1000000000

Output Format
Sample Input
4
6
Sample Output
12
Explanation
The smallest number that is divisible by both N1 and N2 is called the LCM of N1 and N2.
 */
public class lcm {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int i=Math.max(a,b);
        for(;true;i=i+Math.max(a,b)){
            if(i%Math.min(a,b)==0)break;
        }
        System.out.println(i);
    }
}
