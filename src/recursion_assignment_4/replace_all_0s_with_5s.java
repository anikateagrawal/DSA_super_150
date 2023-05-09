package recursion_assignment_4;

import java.util.Scanner;
/*
Given an integer N, now you have to convert all zeros of N to 5.

Input Format
The first Line takes input integer N, denoting the number.

Constraints
1<=N<=10000

Output Format
Print the number after replacing all 0's with 5.

Sample Input
103
Sample Output
153
Explanation
Testcase 1: after replacing 0 with 5 ,number will become 153.
Testcase 2: there is no zero in number so it will remain same.
 */
public class replace_all_0s_with_5s {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        fun(s,"");
    }
    static void fun(String s,String ss ){
        if(s.length()==0){
            System.out.println(ss);
            return;
        }
        if(s.charAt(0)=='0')
            fun(s.substring(1),ss+'5');
        else fun(s.substring(1),ss+s.charAt(0));
    }
}
