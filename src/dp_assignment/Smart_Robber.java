package dp_assignment;

/*
A professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping him from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money he can rob tonight without alerting the police.

Input Format
First line contains integer t as number of testcases. Second line contains integer n as size of array. Third line contains a single integer as element of array.

Constraints
None

Output Format
Print the maximum money as output.

Sample Input
1
4
1 2 3 1
Sample Output
4
 */
import java.util.*;
public class Smart_Robber {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int last=0,max=0;
            for(int i=0;i<n;i++){
                max=Math.max(sc.nextInt()+last,last=max);
            }
            System.out.println(max);
        }
    }
}
