package exam_questions;

/*
To be good at problem solving, Beretta thinks that Graphs are a topic one can definitely not skip. They have a variety of applications in Networks, flows , Routing and so on, even facebook is a good example of graph In Facebook, users are considered to be the vertices and if they are friends then there is an edge running between them. Facebook’s Friend suggestion algorithm uses graph theory. Facebook is an example of undirected graph.

He has prepared some really interesting problems based on the same for talented programmers like you. He really adores his friends, and has chosen one of this close friends Nizel Fernandes as the main character for this task. So, this is how it goes :

You have got a table of size N*M containing integers. N is total number of row and M is total number of column.
Initially cell (1, 1) contains one turtle named Nizel Fernandes. Nizel Fernandes wants to get to cell (N, M). Some cells of the table have obstacles(blocked cells). A cell is considered to be containing an obstacle if the value of the cell is a non prime number. That means that Nizel Fernandes can only move through prime number. It is guaranteed that upper left corner (1,1) contains a prime number.
A prime number (or a prime) is a natural number greater than 1 that is not a product of two smaller natural numbers.
Nizel Fernandes can go from cell (r, c) to one of three cells (r+ 1, c ), ( r , c + 1 ) and ( r + 1, c + 1 ) only if the required cell doesn't contain an obstacle the value of the cell is a prime number. Help him find the number of ways in which it can go from cell (1, 1) to cell (N, M). In addition, you need to print the lexicographically largest path to reach cell (N,M).
Note: A cell (r1,c1)is lexicographically larger than another cell (r2,c2) if either (r1>r2) or if r1=r2 and c1>c2.A path A is lexicographically larger than another path B,
Let, Path B: (1,1)(2,1)(3,1)(3,2)(3,3)
Path A: (1,1)(2,1)(3,2)(3,3)
Path A is lexicographically larger than another path B, because the first cell that does not match (i.e. (3,2) in A and (3,1) in B) is lexicographically larger in A than in B.

Input Format
The first line contains two space separated integers, N (number of rows) and M (number of columns).
Then N lines follow, each containing M space separated integers.

Constraints
1 <= N,M <= 103
2 <= A[r][c] <= 105 (the elements of the Matrix)

Output Format
In the first line, print the total number of possible ways to reach (N,M) from (1,1). Since this number may be too large, print the answer modulo 109 +7.

Print the cell indexes (space separated) of each step of his lexicographically largest path in a new line .
If no path exists, only print 0 in first line.

Sample Input
3 3
2 3 7
5 4 2
3 7 11
Sample Output
4
1 1
2 1
3 2
3 3
Explanation
There are four ways to reach (3,3) from (1,1).

Path 1. (1,1) (1,2) (1,3) (2,3) (3,3)
Path 2. (1,1) (1,2) (2,3) (3,3)
Path 3. (1,1) (2,1) (3,1) (3,2) (3,3)
Path 4. (1,1) (2,1) (3,2) (3,3)

Lexicographical Order -> 4 > 3 > 2 > 1
 */
import java.util.*;
public class Fernandes_Path  {
    static int mod=1000000007;
    static String ans="";
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean p[]=new boolean[1000000];

        prime(p);
        int mat[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        long ways[][]=new long[n][m];
        ways[0][0]=1;
        for(int i=1;i<m;i++){
            if(!p[mat[0][i]])ways[0][i]+=ways[0][i-1];
        }
        for(int i=1;i<n;i++){
            if(!p[mat[i][0]])ways[i][0]+=ways[i-1][0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(!p[mat[i][j]]){
                    ways[i][j]=((ways[i-1][j]+ways[i][j-1])%mod+ways[i-1][j-1])%mod;
                }
            }
        }
        System.out.println(ways[n-1][m-1]);
        Integer dp[][]=new Integer[n][m];
        ways(mat,0,0,n,m,"1 1\n",p,dp);
        if(!ans.equals(""))System.out.println(ans);
    }
    static int ways(int mat[][],int i,int j,int n,int m,String s,boolean p[],Integer dp[][]){
        if(i>=n||j>=m||p[mat[i][j]]||!ans.equals(""))return 0;
        if(i==n-1&&j==m-1){
            if(ans.equals(""))ans=s;
            return 1;
        }
        if(dp[i][j]!=null)return dp[i][j];
        int way=ways(mat,i+1,j+1,n,m,s+(i+2)+" "+(j+2)+"\n",p,dp);
        way=(way+ways(mat,i+1,j,n,m,s+(i+2)+" "+(j+1)+"\n",p,dp))%mod;
        way=(way+ways(mat,i,j+1,n,m,s+(i+1)+" "+(j+2)+"\n",p,dp))%mod;
        return dp[i][j]=way;
    }
    static void prime(boolean a[]){
        int n=a.length;
        a[0]=true;
        if(n>1)a[1]=true;
        for(int i=2;i<n;i++){
            if(!a[i]){
                for(int j=2;j*i<n;j++){
                    a[j*i]=true;
                }
            }
        }
    }
}
