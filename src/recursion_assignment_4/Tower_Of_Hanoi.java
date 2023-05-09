package recursion_assignment_4;

import java.util.Scanner;
/*
Using a helper stick (peg), shift all rings from peg A to peg B using peg C.
All rings are initally placed in ascending order, smallest being on top.
No bigger ring can be placed over a smaller ring.

Input Format
Single line input containing a single integer N denoting the no of rings.

Constraints
1 <= N <= 10

Output Format
Print the instructions to move all the rings from peg A to B in a new line each.
Each line should follow format : Moving ring i from A/B/C to A/B/C

Sample Input
4
Sample Output
Moving ring 1 from A to C
Moving ring 2 from A to B
Moving ring 1 from C to B
Moving ring 3 from A to C
Moving ring 1 from B to A
Moving ring 2 from B to C
Moving ring 1 from A to C
Moving ring 4 from A to B
Moving ring 1 from C to B
Moving ring 2 from C to A
Moving ring 1 from B to A
Moving ring 3 from C to B
Moving ring 1 from A to C
Moving ring 2 from A to B
Moving ring 1 from C to B
Explanation
Read Tower of Hanoi
 */
public class Tower_Of_Hanoi {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        String src="A";
        String hlp="C";
        String des="B";
        toh(n,src,hlp,des);
    }
    public static void toh(int n,String src,String hlp,String des)
    {
        if(n==0)return;
        toh(n-1,src,des,hlp);
        System.out.println("Moving ring "+n+" from "+src+" to "+des);
        toh(n-1,hlp,src,des);
    }
}
