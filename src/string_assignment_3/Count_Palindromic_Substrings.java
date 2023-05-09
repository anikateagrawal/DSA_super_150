package string_assignment_3;

import java.util.Scanner;
/*
Take as input S, a string. Write a program that gives the count of substrings of this string which are palindromes and Print the ans.

Input Format
Single line input containing a string

Constraints
Length of string is between 1 to 1000.

Output Format
Integer output showing the number of palindromic substrings.

Sample Input
abc
Sample Output
3
Explanation
For the given sample case , the palindromic substrings of the string abc are "a","b" and "c".So, the ans is 3.
 */
public class Count_Palindromic_Substrings {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int sum=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isPalin(s.substring(i,j)))sum++;
            }
        }
        System.out.println(sum);
    }
    static boolean isPalin(String s){
        StringBuffer ss=new StringBuffer(s);
        ss.reverse();
        return s.equals(""+ss);
    }
}
