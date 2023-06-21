package exam_questions;

/*
Once upon a time, there was a young boy named Jack who loved playing games. One day, he stumbled upon a new game called "Mark and Score" which had an interesting algorithm.

The game consisted of an array of positive integers, and the objective was to choose the smallest unmarked integer, add it to the score, and then mark the chosen element and its two adjacent elements if they exist. The game continued until all the array elements were marked, and the final score was the sum of all the chosen integers.

Jack was excited to try out the game. He is given the array of integers and he started playing the game.

He continued playing the game, choosing the smallest unmarked integer and adding it to the score until all the array elements were marked. At the end of the game, he calculated the final score and was thrilled with the result.

Can you print that final score if array is given?

Input Format
The first line contains n, size of array. Next line contains n space separated integers.

Constraints
1 <= arr.length <= 105
1 <= arr[i] <= 106

Output Format
Print the final score as an integer value.

Sample Input
6
2 3 5 1 3 2
Sample Output
5
Explanation
We mark the elements as follows:

1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,5,1,3,2].
2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [2,3,5,1,3,2].
2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2]. Our score is 1 + 2 + 2 = 5.
 */
import java.util.*;
public class Mark_and_Score {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        PriorityQueue<Pair> q=new PriorityQueue<>((i1,i2)->{
            return i1.v-i2.v;
        });
        for(int i=0;i<n;i++){
            q.add(new Pair(a[i],i));
        }
        int sum=0;
        boolean m[]=new boolean[n];
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(m[p.in])continue;
            m[p.in]=true;
            sum+=p.v;
            if(p.in==0&&n>1){
                m[p.in+1]=true;
            }
            else if(p.in==n-1&&n>1){
                m[p.in-1]=true;
            }
            else if(n>2){
                m[p.in-1]=true;
                m[p.in+1]=true;
            }
        }
        System.out.println(sum);
    }

}
class Pair{
    int v,in;
    Pair(int val,int ind){
        v=val;
        in=ind;
    }
}
