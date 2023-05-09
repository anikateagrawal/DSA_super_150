package dp_assignment;

/*
Take as input N, a number. N is the size of a snakes and ladder board (without any snakes and ladders). Take as input M, a number. M is the number of faces of the dice.

a. Write a recursive function which returns the count of different ways the board can be traveled using the dice. Print the value returned.

b. Write a recursive function which prints dice-values for all valid paths across the board (void is the return type for function).

Input Format
Enter a number N (size of the board) and number M(number of the faces of a dice)

Constraints
M<=100
N<=100
M^N <=10^9

Output Format
Display the number of paths and print all the paths in a space separated manner

Sample Input
3
3
Sample Output
111 12 21 3
4
 */
import java.util.*;
public class Boardpath_Count_Print {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println("\n"+t(n,m,""));
    }
    static int t(int n,int m,String a){
        if(n==0){
            System.out.print(a+" ");
            return 1;
        }
        if(n<0)return 0;
        int ans=0;
        for(int i=1;i<=m;i++){
            ans+=t(n-i,m,a+i);
        }
        return ans;
    }
}

