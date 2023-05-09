package dp_assignment;

/*
Cody went to the market to buy some oranges for his N friends. There he finds oranges wrapped in packets, with the price of i^th packet as val[i].
Now he wants to buy exactly W kg oranges, so he wants you to tell him what minimum price he should pay to buy exactly W kg oranges. Weight of i^th packet is i kg. If price of i^th packet is -1 then this packet is not available for sale. The market has infinite supply of orange packets.

Input Format
First line of input contains two space separated integers N and W, the number of friend he has and the amount of Oranges in kilograms which he should buy.

The second line contains W space separated integers in which the i^th integer specifies the price of a ‘i’kg apple packet. A value of -1 denotes that the corresponding packet is unavailable

Constraints
1 <= N,W,val[ ] <= 10^3

Output Format
Output a single integer denoting the minimum price Code should pay to get exactly W kg oranges. Else print -1 if it is not possible to fill the bag.

Sample Input
5 5
1 2 3 4 5
Sample Output
5
 */
import java.util.*;
public class Minimum_Money_Needed {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int v[]=new int[w];
        for(int i=0;i<w;i++)v[i]=sc.nextInt();
        long dp[][]=new long[1001][1001];
        for(long d[]:dp){
            Arrays.fill(d,-1);
        }
        System.out.println(fun(w,w,v,dp));
    }
    static long fun(int n,int w,int v[],long dp[][]){
        if(w==0)return 0;
        if(n==0)return Integer.MAX_VALUE;
        if(dp[n][w]!=-1)return dp[n][w];
        long ans=fun(n-1,w,v,dp);
        if(w<n||v[n-1]==-1)return ans;
        ans=Math.min(ans,v[n-1]+fun(n,w-n,v,dp));
        return dp[n][w]=ans;
    }
}

