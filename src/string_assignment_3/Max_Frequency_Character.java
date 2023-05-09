package string_assignment_3;

import java.util.Scanner;
/*
Take as input S, a string. Write a function that returns the character with maximum frequency. Print the value returned.

Input Format
String

Constraints
A string of length between 1 to 1000.

Output Format
Character

Sample Input
aaabacb
Sample Output
a
Explanation
For the given input string, a appear 4 times. Hence, it is the most frequent character.
 */
public class Max_Frequency_Character {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int max=0;
        char ch=' ';
        for(int i=0;i<s.length();i++){
            int c=1;
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j))c++;
            }
            if(c>max){
                max=c;
                ch=s.charAt(i);
            }
        }
        System.out.println(ch);
    }
}
