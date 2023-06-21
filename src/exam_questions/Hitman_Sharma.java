package exam_questions;

/*
Rohit smashed 16 sixes during his knock of 209 against Australia in Bangalore in 2013. This was Rohit's first double ton and it helped India win a high-scoring series 3-2. Rohit Sharma is now known as a sixer king. While he is the most six-hitter in T20I history (127 sixes), he is also the third-most six-hitter in international cricket history (423 sixes), and the fourth-most six-hitter in ODI history (244 sixes). He is also the most six hitters among the Indians in T20 cricket (361 sixes). Rohit Sharma has great hitting power. He only deals with six. Fernandez is a fan of Rohit Sharma and is very excited to watch the IPL. Rohit Sharma played N Ipl matches and in every ith match count of sixes is given. Find the maximum count of matches for which the sixes are strictly increasing from the previous match.



Input Format
The first line contains an integer T, denotes total number of test cases. Then following T lines contains an integer N denotes the Number of Matches and next line contains N element which denotes count of sixes of ith match

Constraints
1<= T <= 10
1<=N<=10^5
count of sixes of ith match<=10^3

Output Format
print maximum count of matches for which the sixes are strictly increasing from the previous match.

Sample Input
1
8
10 9 2 5 3 7 19 18
Sample Output
4
 */

import java.util.*;
public class Hitman_Sharma{
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(l.size()==0||a[i]>l.get(l.size()-1)){
                    l.add(a[i]);
                }
                else{
                    int lo=0,hi=l.size()-1;
                    int ans=0;
                    while(lo<=hi){
                        int mid=lo+(hi-lo)/2;
                        if(l.get(mid)>=a[i]){
                            ans=mid;
                            hi=mid-1;
                        }
                        else lo=mid+1;
                    }
                    l.set(ans,a[i]);
                }
            }
            System.out.println(l.size());
        }
    }
}
