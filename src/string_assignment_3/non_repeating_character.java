package string_assignment_3;

import java.util.Scanner;
/*
Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”, then output should be ‘f’ and if input string is “GeeksQuiz”, then output should be ‘G’.

Input Format
The first line contains T denoting the number of testcases. Then follows description of testcases. Each case begins with a single integer N denoting the length of string. The next line contains the string S.

Constraints
Output Format
For each testcase, print the first non repeating character present in string. Print -1 if there is no non repeating character.

Sample Input
3
codingblocks
abbac
java
Sample Output
d
c
j
 */
public class non_repeating_character {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String s=sc.next();
            char a[]=s.toCharArray();
            int i=0;
            for(i=0;i<s.length();i++){
                int f=0;
                if(a[i]==0)continue;
                for(int j=i+1;j<s.length();j++){
                    //System.out.println(s.charAt(i)+" "+s.charAt(j));
                    if(s.charAt(i)==s.charAt(j)){
                        a[j]=0;
                        f=1;
                    }
                }
                if(f==0){
                    System.out.println(s.charAt(i));
                    break;
                }
            }
            if(i==s.length())
                System.out.println(-1);
        }
    }
}
