package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        List<List<String>> l=new ArrayList<>();
        Partitioning(s,"",l,new ArrayList<>());
        System.out.println(l);
    }
//    public static void Partitioning(String ques,String ans,List<List<String>> l){
//        if(ques.length()==0){
//            System.out.println(ans);
//            ans=ans.substring(0, ans.length()-1);
//            String ss[]=ans.split(" ");
////            System.out.println(Arrays.toString(ss));
//            l.add(Arrays.asList(ss));
//            return;
//        }
//        for (int cut = 1; cut <= ques.length(); cut++) {
//            String s=ques.substring(0,cut);
//            if(isPalin(s))
//                Partitioning(ques.substring(cut),ans+s+" ",l);
//        }
//    }
public static void Partitioning(String ques,String ans,List<List<String>> l,List<String> ll){
    if(ques.length()==0){
        l.add(List.copyOf(ll));
        return;
    }
    for (int cut = 1; cut <= ques.length(); cut++) {
        String s=ques.substring(0,cut);
        if(isPalin(s)){
            ll.add(s);
            Partitioning(ques.substring(cut),ans+s+"|",l,ll);
            ll.remove(ll.size()-1);
        }

    }
}
    static boolean isPalin(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
}
