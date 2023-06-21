package exam_questions;

/*
When Valera has got some free time, he goes to the library to read some books. Today he's got t free minutes to read. That's why Valera took n books in the library and for each book he estimated the time he is going to need to read it. Let's number the books by integers from 1 to n. Valera needs ai minutes to read the i-th book.

Valera decided to choose an arbitrary book with number i and read the books one by one, starting from this book. In other words, he will first read book number i, then book number i + 1, then book number i + 2 and so on. He continues the process until he either runs out of the free time or finishes reading the n-th book. Valera reads each book up to the end, that is, he doesn't start reading the book if he doesn't have enough free time to finish reading it.

Print the maximum number of books Valera can read.

Input Format
First Line contains two space separated positive integers N and T .
Second Line contains a positive integer array of size N .
Constraints
1 <= N <= 105

1 <= A[i] <= 104
1 <= T <= 109

Output Format
Print the maximum number of books Valera can read.

Sample Input
4 5
3 1 2 1
Sample Output
3
Explanation
Valera can read 3 books from index [1,3] which takes total 4(1+2+1) minutes to read . Hence output is 3 .
 */
import java.util.*;
public class Books {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int cs[]=new int[n+1];
        for(int i=1;i<=n;i++){
            cs[i]=cs[i-1]+a[i-1];
        }
        int lo=0,hi=n;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(can(cs,mid,t)){
                ans=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }

        System.out.println(ans);
    }
    static boolean can(int cs[],int m,int t){
        for(int i=0;i+m<cs.length;i++){
            if(cs[i+m]-cs[i]<=t)return true;
        }
        return false;
    }
}

