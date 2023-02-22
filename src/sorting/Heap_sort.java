package sorting;

import java.util.Scanner;

public class Heap_sort {
    static int heapsize;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        heapSort(a);
        for(int i:a) System.out.print(i+" ");
    }
    static void heapSort(int a[]){
        int n= a.length;
        heapsize=n;
        for (int i = n/2; i >=0 ; i--) {
            heapify(a,i);
        }
        for (int i = n-1; i >=1 ; i--) {
            int t=a[0];
            a[0]=a[i];
            a[i]=t;
            heapsize--;
            heapify(a,0);
        }
    }
    static void heapify(int a[],int i){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left<heapsize && a[left]>a[largest])largest=left;
        if(right<heapsize && a[right]>a[largest])largest=right;
        if(largest!=i){
            int t=a[i];
            a[i]=a[largest];
            a[largest]=t;
            heapify(a,largest);
        }
    }
}
