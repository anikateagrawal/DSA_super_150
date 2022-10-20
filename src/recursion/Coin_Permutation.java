package recursion;

import java.util.Scanner;

public class Coin_Permutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int coins[]=new int[n];
        for (int i = 0; i <n ; i++) {
            coins[i]= sc.nextInt();
        }
        int sum= sc.nextInt();
        fun(coins,sum,"",0);
    }
    static void fun(int[] coins,int sum,String ans,int s){
        if(s>sum){
            return;
        }
        if(s==sum){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            fun(coins,sum,ans+coins[i],s+coins[i]);
        }
    }
}
