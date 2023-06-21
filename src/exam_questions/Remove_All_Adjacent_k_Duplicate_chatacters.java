package exam_questions;

/*
You are given with a string and you have to remove k adjacent same characters in the string if there are and you have to keep on doing this task until there are no K adjacent same characters. Note :there is possibility that even after removing the duplicay the left over part when attached forms the two same characters.

Input Format
You have to take the input for the string. second line contains the value of the 'K'.

Constraints
1<=string.length()<=10000.

Output Format
Return the string after removing the K adjacent same characters.

Sample Input
deeedbbcccbdaa
3
Sample Output
aa
Explanation
First delete "eee" and "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete "ddd", get "aa"
 */
import java.util.*;
public class Remove_All_Adjacent_k_Duplicate_chatacters {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        Stack<p> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(new p(ch,1));
            }
            else if(st.peek().ch!=ch){
                st.push(new p(ch,1));
            }
            else{
                p pp=st.pop();
                pp.c++;
                if(pp.c!=k)st.push(pp);
            }
        }
        String ns="";
        while(!st.isEmpty()){
            p pp=st.pop();
            for(int i=0;i<pp.c;i++){
                ns=pp.ch+ns;
            }
        }
        System.out.println(ns);
    }
}
class p{
    char ch;
    int c;
    public p(char c1,int c2){
        ch=c1;
        c=c2;
    }
}
