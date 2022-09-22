package recursion;

import java.util.Scanner;

public class N_to_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        fun(n);
    }
    static void fun(int n){
        if(n==0)return;
        System.out.println(n);
        fun(n-1);
    }
}
