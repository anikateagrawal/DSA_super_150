package codeforces;

import java.util.Scanner;

public class Fedya_and_Array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            System.out.println(2*(x-y));
            for (long i = y+1; i <=x ; i++) {
                System.out.print(i+" ");
            }
            for (long i = x-1; i >=y ; i--) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
