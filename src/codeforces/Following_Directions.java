package codeforces;

import java.util.Scanner;

public class Following_Directions {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            if(sol(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean sol(String s){
        int r=0,c=0;
//        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'L':c--;break;
                case 'R':c++;break;
                case 'D':r--;break;
                case 'U':r++;break;
            }
//            System.out.println(r+" "+c);
            if(r==1&&c==1)return true;
        }
        return false;
    }
}
