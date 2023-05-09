package basic_assignment_1;

import java.util.Scanner;
/*
Take sb (source number system base), db (destination number system base) and sn (number in source format). Write a function that converts sn to its counterpart in destination number system. Print the value returned.

Input Format
Constraints
0 < N <= 1000000000

Output Format
Sample Input
8
2
33
Sample Output
11011
Explanation
All input output is as integers and in separate lines.
 */
public class Conversion_Any_To_Any {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int src=sc.nextInt();
        int des=sc.nextInt();
        int b=sc.nextInt();
        int sum=0;int mul=1;
        while(b>0){
            int d=b%10;
            sum=sum+d*mul;
            mul=mul*src;
            b/=10;
        }
        b=sum;
        int s2=0;
        mul=1;
        while(b>0){
            int d=b%des;
            s2=s2+d*mul;
            mul=mul*10;
            b/=des;
        }
        System.out.println(s2);
    }
}
