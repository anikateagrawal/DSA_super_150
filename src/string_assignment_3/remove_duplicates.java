package string_assignment_3;

import java.util.Scanner;
/*
Take as input S, a string. Write a function that removes all consecutive duplicates. Print the value returned.

Input Format
String

Constraints
A string of length between 1 to 1000

Output Format
String

Sample Input
aabccba
Sample Output
abcba
Explanation
For the given example, "aabccba", Consecutive Occurrence of a is 2, b is 1, and c is 2.

After removing all of the consecutive occurences, the Final ans will be : - "abcba".
 */
public class remove_duplicates {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String ns="";
        char c=s.charAt(0);
        ns+=c;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==c)continue;
            else {
                ns+=s.charAt(i);
                c=s.charAt(i);
            }
        }System.out.println(ns);
    }
}
