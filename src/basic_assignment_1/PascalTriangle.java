package basic_assignment_1;

import java.util.Scanner;
/*
Take N (number of rows), print the following pattern (for N = 6)
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1

Input Format
Constraints
0 < N < 100

Output Format
Sample Input
6
Sample Output
1
1	1
1	2	1
1	3	3	1
1	4	6	4	1
1	5	10	10	5	1
Explanation
Each number is separated from other by a tab.
 */
public class PascalTriangle {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            int k=1;
            for(int j=1;j<=i;j++){
                System.out.print(k+"\t");
                k=k*(i-j)/(j);
            }
            System.out.println();
        }
    }
}
