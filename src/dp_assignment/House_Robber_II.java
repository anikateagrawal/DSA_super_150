package dp_assignment;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, Print the maximum amount of money you can rob tonight without alerting the police.

Input Format
First line takes an integer N(size of array)
Second line containing n space separated integer describing array

Constraints
1 <= N <= 100
0 <= nums[i] <= 1000

Output Format
Print the maximum amount of money you can rob tonight without alerting the police.

Sample Input
3
2 3 2
Sample Output
3
Explanation
You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 */
import java.util.*;
public class House_Robber_II{
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        System.out.println(Math.max(rob(a,0,n-2),rob(a,1,n-1)));
    }
    static int rob(int a[],int s,int e){
        int last=0,max=0;
        for(int i=s;i<=e;i++){
            max=Math.max(a[i]+last,last=max);
        }
        return max;
    }
}
