package mix2;

import java.util.Scanner;

public class Student_Client {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long  n=sc.nextLong();
        System.out.println(findNth(n));
    }
    static long findNth(long N)
    {
        //code here
        long mul=1;
        long num=0;
        while(N>0){
            num+=N%7*mul;
            mul*=10;
            N/=7;
        }
        return num;
    }
}
