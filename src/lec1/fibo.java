package lec1;

import java.util.Scanner;

public class fibo {
    public static void main(String[] args) {
        int a=0,b=1;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 1; i <=n; i++) {
            int c=a+b;
            a=b;
            b=c;
        }
        System.out.println(a);
    }
}
