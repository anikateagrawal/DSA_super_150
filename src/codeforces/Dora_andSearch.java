package codeforces;

import java.util.Scanner;

public class Dora_andSearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for (int i = 0; i < n; i++) {
                a[i]=sc.nextInt();
            }
            int i=0,j=n-1;
            int f=0;
            int min=1,max=n;
            while(i<j){
                if(a[i]==min){
                    min++;
                    i++;
                }
                else if(a[i]==max){
                    max--;
                    i++;
                }
                else if(a[j]==min){
                    min++;
                    j--;
                }
                else if(a[j]==max){
                    max--;
                    j--;
                }
                else {
                    f=1;
                    break;
                }
            }
            if(f==0) System.out.println(-1);
            else System.out.println(i+1+" "+(j+1));
        }
    }
}
