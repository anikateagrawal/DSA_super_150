package recursion;

import java.util.*;
public class rat_maze {
    static int f=0;
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char a[][]=new char[m][n];
        for(int i=0;i<m;i++){
            String s=sc.next();
            for(int j=0;j<n;j++){
                a[i][j]=s.charAt(j);
            }
        }
        rat(a,new int[m][n],0,0);
        if(f==0) System.out.println("NO PATH FOUND");
    }
    static void rat(char [][]a,int m[][],int i,int j){
        if(i<0||i>=a.length||j<0||j>=a[0].length||a[i][j]=='X'){
            return;
        }
        m[i][j]=1;
        if(i==a.length-1&& j==a[0].length-1)
        {
            f=1;
            for (int k = 0; k < m.length; k++) {
                for (int l = 0; l < m[0].length; l++) {
                    System.out.print(m[k][l]+" ");
                }
                System.out.println();
            }
            return;
        }
        a[i][j]='X';
        rat(a,m,i+1,j);
        rat(a,m,i-1,j);
        rat(a,m,i,j+1);
        rat(a,m,i,j-1);
        m[i][j]=0;
        a[i][j]='O';
    }
}