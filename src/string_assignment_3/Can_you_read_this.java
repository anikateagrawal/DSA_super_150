package string_assignment_3;

import java.util.Scanner;
/*
One of the important aspect of object oriented programming is readability of the code. To enhance the readability of code, developers write function and variable names in Camel Case. You are given a string, S, written in Camel Case. FindAllTheWordsContainedInIt.

Input Format
A single line contains the string.

Constraints
|S|<=1000

Output Format
Print words present in the string, in the order in which it appears in the string.

Sample Input
IAmACompetitiveProgrammer
Sample Output
I
Am
A
Competitive
Programmer
Explanation
There are 5 words in the string.
 */
public class Can_you_read_this {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String ss="";
        s=s+"A";
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch) && !s.equals("")){
                System.out.println(ss);
                ss=""+ch;
            }
            else ss+=ch;
        }
    }
}
