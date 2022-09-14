package lec1;

import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int divisor= sc.nextInt();
        int dividend=sc.nextInt();
        while(dividend%divisor!=0){
            int tmp=divisor;
            divisor=dividend%divisor;
            dividend=tmp;
        }
        System.out.println(divisor);
    }
}
