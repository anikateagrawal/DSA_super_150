package string_assignment_3;

import java.util.Scanner;
/*
Take as input S, a string. Write a function that does basic string compression. Print the value returned. E.g. for input “aaabbccds” print out a3b2c2d1s1.

Input Format
A single String S

Constraints
1 < = length of String < = 1000

Output Format
The compressed String.

Sample Input
aaabbccds
Sample Output
a3b2c2d1s1
Explanation
In the given sample test case 'a' is repeated 3 times consecutively, 'b' is repeated twice, 'c' is repeated twice and 'd and 's' occurred only once.
 */
public class String_compression {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char c=s.charAt(0);
        int count=1;
        String ns=""+c;
        for(char ch : s.substring(1).toCharArray()){
            if(ch!=c){
                //System.out.println(c+" "+ch+" "+count);
                ns+=count+""+ch;
                c=ch;
                count=0;
            }
            count++;
        }
        System.out.println(ns+count);
    }
}
