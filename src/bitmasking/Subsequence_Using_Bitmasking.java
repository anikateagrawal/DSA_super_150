package bitmasking;

public class Subsequence_Using_Bitmasking {
    public static void main(String[] args) {
        String s="abc";
        subsequence(s);
    }
    public static void subsequence(String s){
        int n=s.length();
        for(int i=0;i<(1<<n);i++){
            pattern(i,s);
        }
    }
    private static void pattern(int i,String s){
        int pos=0;
        while (i>0){
            if((i&1)!=0){
                System.out.print(s.charAt(pos));
            }
            i>>=1;
            pos++;
        }
        System.out.println();
    }
}
