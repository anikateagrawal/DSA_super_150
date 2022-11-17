package mix;

public class Sieve_of_Eratosthenes {
    public static void main(String[] args) {
        int n=100;
        primeSieve(n);
    }
    public static void primeSieve(int n){
        boolean a[]=new boolean[n+1];
        a[0]=a[1]=true;
        for (int i = 2; i*i <=n ; i++) {
            if(!a[i]){
                for (int j = 2; i*j <=n ; j++) {
                    a[i*j]=true;
                }
            }
        }
        for (int i = 0; i < n+1; i++) {
            if(!a[i])
            System.out.println(i);
        }
    }
}
