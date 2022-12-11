package assignment_4;

import java.util.Arrays;
import java.util.Scanner;
/*
Take as input str, a string. Write a recursive function which returns all the words possible by rearranging the characters of this string which are in dictionary order smaller than the given string. The output strings must be lexicographically sorted.

Input Format
Single line input containing a string

Constraints
Length of string <= 25

Output Format
Display all the words which are in dictionary order smaller than the string entered in a new line each. The output strings must be sorted.

Sample Input
cab
Sample Output
abc
acb
bac
bca
Explanation
The possible permutations of string "cab" are "abc" , "acb" ,"bac" , "bca" , "cab" and "cba" . Only four of them are lexicographically less than "cab". We print them in lexicographical order.
 */
public class dictionary_order_smaller {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char c[]=s.toCharArray();
        Arrays.sort(c);
        String ss=new String(c);
        lexi(s,ss,"");
    }
    static void lexi(String s,String ss,String ans){
        if(ss.length()==0){
            if(ans.compareTo(s)<0)System.out.println(ans);
            return;
        }
        for(int i=0;i<ss.length();i++){
            lexi(s,ss.substring(0,i)+ss.substring(i+1),ans+ss.charAt(i));
        }
    }
}
