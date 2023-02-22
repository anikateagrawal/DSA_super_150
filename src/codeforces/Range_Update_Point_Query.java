package codeforces;

import java.util.Scanner;

public class Range_Update_Point_Query {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int q= sc.nextInt();
            int a[]=new int[n];
            for (int i = 0; i < n; i++) {
                a[i]= sc.nextInt();
            }
            int d[]=new int[n];
            while (q-->0){
                int qq=sc.nextInt();
                if(qq==2){
                    int x=sc.nextInt()-1;
                    for (int i = 0; i < d[x]; i++) {
                        a[x]=sum(a[x]);
                    }
                    System.out.println(a[x]);
                }
                else{
                    int l=sc.nextInt();
                    int r=sc.nextInt();
                    for (int i = l-1; i <=r -1; i++) {
                        d[i]++;
                    }
                }
            }
        }
    }
    static int sum(int n){
        int s=0;
        while(n>0){
            s+=n%10;
            n/=10;
        }
        return s;
    }
}
