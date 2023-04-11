package graph_assignment;

/*
Given a snake and ladder board, find the minimum number of dice throws required to reach the destination or last cell from source or 1st cell. The player has total control over outcome of dice throw and wants to find out minimum number of throws required to reach last cell.

Input Format
First line contains integer t as number of test cases.
Each test case contains following input.
First line contains three integers n, l, s which represents the number of cells of board, number of ladders and number of snakes.
Next l lines contains two integers each x & y denoting there is a ladder from x to y.
Next s lines contains two integers each x & y denoting there is a snake from x to y.



Constraints
1 < t < 20 1< n,l,s < 50

Output Format
For each test case you have to print the number which is equal to the minimum number of dice throws to reach the last cell.

Sample Input
1
30 4 4
3 22
5 8
11 26
20 29
17 4
19 7
21 9
27 1
Sample Output
3
Explanation
Player start from the first cell. It goes to 1st 3 (then reach at 22) and then 28 and then 30. Total number of dice thrown is 3.
 */
import java.util.*;
public class Snake_and_Ladders_Board{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int ld=sc.nextInt();
            int s=sc.nextInt();
            List<List<Integer>> l=new ArrayList<>();
            for(int i=0;i<=n;i++)l.add(new ArrayList<>());
            int bd[]=new int[200];
            for(int i=0;i<ld+s;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                bd[a]=b-a;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=6&&i+j+bd[i+j]<=n;j++)l.get(i).add(i+j+bd[i+j]);
            }

            int v[]=new int[n+1];
            Arrays.fill(v,-1);
            Queue<Integer> q=new LinkedList<>();
            v[1]=0;
            q.add(1);
            while(!q.isEmpty()){
                int f=q.poll();
                for(int nb:l.get(f)){
                    if(v[nb]==-1){
                        v[nb]=v[f]+1;
                        q.add(nb);
                    }
                }
            }
            System.out.println(v[n]);
        }
    }
}
