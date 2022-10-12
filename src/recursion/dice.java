package recursion;

import java.util.Scanner;

public class dice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int l=sc.nextInt();
        System.out.println(fun(0,l,n,""));
    }
    static int fun(int s,int e,int n,String ss){
        if(s==e){
            System.out.println(ss);return 1;}
        if(s>e)return 0;
        int sum=0;
        for (int i = 1; i <=n; i++) {
            sum+=fun(s+i,e,n,ss+i);
        }
        return sum;
    }
}
