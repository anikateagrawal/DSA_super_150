package recursion_assignment_4;

import java.util.Scanner;
/*
Replace all occurrences of pi with 3.14

Input Format
Integer N, no of lines with one string per line

Constraints
0 < N < 1000
0 <= len(str) < 1000

Output Format
Output result one per line

Sample Input
3
xpix
xabpixx3.15x
xpipippixx
Sample Output
x3.14x
xab3.14xx3.15x
x3.143.14p3.14xx
Explanation
All occurrences of pi have been replaced with "3.14".
 */
public class replace_all_pie {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            fun(s,"");
        }
    }
    static void fun(String s,String ss ){
        if(s.length()==0){
            System.out.println(ss);
            return;
        }
        if(s.length()>1&&s.charAt(0)=='p' && s.charAt(1)=='i')
            fun(s.substring(2),ss+"3.14");
        else fun(s.substring(1),ss+s.charAt(0));
    }
}
