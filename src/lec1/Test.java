package lec1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        if(a>=75)System.out.println("A");
        else if(a>=65)System.out.println("B");
        else if(a>=55)System.out.println("C");
        else if(a>=45)System.out.println("D");
        else if(a>=40)System.out.println("Pass");
        else System.out.println("Fail");
    }
}
