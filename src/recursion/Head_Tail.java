package recursion;

public class Head_Tail {
    public static void main(String[] args) {
        String s="HT";
        fun(s,"",3);
    }
    static void fun(String s,String ss,int n){
        if(n==0){
            System.out.println(ss);
            return;
        }
        if(ss.length()==0||ss.charAt(ss.length()-1)!='H')
        fun(s,ss+s.charAt(0),n-1);
        fun(s,ss+s.charAt(1),n-1);
    }

}
