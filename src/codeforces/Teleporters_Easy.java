package codeforces;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Teleporters_Easy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int c=sc.nextInt();
            PriorityQueue<Integer> q=new PriorityQueue<>();
            for (int i = 0; i <n ; i++) {
                q.add(sc.nextInt()+i+1);
            }
            int ct=0;
            while (!q.isEmpty()&&c>=q.peek()){
                c-=q.poll();
                ct++;
            }
            System.out.println(ct);
        }
    }
}
