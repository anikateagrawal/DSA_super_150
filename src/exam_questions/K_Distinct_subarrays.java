package exam_questions;

/*
A subarray is called K-Distinct Subarray if it contains atmost k distinct elements.
You are given an array of n integers and a value k , your task is to calculate the number of K-Distinct subarrays that have at most k distinct values.

Input Format
First line contains two space separated integers n and k .
Second line contains an integer array.

Constraints
1 <= k , n <= 105
1 <= arr[i] <= 109

Output Format
Print total number of K-distinct subarrays.

Sample Input
5 2
1 2 3 1 1
Sample Output
10
Explanation
There are total 10 subarrays which are K-distinct.
subarrays of length1 : [1] ,[2] ,[3] ,[1] ,[1]
subarrays of length 2 : [1,2] , [2,3] ,[3,1],[1,1]
Subarrays of length 3 : [3,1,1]
 */
import java.util.*;
public class K_Distinct_subarrays {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        long t=0;
        int s=0,e=0;
        Map<Integer,Integer> m=new HashMap<>();
        while(e<n){
            m.put(a[e],m.getOrDefault(a[e],0)+1);
            while(s<=e&&m.size()>k){
                int c=m.get(a[s]);
                c--;
                if(c==0)m.remove(a[s]);
                else m.put(a[s],c);
                s++;
            }
            e++;
            t+=e-s;
        }
        System.out.println(t);
    }
}
