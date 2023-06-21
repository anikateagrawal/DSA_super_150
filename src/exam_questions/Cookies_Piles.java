package exam_questions;

/*
The kids in kindergarten made Christmas cookies with their teacher, and piled them up in columns. They then arranged the columns so that the tops of the columns, going from shortest to tallest, were in a nice straight ramp. The cookies were all of uniform size. Given that there were A cookies in the shortest pile, that the difference in height between any two adjacent piles was D cookies, and that there were N piles, can you write a program to figure out how many cookies there were in total?

Input Format
The first line contains the number of test cases T. T lines follow, one corresponding to each test case, containing 3 integers : N, A and D.

Constraints
T <= 100000
1 <= N, A, D <=100

Output Format
Output T lines, each line containing the required answer for the corresponding test case.

Sample Input
3
1 1 1
3 5 6
2 1 2
Sample Output
1
33
4

Explanation
In the second test case the sequence is: 5, 11, 17 whose sum is 33.
 */
import java.util.*;
public class Cookies_Piles {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a=sc.nextInt();
            int d=sc.nextInt();
            System.out.println((2L*a+(n-1)*d)*n/2);
        }
    }
}
