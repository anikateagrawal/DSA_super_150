package divide_conquer;

public class Power {
    public static void main(String[] args) {
        int p=power(2,9);
        System.out.println(p);
    }
    public static int power(int a,int b)
    {
        if(b==0)return 1;
        int ans=power(a,b/2);
        if(b%2==0){
            return ans*ans;
        }
        else
            return ans*ans*a;
    }
}
