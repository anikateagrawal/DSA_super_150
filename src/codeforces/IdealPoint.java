package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IdealPoint {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while (t-->0){
            int n= sc.nextInt();
            int k=sc.nextInt();
            Map<Integer,Integer> m=new HashMap<>();
            for (int i = 0; i < n; i++) {
                int l=sc.nextInt();
                int r= sc.nextInt();
                if(k>=l&&k<=r){
                    for (int j = l; j <= r; j++) {
                        m.put(j,m.getOrDefault(j,0)+1);
                    }
                }
            }
//            System.out.println(m);
            int max=Integer.MIN_VALUE;
            int v=-1;
            for(int i:m.keySet()){
                if(m.get(i)>max||m.get(i)==max&&i!=k){
                    max=m.get(i);
                    v=i;
                }
            }
            if(v==k) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
