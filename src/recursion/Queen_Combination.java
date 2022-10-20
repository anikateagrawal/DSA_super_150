package recursion;

import java.util.Scanner;

public class Queen_Combination {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean b[]=new boolean[n];
        int q= sc.nextInt();
        fun(b,q,"",0,0);
    }
    static void fun(boolean[] b,int q,String ans,int i,int p){
        if(i==q){
            System.out.println(ans);
            return;
        }
        for (int j = p; j < b.length; j++) {
            if(b[j]==false) {
                b[j] = true;
                fun(b, q, ans + "b" + j + "q" + i, i + 1,j+1);
                b[j] = false;
            }
        }
    }
}
