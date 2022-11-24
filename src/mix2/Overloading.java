package mix2;

public class Overloading {
    public static void main(String[] args) {
        System.out.println(add(5,3));
        System.out.println(add(5,3,4));
        System.out.println(add(5,4,5.4f));
        System.out.println(add(5,3,4,5,4));
    }
    public static int add(int a,int b){
        return a+b;
    }
    public static int add(int a,int b,int c){
        return a+b+c;
    }
    public static float add(int a,int b,float c){
        return a+b+c;
    }
    public static int add(int ... a){
        int s=0;
        for (int i:a) {
            s+=i;
        }
        return s;
    }
}
