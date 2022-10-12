package recursion;

import java.util.Scanner;

public class lexical_numbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        lexi(0,n);
    }
    public static void lexi(int start,int end)
    {
        if(start>end)return;
        int i=0;
        if(start==0)i=1;
        System.out.println(start);
        while(i<10)
        {
            lexi(start*10+i,end);
            i++;
        }
    }
}
