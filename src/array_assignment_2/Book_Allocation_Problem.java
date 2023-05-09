package array_assignment_2;

import java.util.Scanner;
/*
You are given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

Input Format
First line contains integer t as number of test cases. Next t lines contains two lines. For each test case, 1st line contains two integers n and m which represents the number of books and students and 2nd line contains n space separated integers which represents the number of pages of n books in ascending order.

Constraints
1 < t < 50
1< n < 100
1< m <= 50
1 <= Ai <= 1000

Output Format
Print the maximum number of pages that can be assigned to students.

Sample Input
1
4 2
12 34 67 90
Sample Output
113
Explanation
1st students : 12 , 34, 67 (total = 113)
2nd students : 90 (total = 90)
Print max(113, 90)


 */
public class Book_Allocation_Problem {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int s=sc.nextInt();
            int page[]=new int[n];
            for(int i=0;i<n;i++)page[i]=sc.nextInt();
            System.out.println(minpage(page,s));
        }
    }
    public static int minpage(int []page,int nos){
        int hi=0;
        for (int i = 0; i < page.length; i++) {
            hi+=page[i];
        }
        int lo=0;
        int ans=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(isPossible(page,mid,nos)){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;
    }
    public static boolean isPossible(int []page,int d,int s){
        int ss=1;
        int read_page=0;
        for (int i = 0; i < page.length; i++) {
            if(read_page+page[i]<=d){
                read_page+=page[i];
            }
            else{
                read_page=0;
                ss++;
                i--;
            }
            if(ss>s)return false;
        }
        return true;
    }
}
