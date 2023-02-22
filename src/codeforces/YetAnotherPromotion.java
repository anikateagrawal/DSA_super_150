package codeforces;

import java.util.Scanner;

public class YetAnotherPromotion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            long a=sc.nextLong();
            long b=sc.nextLong();
            long n=sc.nextLong();
            long m=sc.nextLong();
            long x=n/(m+1);
            long r=n%(m+1);
            long br=Math.min(r*a,r*b);
            long bg=Math.min((n-r-x)*a,(n-r)*b);
            System.out.println(bg+br);
        }
    }
}
