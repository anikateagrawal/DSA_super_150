package recursion;

import java.util.Scanner;

public class a_pow_b {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        System.out.println(fun(a,b,1));
    }
    static int fun(int a,int b,int p){
        if(b==0)return p;
        return fun(a,b-1,p*a);
    }
}
