package generics;

import java.util.Arrays;
import java.util.Comparator;

public class Client {
    public static void main(String[] args) {
        Student arr[]=new Student[5];
        System.out.println(arr[0]);
        arr[0]=new Student("pappu",12);
        arr[1]=new Student("pappy",1);
        arr[2]=new Student("a",17);
        arr[3]=new Student("b",99);
        arr[4]=new Student("c",5);
        System.out.println(Arrays.toString(arr));
        bubble(arr,new cc());
        System.out.println(Arrays.toString(arr));
    }
    public static<T extends Comparable<T>> void  bubble(T[]a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if(a[j].compareTo(a[j+1])>0)
                {
                    T t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }
    public static<T extends Comparable<T>> void  bubble(T[]a,Comparator<T> o){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if(o.compare(a[j],a[j+1])>0)
                {
                    T t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }
}
class cc implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.compareTo(o2);
    }
}
