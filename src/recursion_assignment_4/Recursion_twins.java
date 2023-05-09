package recursion_assignment_4;

import java.util.Scanner;
/*
Take as input str, a string. A “twin” is defined as two instances of a char separated by a char. E.g. "AxA" the A's make a “twin”. “twins” can overlap, so "AxAxA" contains 3 “twins” - 2 for A and 1 for x. Write a function which recursively counts number of “twins” in a string. Print the value returned.

Input Format
Enter the string

Constraints
None

Output Format
Display the number of twins

Sample Input
AXAXA
Sample Output
3
 */
public class Recursion_twins {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int c=twins(s,' ',' ',0);
        System.out.println(c);
    }
    static int twins(String s,char ec,char oc,int c){
        if(s.length()<=0)return c;
        int count =0;
        if(s.length()%2==0){
            if(ec==s.charAt(0))count+=twins(s.substring(1),s.charAt(0),oc,c+1);
            else count+=twins(s.substring(1),s.charAt(0),oc,c);
        }
        else {
            if(oc==s.charAt(0))count+=twins(s.substring(1),ec,s.charAt(0),c+1);
            else count+=twins(s.substring(1),ec,s.charAt(0),c);
        }
        return count;
    }
}
