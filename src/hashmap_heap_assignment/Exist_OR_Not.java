package hashmap_heap_assignment;
/*
Given an array arr of n length. You will be given Q queries for the array. Each query contains a number N.You have to determine whether a number exist in the array or not

Input Format
First line of input contains number of test cases T. First line of each case contains an integer L denoting the length of the array. The next line contains L space separated integers. The next line contains an integer Q denoting the number of queries. The next Q lines contains a number N to be searched in the array.

Constraints
1<=t<=12
1<=L<=10^5 (n=number of elements in array).
-10^5<=A[i]<=10^5 (A[i]=ith element of array).

1<=Q<=10^4
-10^5<=x<=10^5

Output Format
For each Query print “Yes” if the number is present and “No” if it’s not.

Sample Input
1
6
12 3 -67 67 34 2
4
4
5
67
7
Sample Output
No
No
Yes
No
 */
import java.util.*;
public class Exist_OR_Not {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Set<Integer> s=new HashSet<>();
            for(int i=0;i<n;i++)s.add(sc.nextInt());
            int q=sc.nextInt();
            while(q-->0){
                if(s.contains(sc.nextInt()))System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
