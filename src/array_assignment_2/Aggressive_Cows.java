package array_assignment_2;

import java.util.Arrays;
import java.util.Scanner;
/*
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,…,xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Input Format
First line contains N and C, separated by a single space, representing the total number of stalls and number of cows respectively. The next line contains N integers containing the indexes of stalls.

Constraints
2 <= N <= 100,000
0 <= xi <= 1,000,000,000
2 <= C <= N

Output Format
Print one integer: the largest minimum distance.

Sample Input
5 3
1 2 8 4 9
Sample Output
3
Explanation
Problem Credits - (Spoj)[http://www.spoj.com/problems/AGGRCOW/]
 */
public class Aggressive_Cows {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int c=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        System.out.println(largestMinimumDistance(arr,c));

    }
    public static int largestMinimumDistance(int []arr,int c){
        int lo=0;
        int hi=arr[arr.length-1]-arr[0];
        int ans=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(isPossible(arr,mid,c)){
                ans=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }
        return ans;
    }
    public static boolean isPossible(int[] arr,int d,int c){
        int cow=1;
        int pos=arr[0];
        for(int i=1;i<arr.length;i++) {
            if (arr[i] - pos >= d) {
                cow++;
                pos = arr[i];
            }
            if(cow==c)return true;
        }
        return false;
    }
}
