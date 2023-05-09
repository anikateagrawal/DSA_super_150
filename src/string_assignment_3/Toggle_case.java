package string_assignment_3;

import java.util.Scanner;
/*
Take as input S, a string. Write a function that toggles the case of all characters in the string. Print the value returned.

Input Format
String

Constraints
Length of string should be between 1 to 1000.

Output Format
String

Sample Input
abC
Sample Output
ABc
Explanation
Toggle Case means to change UpperCase character to LowerCase character and vice-versa.
 */
public class Toggle_case {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String ns="";
        for(char c:s.toCharArray()){
            if(Character.isUpperCase(c))ns+=Character.toLowerCase(c);
            else ns+=Character.toUpperCase(c);
        }
        System.out.println(ns);
    }
}
