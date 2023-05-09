package recursion_assignment_4;

import java.util.Scanner;
/*
Take as input str, a number in form of a string. Write a recursive function to convert the number in string form to number in integer form. E.g. for “1234” return 1234. Print the value returned.

Input Format
Enter a number in form of a String

Constraints
1 <= Length of String <= 10

Output Format
Print the number after converting it into integer

Sample Input
1234
Sample Output
1234
Explanation
Convert the string to int. Do not use any inbuilt functions.
 */
public class convert_string_to_integer {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        fun(s,0);
    }
    static void fun(String s,int n){
        if(s.length()==0){System.out.println(n);return;}
        n=n*10+s.charAt(0)-'0';
        fun(s.substring(1),n);
    }

}
