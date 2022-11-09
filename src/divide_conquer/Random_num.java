package divide_conquer;

import java.util.Random;

public class Random_num {
    public static void main(String[] args) {
        int lo=10;
        int hi=100;
        Random r=new Random();
        for (int i = 0; i < 40; i++) {
            int rn=r.nextInt(hi-lo+1)+lo;
            System.out.println(rn);
        }
    }
}
