package codeforces;

import java.util.*;

public class Negatives_and_Positives {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int ct=0;
            long sum=0;
            List<Integer> l=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a[i]=sc.nextInt();
                l.add(Math.abs(a[i]));
                if(a[i]<0)ct++;
                sum+=Math.abs(a[i]);
            }
            Collections.sort(l);
            if(ct%2==0) System.out.println(sum);
            else System.out.println(sum-2*l.get(0));
        }
    }
}
