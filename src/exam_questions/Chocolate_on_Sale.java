package exam_questions;

/*
Martin’s friend has a bakery and it was famous for N different varieties of chocolates available.
But one fine day, his friend was giving away chocolates for free. But all offers come with some condition.
So here is the condition- if Martin buys a single chocolate from the bakery, he’ll get atmost K chocolates ( all of different varieties) for free.
If you must use the offer when at the bakery, find the minimum amount of money to spend on buying all the varieties of chocolates.

Input Format
The first line of the input contains T the number of test cases. Then T testcases follow. Each test case consists of two lines. The first line of each test case contains the values of N and K as described above. Then the next line contains N integers denoting the price of each of the N different chocolates.

Constraints
1 <= T <= 50
1 <= N <= 1000
0 <= K <= N-1
1 <= Ai <= 100

Output Format
For each test case, in a new line, print a single integer denoting the minimum amount of money required to be spent.

Sample Input
1
4  2
3 2 1 4
Sample Output
3
 */
import java.util.*;
public class Chocolate_on_Sale {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            Arrays.sort(a);
            int i=0,j=n-1;
            int sum=0;
            while(i<=j){
                sum+=a[i++];
                j-=k;
            }
            System.out.println(sum);
        }
    }
}
