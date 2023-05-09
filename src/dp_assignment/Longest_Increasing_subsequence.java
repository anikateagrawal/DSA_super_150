package dp_assignment;

/*
Find the length of the longest subsequence in a given array A of integers such that all elements of the subsequence are sorted in strictly ascending order.

Input Format
The first line contains a single integer n.
Next line contains n space separated numbers denoting the elements of the array.

Constraints
0 < n< 105
0 < Ai < 105

Output Format
Print a single line containing a single integer denoting the length of the longest increasing subsequence.

Sample Input
6
50 3 10 7 40 80
Sample Output
4
Explanation
The longest subsequence in test case is - 3,7,40,80
 */
import java.util.*;
public class Longest_Increasing_subsequence{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        System.out.println(lengthOfLIS(a));
    }
    public static int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp[len-1]){
                dp[len++]=nums[i];
                continue;
            }
            int lo=0;int hi=len-1;
            int ans=-1;
            while(lo<=hi){
                int mid=(lo+hi)/2;
                if(dp[mid]>=nums[i]){
                    ans=mid;
                    hi=mid-1;
                }
                else lo=mid+1;
            }
            dp[ans]=nums[i];
        }
        return len;
    }
}
