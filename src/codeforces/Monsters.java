package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Monsters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int a[]=new int[n];
            for (int i = 0; i < n; i++) {
                   a[i]=sc.nextInt();
            }
            long m=fun(a,n);
            int i;
            for (i = 1; i <=n ; i++) {
                long d=fun(a,i);
                System.out.print(d+" ");
            }
            while (i++<=n) System.out.print(m+" ");
            System.out.println();
        }
    }
    static long fun(int b[],int k){
        int a[]=new int[k];
        for(int i=0;i<k;i++)a[i]=b[i];
        Arrays.sort(a);
        long m=0;
        if(a[0]!=1){
            m+=a[0]-1;
            a[0]=1;
        }
        for (int i = 1; i < a.length; i++) {
            if(a[i]-a[i-1]>1){
                m+=a[i]-a[i-1]-1;
                a[i]=a[i-1]+1;
            }
        }
        return m;
    }
}
