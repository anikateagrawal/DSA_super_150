package mix;

import java.util.Scanner;

public class Chocolate_Candy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int x=sc.nextInt();
            int y= sc.nextInt();
            if(2*x>5*y) System.out.println("Chocolate");
            else if(5*y>2*x) System.out.println("Candy");
            else System.out.println("Either");
        }
    }
}
