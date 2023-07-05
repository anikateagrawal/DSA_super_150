package kmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pattern_find {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            String s=sc.next();
            String p=sc.next();
            s=p+"#"+s;
            List<Integer> l=new ArrayList<>();
            int dp[]=new int[s.length()];
            int len=0;
            for(int i=1;i<s.length();){
                if(s.charAt(i)==s.charAt(len)){
                    len++;
                    dp[i]=len;
                    if(len==p.length()) {
                        l.add(i-len-p.length()+1);
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
            if(l.size()==0) System.out.println("Not Found");
            else {
                System.out.println(l.size());
                for(int i:l) System.out.print(i+" ");
            }
            System.out.println();

        }

    }
}
