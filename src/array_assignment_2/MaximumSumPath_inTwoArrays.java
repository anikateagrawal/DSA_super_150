package array_assignment_2;

import java.util.Scanner;
/*
You are provided two sorted arrays. You need to find the maximum length of bitonic subsequence. You need to find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. You can switch from one array to another array only at common elements.

Input Format
First line contains integer t which is number of test case. For each test case, it contains two integers n and m which is the size of arrays and next two lines contains n and m space separated integers respectively.

Constraints
1<=t<=100 1<=n,m<=100000

Output Format
Print the maximum path.

Sample Input
1
8 8
2 3 7 10 12 15 30 34
1 5 7 8 10 15 16 19
Sample Output
122
Explanation
122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34
 */
public class MaximumSumPath_inTwoArrays {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            for(int i=0;i<m;i++)b[i]=sc.nextInt();
            System.out.println(maxSum(a,b,n,m));
        }
    }
    static int maxSum(int ar1[], int ar2[], int m, int n)
    {
        int i = 0, j = 0;
        int res = 0,s1 = 0, s2 = 0;
        while (i < m && j < n) {
            if (ar1[i] < ar2[j])
                s1 += ar1[i++];
            else if (ar1[i] > ar2[j])
                s2 += ar2[j++];
            else {
                res+= Math.max(s1,s2) + ar1[i];
                s1 = 0;
                s2 = 0;
                i++;
                j++;
            }
        }
        while (i < m)
            s1 += ar1[i++];
        while (j < n)
            s2 += ar2[j++];
        res += Math.max(s1,s2);
        return res;
    }
}
