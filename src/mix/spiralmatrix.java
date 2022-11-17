package mix;

import java.util.Scanner;
public class spiralmatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int a[][]=new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j]= sc.nextInt();
            }
        }
        int r=0,c=0,lr=m-1,lc=n-1;
        for (int i = 0; i < m*n; ) {
            for (int j = c; i<m*n && j <= lc; j++) {
                System.out.print(a[r][j]+" ");
                i++;
            }
            r++;
            for (int j = r;i<m*n&& j <= lr; j++) {
                System.out.print(a[j][lc]+" ");i++;
            }
            lc--;
            for (int j = lc;i<m*n&& j >=c ; j--) {
                System.out.print(a[lr][j]+" ");i++;
            }lr--;
            for (int j = lr;i<m*n&& j >=r ; j--) {
                System.out.print(a[j][c]+" ");i++;
            }
            c++;
        }
    }
}
