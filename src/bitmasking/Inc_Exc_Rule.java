package bitmasking;

public class Inc_Exc_Rule {
    public static void main(String[] args) {
        int n=1000;
        int a[]={2,3,5};
        System.out.println(count(n,a));
    }
    public static int count(int n,int a[]){
        int ans=0;
        for (int i=1;i<(1<<a.length);i++){
            int c=countNumber(i,a,n);
            if(countSetBits(i)%2==0){
                ans-=c;
            }
            else ans+=c;
        }
        return ans;
    }
    public static int countNumber(int i,int a[],int n){
        int pos=0;
        int p=1;
        while(i>0){
            if((i&1)>0){
                p*=a[pos];
            }
            i>>=1;
            pos++;
        }
        return n/p;
    }
    public static int countSetBits(int n){
        int c=0;
        while(n>0){
            c++;
            n=n&(n-1);
        }
        return c;
    }
}
