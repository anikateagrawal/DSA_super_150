package stack_queue_assignment_5;

import java.util.Scanner;
/*
Kartik and Parth and very obsessed with strings. then they decided to play a game. where Parth given kartik a string and ask him to print all the possible strings in lexographical order(smaller first and then largest). But while calculating the permuation the following condition must be satisfied. That he can change every letter individually to be lowercase or uppercase to create another string. without changing the order

Input Format
string input

Constraints
1 <= s.length <= 12

Output Format
all possibel permuation of strings under given condition

Sample Input
3z4
Sample Output
3z4 3Z4
 */
public class NewPermutation {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        lex(s,"");
    }
    static void lex(String s,String ans){
        if(s.length()==0)
        {
            System.out.print(ans+" ");
            return;
        }
        if(Character.isLetter(s.charAt(0))){
            lex(s.substring(1),ans+Character.toLowerCase(s.charAt(0)));
            lex(s.substring(1),ans+Character.toUpperCase(s.charAt(0)));
        }
        else{
            lex(s.substring(1),ans+s.charAt(0));
        }
    }
}
