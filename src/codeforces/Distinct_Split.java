package codeforces;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Distinct_Split {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            System.out.println(sol(s));
        }
    }
    static int sol(String s){
        int l[]=new int[s.length()];
        int r[]=new int[s.length()];
        Set<Character> st=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            st.add(s.charAt(i));
            l[i]=st.size();
        }
        st.clear();
        for (int i = s.length()-1; i >=0 ; i--) {
            st.add(s.charAt(i));
            r[i]=st.size();
        }
        int max=0;
        for (int i = 0; i < s.length()-1; i++) {
            max=Math.max(max,l[i]+r[i+1]);
        }
//        System.out.println(Arrays.toString(l)+" "+Arrays.toString(r));
        return max;
    }
}
