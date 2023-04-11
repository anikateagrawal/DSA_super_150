package graph_assignment;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Input Format
First line contains two integers m and n denoting rows and columns of the grid map respectively. Following m lines contains n characters each '1' or '0'.

Constraints
None

Output Format
An integer denoting the number of distinct islands.

Sample Input
4 5
11000
11000
00100
00011
Sample Output
3
Explanation
Self Explanatory
 */
import java.util.*;
public class No_of_islands {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char g[][]=new char[m][n];
        for(int i=0;i<m;i++){
            String s=sc.next();
            for(int j=0;j<n;j++){
                g[i][j]=s.charAt(j);
            }
        }
        System.out.println(num(g));
    }
    public static int num(char[][] grid) {
        int ct =0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    ct++;
                    cl(grid,i,j);
                }
            }
        }
        return ct;
    }
    static void cl(char [][] grid,int i,int j)
    {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')return ;
        grid[i][j]='0';
        cl(grid,i+1,j);
        cl(grid,i,j+1);
        cl(grid,i-1,j);
        cl(grid,i,j-1);
        return;
    }
}
