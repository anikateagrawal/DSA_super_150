package dynamic_programming;

public class Valentine_Magic {
    public static void main(String[] args) {
        int []boys={2,11,3};
        int []girls={5,7,3,2};
    }
    public static int MinDiff(int []boys,int []girls,int i,int j){
        if(i==boys.length)return 0;
        if(j==girls.length)return 10000000;
        int pair=Math.abs(boys[i]-girls[j])+MinDiff(boys,girls,i+1,j+1);
        int nopair=MinDiff(boys,girls,i,j+1);
        return Math.min(pair,nopair);
    }
}
