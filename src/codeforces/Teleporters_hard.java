package codeforces;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Teleporters_hard {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int c=sc.nextInt();
            for (int i = 0; i < n; i++) {
                a[i]=sc.nextInt();
            }
            System.out.println(sol(a,n,c));
        }
    }
    public static int sol(int a[],int n,int c){
        int ct=1;
        int min=a[0]+1;
        int in=0;
        for (int j = 0; j < n; j++) {
            if(a[j]+j+1<min){
                min=a[j]+j+1;
                in=j;
            }
        }
        if(c<min)return 0;
        c-=min;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for (int i = 0; i <n ; i++) {
            if(i==in)continue;
            q.add(a[i]+Math.min(i+1,n-i));
        }
        System.out.println(c);
        while (!q.isEmpty()&&c>=q.peek()){
            c-=q.poll();
            ct++;
        }
        return ct;
    }
}
