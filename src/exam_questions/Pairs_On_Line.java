package exam_questions;

/*
You are given a linear equation y = mx + c, and an array A of n elements. Count the number of ordered pairs (i,j) where i!=j, such that point (Ai, Aj) satisfies the given linear equation.

Input Format
First line contains 3 integers, n, m and c. Next line contains n integers, denoting the elements of array A.

Constraints
2<=n<=2*10^5
-10^9 <= Ai, m, c<= 10^9

Output Format
Print a single integer denoting the answer.

Sample Input
5 1 1
1 2 3 4 2
Sample Output
5
Explanation
Number of pairs (i,j), for which (Ai, Aj) satisfies the linear equation y = x + 1 are : (1,2), (1,5), (2,3), (3,4), (5,3).
 */
import java.util.*;
public class Pairs_On_Line {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int c=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:a){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans=0;
        for(int x:a){
            int y=m*x+c;
            ans+=map.getOrDefault(y,0);
            if(y==x)ans--;
        }
        System.out.println(ans);
    }
}
