package string_assignment_3;

import java.util.Scanner;
/*
Take as input S, a string. Write a program that inserts between each pair of characters the difference between their ascii codes and print the ans.

Input Format
String

Constraints
Length of String should be between 2 to 1000.

Output Format
String

Sample Input
acb
Sample Output
a2c-1b
Explanation
For the sample case, the Ascii code of a=97 and c=99 ,the difference between c and a is 2.Similarly ,the Ascii code of b=98 and c=99 and their difference is -1. So the ans is a2c-1b.
 */
public class Difference_in_Ascii_Codes {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String ns="";
        for(int i=0;i<s.length()-1;i++){
            ns+=s.charAt(i);
            ns+=s.charAt(i+1)-s.charAt(i);
        }
        ns+=s.charAt(s.length()-1);
        System.out.println(ns);
    }
}
