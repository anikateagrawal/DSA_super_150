package lec1;

import java.util.Scanner;

public class pattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int row=1;
        int star=n;
        int space=0;
        while(row<=2*n-1){
            int i=1;
            while(i++<=space){
                System.out.print("  ");}
            int j=1;
            while (j++<=star){
                System.out.print("* ");
            }
            System.out.println();
            row++;
            if(row>n){star++;space-=2;}
            else {
                star -= 1;
                space+=2;
            }
        }
    }
}
