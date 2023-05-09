package dynamic_programming;
//Treats for the cows
public class Wine_Problem {
    public static void main(String[] args) {
        int wine[]={2,3,5,1,4};
        System.out.println(MaxProfit(wine,0,wine.length-1,1));
        System.out.println(MaxProfitBU(wine));
    }
    public static int MaxProfit(int wine[],int i,int j,int year){
        if(i>j)return 0;
        int fst=wine[i]*year+MaxProfit(wine,i+1,j,year+1);
        int lst=wine[j]*year+MaxProfit(wine,i,j-1,year+1);
        return Math.max(fst,lst);
    }
    public static int MaxProfitBU(int wine[]){
        int dp[][]=new int[wine.length][wine.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i]=wine[i]*wine.length;
        }
        int year=wine.length-1;
        for (int dia=1;dia<dp.length;dia++){
            for (int j = dia; j < wine.length; j++) {
                int i=j-dia;
                dp[i][j]=Math.max(wine[i]*year+dp[i+1][j],wine[j]*year+dp[i][j-1]);
            }
            year--;
        }
        return dp[0][dp.length-1];
    }
}
