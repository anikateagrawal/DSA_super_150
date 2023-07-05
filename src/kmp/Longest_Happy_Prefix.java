package kmp;

import java.util.Scanner;

public class Longest_Happy_Prefix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(longestPrefix(s));
    }
    public  static String longestPrefix(String s) {
        int dp[]=new int[s.length()];
        int len=0;
        for(int i=1;i<s.length();){
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                dp[i]=len;
                i++;
            }
            else{
                if(len>0){
                    len=dp[len-1];
                }
                else {
                    dp[i]=0;
                    i++;
                }
            }
        }
        return s.substring(0,len);
    }
}
