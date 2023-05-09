package stack_queue_assignment_5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
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
public class MappedStrings {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        List<String> l=new LinkedList<String>();
        map(s,"",l);
        for(String ss:l){
            System.out.println(ss);
        }
    }
    static void map(String s,String ans,List<String> l){
        if(s.length()==0){
            l.add(ans);
            return;
        }
        if(s.length()>1){
            int n1=Integer.parseInt(""+s.charAt(0));
            map(s.substring(1),ans+(char)(n1+64),l);
            int n2=Integer.parseInt(s.substring(0,2));
            if(n2<27)map(s.substring(2),ans+(char)(n2+64),l);
        }
        else {
            int n1=Integer.parseInt(""+s.charAt(0));
            map(s.substring(1),ans+(char)(n1+64),l);
        }
    }
}
