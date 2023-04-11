package greedy_algo;

import mix.Arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Activity_Selector {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of Activities");
        int n=sc.nextInt();
        int a[][]=new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter start time");
            a[i][0]=sc.nextInt();
            System.out.println("Enter finish time");
            a[i][1]=sc.nextInt();
        }
        Arrays.sort(a,(b,c)->b[1]-c[1]);
        System.out.println("Activities => ");
        for(int i=0;i<n;i++) System.out.println(i+" "+Arrays.toString(a[i]));

        List<Integer> selected=new ArrayList<>();
        selected.add(0);
        int k=0;
        for (int i = 1; i < n; i++) {
            if(a[i][0]>=a[k][1]){
                selected.add(i);
                k=i;
            }
        }
        System.out.println("selected => "+selected);
    }
}
