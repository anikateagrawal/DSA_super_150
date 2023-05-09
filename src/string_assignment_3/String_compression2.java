package string_assignment_3;

import java.util.Scanner;
/*
Take as input S, a string. Write a function that does basic string compression. Print the value returned. E.g. for input “aaabbccds” print out a3b2c2ds.

Input Format
A single String S.

Constraints
A string of length between 1 to 1000

Output Format
The compressed String.

Sample Input
aaabbccds
Sample Output
a3b2c2ds
Explanation
In the given sample test case 'a' is repeated 3 times consecutively, 'b' is repeated twice, 'c' is repeated twice. But, 'd' and 's' occurred only once that's why we do not write their occurrence.
 */
public class String_compression2 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char ch=s.charAt(0);
        int c=1;
        String ns=""+ch;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==ch)c++;
            else{
                ch=s.charAt(i);
                if(c>1)ns+=c;
                c=1;
                ns+=ch;
            }
        }
        if(c>1)ns+=c;
        System.out.println(ns);
    }
}
