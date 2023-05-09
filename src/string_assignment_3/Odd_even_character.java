package string_assignment_3;

import java.util.Scanner;
/*
Take as input S, a string. Write a function that replaces every even character with the character having just higher ASCII code and every odd character with the character having just lower ASCII code. Print the value returned.

Input Format
String

Constraints
Length of string should be between 1 to 1000.

Output Format
String

Sample Input
abcg
Sample Output
badf
 */
public class Odd_even_character {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String ns="";
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                ns+=(char)(s.charAt(i)+1);
            }
            else ns+=(char)(s.charAt(i)-1);
        }
        System.out.println(ns);
    }
}
