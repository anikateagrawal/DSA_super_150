package dp_assignment;

/*
Given a board of size 2xn , you have place 2x1 tiles . You can place the tile horizontally or vertically . Print the number of ways.

Input Format
Size n

Constraints
1<= n <= 100

Output Format
Number of ways

Sample Input
7
Sample Output
21
 */
import java.util.*;
public class Tilling_Problem {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long a=0,b=1;
        long c=0;
        for(int i=0;i<n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        System.out.println(c);
    }
}
