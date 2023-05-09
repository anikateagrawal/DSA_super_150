package dp_assignment;

/*
Aakash has K identical plates and N floors. He needs to find the lowest floor at which the plate will break down aka critical floor. However, he doesn't like climbing stairs again and again. So he decided to take your help. Help him design a strategy that would tell him the minimum no of trials he need to perform for knowing the critical floor.

Assume that plate will only break at critical floor and floors higher than that.

_Hint :
_Recursion tells u what u intend to calculate._
Test case 3 is only for students who think that the test cases are easy.

Input Format
The first line contains T, the number of test cases.
Next T line follows 2 space separated integers, first being the number of plates K, next being the number of floors N.

Constraints
0 < T < 10
0 < K < 2
0 < N < 10

Output Format
T lines of required answer

Sample Input
1
2 3
Sample Output
2
Explanation
Aakash can start dropping plates from floor 1, 2 or 3.

Consider floor 1 :

If the plate breaks, critical floor is floor 1 else he moves to floor 2 and repeat the process. By this method minimum no of trials to know the critical floor are 3.

Consider he starts with 2nd floor.

Now if the plate breaks, the number of floors left to be checked is 1, floor 1. If it doesn't break, then floors to be tested is floor 3. In both the cases the number of trials are 2. So Akash will start from floor 2
 */
import java.util.*;
public class Minimum_trials_needed_Plate_Dropping {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int k=sc.nextInt();
            int n=sc.nextInt();
            Integer dp[][]=new Integer[k+1][n+1];
            System.out.println(fun(k,n,dp));
        }
    }
    static int fun(int n,int k,Integer dp[][]){
        if(n==1)return k;
        if(k<=1)return k;
        int ans=Integer.MAX_VALUE;
        if(dp[n][k]!=null)return dp[n][k];

        for(int i=1;i<=k;i++){
            int a=Math.max(fun(n-1,i-1,dp),fun(n,k-i,dp));
            ans=Math.min(ans,a);
        }
        return dp[n][k]=ans+1;
    }
}

