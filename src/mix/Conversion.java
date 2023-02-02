package mix;

import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long mul=1;
        long sum=0;
        while(n>0){
            long r=n%7;
            sum+=r*mul;
            mul*=10;
            n/=7;
        }
        System.out.println(sum);
    }
}
