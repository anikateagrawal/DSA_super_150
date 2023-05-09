package stack_queue_assignment_5;

import java.util.Scanner;
/*
You will be given a numeric string S. Print all the possible codes for S.

Following vector contains the codes corresponding to the digits mapped.

string table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };

For example, string corresponding to 0 is " " and 1 is ".+@$"

Input Format
A single string containing numbers only.

Constraints
length of string <= 10

Output Format
All possible codes one per line in the following order.

The letter that appears first in the code should come first

Sample Input
12
Sample Output
.a
.b
.c
+a
+b
+c
@a
@b
@c
$a
$b
$c
Explanation
For code 1 the corresponding string is .+@$ and abc corresponds to code 2.
 */
public class Smart_Keypad_I {
    public static void main(String args[]) {
        String table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        codes(s,"",table);
    }
    static void codes(String s,String ans,String[] t){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        int ch=s.charAt(0)-'0';
        String ss=t[ch];
        for(int i=0;i<ss.length();i++){
            codes(s.substring(1),ans+ss.charAt(i),t);
        }
    }
}
