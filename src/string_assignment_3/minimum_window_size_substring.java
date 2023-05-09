package string_assignment_3;

import java.util.Scanner;
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Input Format
First Line Contains 2 strings of length not more than 10^5

Constraints
1<=|S|<=10^5

Output Format
A single Line a containing String

Sample Input
ADOBECODEBANC ABC
Sample Output
BANC
 */
public class minimum_window_size_substring {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next(),t=sc.next();
        int win[]=new int[256];
        int count=0;
        for(int i=0;i<t.length();i++){
            if(win[t.charAt(i)]==0)count++;
            win[t.charAt(i)]++;
        }
        int si=0,ei=0;
        int ans=Integer.MAX_VALUE;
        String ns="";
        while(ei<s.length()){
            win[s.charAt(ei)]--;
            if(win[s.charAt(ei)]==0)count--;
            while(count==0){
                if(ans>ei-si+1){
                    ans=ei-si+1;
                    ns=s.substring(si,ei+1);
                }
                win[s.charAt(si)]++;
                if(win[s.charAt(si)]>0)count++;
                si++;
            }
            ei++;
        }
        if(ans==Integer.MAX_VALUE)System.out.println("");else
            System.out.println(ns);
    }
}
