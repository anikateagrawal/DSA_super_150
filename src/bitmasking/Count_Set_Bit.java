package bitmasking;

public class Count_Set_Bit {
    public static void main(String[] args) {
        int n=67;
        int c=0;
        while(n!=0){
            c++;
            n=n&(n-1);
        }
        System.out.println(c);
    }
}
