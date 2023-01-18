package sorting;

import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int a[]={5,10,8,20,18,6};
        for (int i = 0; i < a.length; i++) {
            int min=a[i];
            int in=i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j]<min){
                    min=a[j];
                    in=j;
                }
            }
            int tmp=a[i];
            a[i]=a[in];
            a[in]=tmp;
        }
        System.out.println(Arrays.toString(a));
    }
}
