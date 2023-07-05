package kmp;

import java.util.Scanner;

public class A_Needle_in_the_Haystack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            String p=sc.next();
            String s=sc.next();
            s=p+"#"+s;
            int dp[]=new int[s.length()];
            int len=0;
            for(int i=1;i<s.length();){
                if(s.charAt(i)==s.charAt(len)){
                    len++;
                    dp[i]=len;
                    if(len==p.length()) {
                        System.out.println(i-len-p.length());
                    }
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
            System.out.println();
        }

    }
}
