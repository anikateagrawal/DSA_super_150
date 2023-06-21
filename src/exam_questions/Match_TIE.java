package exam_questions;

/*
Consider a 2-D Coordinate with a horizontal river passing through its center. There are n cities on the southern bank with x-coordinates y1(1) … y1(n) and n cities on the northern bank with x-coordinates y2(1) … y2(n). You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross. When connecting cities, you can only connect city i on the northern bank to city i on the southern bank.
Maximum number of bridges that can be built to connect north-south pairs with the above-mentioned constraints. Can you help to Solve this Question Because you're fan of RCB

Input Format
Take a number n, representing the number of City.
next Line Contains n n pair of numbers, representing the x-coordinates north city and x-coordinates of south cities.

Constraints
0 <= n <= 1000

Output Format
A number representing the count of maximum number of non-overlapping bridges.

Sample Input
4
6 2
4 3
2 6
1 5
Sample Output
2
Explanation
For the north-south pairs(2, 6) and (1, 5) the bridges can be built. We can consider other pairs also, but then only one bridge can be built because more than one bridge built will then cross each other.
 */
import java.util.*;
public class Match_TIE {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        Arrays.sort(a,(i1,i2)->{
            if(i1[0]==i2[0])return i1[1]-i2[1];
            else return i1[0]-i2[0];
        });
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            int num=a[i][1];
            if(l.size()==0||num>=l.get(l.size()-1))l.add(num);
            else{
                int ans=0;
                int lo=0,hi=l.size()-1;
                while(lo<=hi){
                    int mid=lo+(hi-lo)/2;
                    if(l.get(mid)>num){
                        ans=mid;
                        hi=mid-1;
                    }
                    else lo=mid+1;
                }
                l.set(ans,num);
            }
        }
        System.out.println(l.size());
    }
}
