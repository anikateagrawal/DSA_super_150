package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Shell_Sort {
    static void shellSort( int a[], int n)
    {
        int d, temp, i;
        d=n/2;
        while (d>=0)
        {
            for (i=0; i <n-d ; i++)
            {
                if(a[i] > a[i+d])
                {
                    temp = a[i];
                    a[i] = a[i+d];
                    a[i+d] = temp;
                }
            }
            System.out.println(d+" "+Arrays.toString(a));
            if(d==1)
            {
                for (i=0; i <n-d ; i++)
                {
                    if(a[i] > a[i+d])
                    {
                        temp = a[i];
                        a[i] = a[i+d];
                        a[i+d] = temp;
                    }
                }
                return;
            }
            d= (int)Math.floor((d/2.0)+0.5);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        shellSort(a,n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
