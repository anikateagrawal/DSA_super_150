package recursion;

import java.util.Scanner;

public class fact {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fun(n,1));
    }
    static int fun(int n,int p){
        if(n==0)return p;
        p=p*n;
         return fun(n-1,p);
    }
}
