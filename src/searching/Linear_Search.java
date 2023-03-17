package searching;

import java.util.Scanner;

public class Linear_Search {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        int v=sc.nextInt();
        System.out.println(linearSearch(a,v));
    }
    public static  int linearSearch(int a[],int v){
        for (int i = 0; i < a.length; i++) {
            if(a[i]==v)return i;
        }
        return -1;
    }
}
