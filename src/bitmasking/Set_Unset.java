package bitmasking;

public class Set_Unset {
    public static void main(String[] args) {
        int n=84;
        int pos=4;
        System.out.println(setOrNot(n,pos));
    }
    public static boolean setOrNot(int n,int pos){
        return (n&(1<<pos))>0;
    }
}
