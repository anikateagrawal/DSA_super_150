package greedy_algo;
/*
input
5 60
30 5
40 10
45 15
77 22
90 25
 */
import java.util.Arrays;
import java.util.Scanner;

public class Fractional_Knapsack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        float items[][]=new float[n][3];
        int Capacity=sc.nextInt();
        for (int i = 0; i < n; i++) {
            items[i][0]=sc.nextInt();
            items[i][1]=sc.nextInt();
            items[i][2]=items[i][0]/items[i][1];
        }
        System.out.println("Capacity = "+Capacity);
        Arrays.sort(items,(i1,i2)->{
            if(i1[2]>=i2[2])return -1;else return 1;
        });
        float x[]=new float[n];
        float max_profit=0;
        int i;
        for (i = 0; i < n; i++) {
            if(items[i][1]>Capacity){
                break;
            }
            x[i]=1;
            Capacity-=items[i][1];
        }
        if(i<n){
            x[i]=Capacity/items[i][1];
        }
        for (int j = 0; j < n; j++) {
            max_profit+=items[j][0]*x[j];
        }

        System.out.print("Pi => ");
        for (int j = 0; j < n; j++) {
            System.out.print(items[j][0]+" ");
        }
        System.out.println();
        System.out.print("Wi => ");
        for (int j = 0; j < n; j++) {
            System.out.print(items[j][1]+" ");
        }
        System.out.println();
        System.out.print("Pi/Wi => ");
        for (int j = 0; j < n; j++) {
            System.out.print(items[j][2]+" ");
        }
        System.out.println();
        System.out.print("Xi => ");
        for (int j = 0; j < n; j++) {
            System.out.print(x[j]+" ");
        }

        System.out.println();
        System.out.println("Max Profit = "+max_profit);
    }
}
