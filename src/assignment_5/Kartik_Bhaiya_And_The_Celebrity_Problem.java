package assignment_5;

import java.util.Scanner;
/*
Kartik Bhaiya, mentor at Coding Blocks, organized a party for their interns at Coding Blocks. In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, she/he doesn’t know anyone in the party. We can only ask questions like “does A know B? “.
Find the stranger (celebrity) in minimum number of questions.

Input Format
First line contains N, number of persons in party. Next line contains the matrix of N x N which represents A knows B when it's value is one.

Constraints
None

Output Format
Print the celebrity ID which is between 0 and N-1. If celebrity is not present then print "No Celebrity".

Sample Input
4
0 0 1 0
0 0 1 0
0 0 0 0
0 0 1 0
Sample Output
2
Explanation
In the given case there are 4 persons in the party let them as A, B, C, D. The matrix represents A knows B when it's value is one. From the matrix, A knows C, B knows C and D knows C. Thus C is the celebrity who doesnot know anyone and it's ID is 2. Hence output is 2.
 */
public class Kartik_Bhaiya_And_The_Celebrity_Problem {
    public static void main(String args[]) {
        int f=-1;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)p[i][j]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int k=0;
            for(int j=0;j<n;j++){
                if(p[i][j]==1)k=1;
            }
            if(k==0)f=i;
        }
        if(f!=-1){
            int i;
            for(i=0;i<n;i++){
                if(i==f)continue;
                if(p[i][f]!=1)break;
            }
            if(i==n)
                System.out.println(f);
            else System.out.println("No Celebrity");
        }
        else System.out.println("No Celebrity");
    }
}
