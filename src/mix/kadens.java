package mix;

public class kadens {
    public static void main(String[] args) {
        int arr[]={1,2,3};
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i< arr.length;i++){
            sum+=arr[i];
            ans=Math.max(ans,sum);
            if(sum<0)sum=0;
        }
    }

}
