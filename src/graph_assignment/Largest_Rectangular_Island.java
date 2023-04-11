package graph_assignment;

/*
Given a sea in matrix form where each block either contains 0(represent water) or 1(represent land).Thanos wants to shift at Island.In plotting Farm house for Thanos, it needed Rectangular plot.You have to find the area of the largest rectangular island in this sea.Area of each block in matrix is 1x1.

Input Format
First line takes N(no. of rows) and M(no. of columns) of the matrix.
Next N lines follow each line containing M (integers either 0 or 1) to initialize the matrix respectively.

Constraints
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.

Output Format
Print area of the Largest rectangular island in the sea.

Sample Input
4 5
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Sample Output
6
Explanation
The maximal rectangle is shown in the above picture.
 */
import java.util.*;
public class Largest_Rectangular_Island {
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
        System.out.println(maximalRectangle(g));
    }
    public static int maximalRectangle(char[][] matrix) {
        int a[]=new int[matrix[0].length];
        int m=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    a[j]=0;
                }
                else{
                    a[j]+=matrix[i][j]-'0';
                }
            }
            m=Math.max(m,Area(a));
        }
        return m;
    }
    public  static  int Area(int []arr){
        Stack<Integer> st=new Stack<>();
        int maxarea=0;
        for (int i = 0; i <= arr.length; i++) {
            while (!st.isEmpty()&&(i==arr.length||arr[i]<arr[st.peek()])){
                int h=arr[st.pop()];
                int r=i;
                if(st.isEmpty()){
                    maxarea=Math.max(maxarea,h*r);
                }
                else{
                    int l=st.peek();
                    maxarea=Math.max(maxarea,h*(r-l-1));
                }
            }
            st.push(i);
        }
        return maxarea;
    }
}
