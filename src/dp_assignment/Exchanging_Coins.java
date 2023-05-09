package dp_assignment;

/*
Tughlaq introduces a strange monetary system. He introduces copper coins and each coin has a number written on it. A coin n can be exchanged in a bank into three copper coins: n/2, n/3 and n/4. A coin can also be sold for gold. One can get as much grams of gold as the number written on the coin. You have one copper coin. What is the maximum weight of gold one can get from it?

Input Format
The input file contains a single integer n, the number on the coin.

Constraints
0 <= n <= 1 000 000 000

Output Format
Print the maximum weight of gold you can get.

Sample Input
12
Sample Output
13
 */
import java.util.*;
public class Exchanging_Coins{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Long> dp=new HashMap<>();
        System.out.println(fun(n,dp));
    }
    static long fun(int n,Map<Integer,Long> dp){
        if(n==0)return 0;
        if(dp.containsKey(n))return dp.get(n);
        long ans=Math.max(n,fun(n/2,dp)+fun(n/3,dp)+fun(n/4,dp));
        dp.put(n,ans);
        return ans;
    }
}
