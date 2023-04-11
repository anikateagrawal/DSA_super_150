package graph_assignment;

/*
A Square room in the form of 2D binary matrix is filled with Red and Blue Colour . Find the total number of connected sets in that matrix
Explanation:
Connected set can be defined as group of cell(s) which has "Red" mentioned on it and have at least one other cell in that set with which they share the neighbor relationship. A cell with "Red" in it and no surrounding neighbor having "Red" in it can be considered as a set with one cell in it. Neighbors can be defined as all the cells adjacent to the given cell in 8 possible directions ( i.e N , W , E , S , NE , NW , SE , SW direction ). A cell is not a neighbor of itself.
Note : Here Red Colour is denoted by 1
and Blue Colour is denoted by 0

Input Format
First line of the input contains T , number of test-cases.

Then follow T testcases. Each testcase has given format.

N [ representing the dimension of the matrix N X N ].

Followed by N lines , with N numbers on each line.

Constraints
0 < T < 6

0 < N < 1009

Output Format
For each test case print one line , number of connected component it has.

Sample Input
2
4
0 0 1 0
1 0 1 0
0 1 0 0
1 1 1 1
5
1 0 0 1 1
0 0 1 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
Sample Output
1
3
 */
import java.util.*;
public class Two_D_Magical_matrix {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int m=sc.nextInt();
            char g[][]=new char[m][m];
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    g[i][j]=(char)(sc.nextInt()+'0');
                }
            }
            System.out.println(num(g));
        }

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
        cl(grid,i+1,j+1);
        cl(grid,i+1,j-1);
        cl(grid,i-1,j+1);
        cl(grid,i-1,j-1);
        cl(grid,i+1,j);
        cl(grid,i,j+1);
        cl(grid,i-1,j);
        cl(grid,i,j-1);
        return;
    }
}

