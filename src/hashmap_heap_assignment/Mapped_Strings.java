package hashmap_heap_assignment;

/*
We are given a hashmap which maps all the letters with number. Given 1 is mapped with A, 2 is mapped with B…..26 is mapped with Z. Given a number, you have to print all the possible strings.

Input Format
A single line contains a number.

Constraints
Number is less than 10^6

Output Format
Print all the possible strings in sorted order in different lines.

Sample Input
123
Sample Output
ABC
AW
LC
Explanation
'1' '2' '3' = ABC
'1' '23' = AW
'12' '3' = LC
 */
import java.util.*;
public class Mapped_Strings{
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        fun(s,"");
    }
    static void fun(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        if(s.length()>1){
            int n=s.charAt(0)-'0';
            fun(s.substring(1),ans+(char)('A'+n-1));
            n=n*10+s.charAt(1)-'0';
            if(n<26)
                fun(s.substring(2),ans+(char)('A'+n-1));
        }
        else fun(s.substring(1),ans+(char)('A'+s.charAt(0)-'0'-1));
    }
}

