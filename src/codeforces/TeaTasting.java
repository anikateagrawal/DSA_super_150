package codeforces;

import java.util.Scanner;

public class TeaTasting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n= sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for (int i = 0; i < n; i++) {
                a[i]=sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i]=sc.nextInt();
            }
            long c[]=new long[n];
            for (int i = 0; i < n; i++) {
                int j=i;
                while (a[i]>0&&j<n){
                    c[j]+=Math.min(a[i],b[j]);
                    a[i]-=Math.min(a[i],b[j]);
                    j++;
                }
            }
            for(long i:c) System.out.print(i+" ");
            System.out.println();
        }
    }
}