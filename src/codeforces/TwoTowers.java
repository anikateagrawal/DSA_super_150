package codeforces;

import java.util.Scanner;

public class TwoTowers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int m=sc.nextInt();
            int n=sc.nextInt();
            String a=sc.next();
            String b=sc.next();
            String s=a;
            for(int i=b.length()-1;i>=0;i--){
                s+=b.charAt(i);
            }
            int c=0;
            for (int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i)==s.charAt(i+1))c++;
            }
            if(c>1)System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
