package dp_assignment;

/*
You are provided a sequence of number. All numbers of that sequence is in increasing order (including 1) and whose only prime factors are 2, 3 or 5 (except 1). You need to find the nth number of that sequence.

Input Format
First line contains integer t which is number of test case. For each test case, it contains an integer n.

Constraints
1<=t<=100 1<=n<=10000

Output Format
Print nth number of that sequence.

Sample Input
2
7
10
Sample Output
8
12
Explanation
Sequence : 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, …..
 */
import java.util.*;
public class Ugly_Numbers {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long dp[]=new long[n];
            dp[0]=1;
            long f2=2,f3=3,f5=5;int i2=0,i3=0,i5=0;
            for(int i=1;i<n;i++){
                long min=Math.min(f2,Math.min(f3,f5));
                dp[i]=min;
                if(f2==min)f2=2*dp[++i2];
                if(f3==min)f3=3*dp[++i3];
                if(f5==min)f5=5*dp[++i5];

            }
            System.out.println(dp[n-1]);
        }
    }
}