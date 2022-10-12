package recursion;

import java.util.Scanner;

public class string_per {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        fun(s,"");
    }
    static void fun(String s,String ss){
        if(s.length()==0){
            System.out.println(ss);
            return;
        }
//        for (int i = 0; i < s.length(); i++) {
//            if(s.indexOf(s.charAt(i))==i)
//            fun(s.substring(0,i)+s.substring(i+1),ss+s.charAt(i));
//        }
        int a[]=new int[26];
        for (int i = 0; i < s.length(); i++) {
            if(a[s.charAt(i)-'a']==0) {
                fun(s.substring(0, i) + s.substring(i + 1), ss + s.charAt(i));
                a[s.charAt(i) - 'a']++;
            }
        }
    }
}
