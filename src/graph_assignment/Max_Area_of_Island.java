package graph_assignment;

/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Print the maximum area of an island in grid. If there is no island, Print 0.

Input Format
First line takes integers N(no of rows) and M(no of column) Next N lines each following M space separated integers describing grid matrix.

Constraints
1<=M,N<=100
grid[i]=1 or 0.

Output Format
Print the maximum area of an island in grid

Sample Input
4 5
0 0 1 0 0
1 1 1 1 1
0 0 1 0 1
1 1 0 0 0
Sample Output
8
Explanation
0 0 1 0 0
1 1 1 1 1
0 0 1 0 1
1 1 0 0 0
highlighted Island is the island with max area where max area be 8.


 */
import java.util.*;
public class Max_Area_of_Island {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();
        char g[][]=new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                g[i][j]=(char)(sc.nextInt()+'0');
            }
        }
        System.out.println(num(g));

    }
    public static int num(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    a=0;
                    cl(grid,i,j);
                    ans=Math.max(ans,a);
                }
            }
        }
        return ans;
    }
    static int a;
    static void cl(char [][] grid,int i,int j)
    {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')return ;
        grid[i][j]='0';
        a++;
        cl(grid,i+1,j);
        cl(grid,i,j+1);
        cl(grid,i-1,j);
        cl(grid,i,j-1);
        return;
    }
}

