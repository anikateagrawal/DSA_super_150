package mix;

public class FixedSlidingWindow {
    public static void main(String[] args) {
        int arr[]={2,3,7,8,9};
        int k=3;
        int i=0;
        int sum=0,max=0;
        while(i<arr.length){
            if(i<k){
                sum+=arr[i++];
                max=Math.max(sum,max);
                continue;
            }
            sum+=arr[i]-arr[i-k];
            max=Math.max(sum,max);
            i++;
        }
        System.out.println(max);
    }
}
