package recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class generate_parenthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> s=generateParenthesis(n);
        System.out.println(s);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> l=new LinkedList();
        g(n,l,0,0,"");
        return l;
    }
    static void g(int n,List<String> l,int o,int c,String ans){
        if(o==n&&c==n){
            l.add(ans);return;
        }
        if(o<n)
        g(n,l,o+1,c,ans+"(");
        if(c<o)
            g(n,l,o,c+1,ans+")");
    }
}
