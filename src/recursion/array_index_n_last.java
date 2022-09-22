package recursion;

import java.util.Scanner;

public class array_index_n_last {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }
        int v= sc.nextInt();
        System.out.println(fun(a,a.length-1,v));
    }
    static int fun(int a[],int i,int v){
        if(i<0)return -1;
        if(a[i]==v)return i;
        return fun(a,i-1,v);
    }
}
