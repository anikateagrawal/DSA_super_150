package codeforces;

import java.util.Scanner;

public class Prepend_and_Append {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            System.out.println(sol(s));
        }
    }
    static int sol(String s){
        int i=0,j=s.length()-1;
        int len=s.length();
        while (i<j&&s.charAt(i)!=s.charAt(j)){
            i++;
            j--;
            len-=2;
        }
        return len;
    }
}
