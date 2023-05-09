package array_assignment_2;

import java.util.Scanner;
/*
Given K painters to paint N boards where each painter takes 1 unit of time to paint 1 unit of boards i.e. if the length of a particular board is 5, it will take 5 units of time to paint the board. Compute the minimum amount of time to paint all the boards.

Note that:

Every painter can paint only contiguous segments of boards.
A board can only be painted by 1 painter at maximum.
Input Format
First line contains K which is the number of painters. Second line contains N which indicates the number of boards. Third line contains N space separated integers representing the length of each board.

Constraints
1 <= K <= 10
1 <= N <= 10
1<= Length of each Board <= 10^8

Output Format
Output the minimum time required to paint the board.

Sample Input
2
2
1 10
Sample Output
10
 */
public class Painter_s_Partition_Problem_Java {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        int l[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++)l[i]=sc.nextInt();
        //Arrays.sort(l);
        System.out.println(search(l,n,k));

    }
    static int search(int []l,int n,int k){
        int m=0;
        for(int i=0;i<n;i++)m+=l[i];
        int hi=m;
        int lo=0;
        int ans=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(isPossible(l,n,k,mid)){hi=mid-1;ans=mid;}
            else lo=mid+1;
        }
        return ans;
    }
    static boolean isPossible(int l[],int n,int k,int mid){
        int tb=0;
        int s=0;
        int c=1;
        while(tb<n){
            if(s+l[tb]<=mid){
                s+=l[tb];
                tb++;
            }
            else{
                s=0;
                c++;
            }
            if(c>k)return false;
        }
        return true;
    }
}
