package recursion_assignment_4;

import java.util.Scanner;
/*
Take as input N, a number. N is the size of a snakes and ladder board (without any snakes and ladders). Take as input M, a number. M is the number of faces of the dice.

a. Write a recursive function which returns the count of different ways the board can be traveled using the dice. Print the value returned.

b. Write a recursive function which prints dice-values for all valid paths across the board (void is the return type for function).

Input Format
Enter a number N (size of the board) and number M(number of the faces of a dice)

Constraints
None

Output Format
Display the number of paths and print all the paths in a space separated manner

Sample Input
3
3
Sample Output
111 12 21 3
4
 */
public class BoardPath {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int c=maze(m,n,"");
        System.out.println("\n"+c);
    }
    static int maze(int m,int n,String ans){
        if(m==0){
            System.out.print(ans+" ");
            return 1;
        }
        int c=0;
        for(int i=1;i<=n;i++){
            if(m>=i)c+=maze(m-i,n,ans+i);
        }
        return c;

    }
}
