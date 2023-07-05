package bitmasking;

import java.util.Scanner;

public class I_coins_atcoder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double c[]=new double[n];
        Double dp[][]=new Double[n][(n+1)/2+1];
        for (int i = 0; i < n; i++) {
            c[i]=sc.nextDouble();
        }
        System.out.println(prob(0,c,(n+1)/2,dp));

    }
    public static double prob(int i,double p[],int h,Double dp[][]){
        if(h==0)return 1;
        if(i==p.length)return 0;
        if(dp[i][h]!=null)return dp[i][h];
        return dp[i][h]=p[i]*prob(i+1,p,h-1,dp)+(1-p[i])*prob(i+1,p,h,dp);
    }

}
