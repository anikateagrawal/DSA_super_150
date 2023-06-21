package exam_questions;

/*
Monu bhaiya loves to play with parenthesis.He decides to play a game.

How long can a balanced expression be? For example, given a string containing only opening and closing parentheses, what is the maximum length of a well-formed parentheses substring? In other words, how many consecutive parentheses can be properly matched and closed within the string?

Given a string containing just the characters '(' and ')', print the length of the longest valid (well-formed) parentheses substring

Input Format
First Line:It consists of a string with "(" or ")"

Constraints
0 <= s.length <= 3 * 10^4
s[i] is '(', or ')'.

Output Format
It prints the longest valid well formed substring.

Sample Input
(()
Sample Output
2
Explanation
The longest valid parentheses substring is "()".
 */
import java.util.*;
public class Monu_bhaiya_loves_parenthesis {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        System.out.println(maxans);
    }
}
