package dynamic_programming;

public class Matrix_Chain_Multiplication {
    public static void main(String[] args) {
        int a[]={4,2,3,5,1};
        System.out.println(mcm(a,0,a.length-1));
    }
    static int mcm(int a[],int si,int ei){
        if(si+1==ei)return 0;
        int ans=Integer.MAX_VALUE;
        for(int k=si+1;k<ei;k++){
            int fs=mcm(a,si,k);
            int ss=mcm(a,k,ei);
            int rs=a[si]*a[k]*a[ei];
            ans=Math.min(ans,fs+ss+rs);
        }
        return ans;
    }
}
