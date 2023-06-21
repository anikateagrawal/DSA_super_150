package exam_questions;

/*
Once upon a time, a group of friends decided to have a get-together party. They all lived in a binary grid of size m x n, where each "1" marked the home of a friend.

To have the party, they needed to select a meeting point that minimized the total travel distance. The total travel distance was calculated as the sum of distances between the houses of the friends and the meeting point. The distance was calculated using the Manhattan Distance formula, where the distance between two points (p1 and p2) is the sum of the absolute differences of their x and y coordinates, i.e.

distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|

The friends decided to use an algorithm to find the optimal meeting point. The algorithm would find all the possible meeting points in the grid and calculate the total travel distance for each meeting point. Then, it would select the meeting point with the minimal total travel distance as the optimal meeting point for the party.

The friends were excited to use the algorithm to find the optimal meeting point and have a great party together.

As they are busy in the arrangement of party, can you help them to make the required algorithm?


Input Format
First line contains integer m and n representing number of rows and number of columns respectively.
Next m lines contains n integers representing elements of matrix.

Constraints
m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[i][j] is either 0 or 1.
There will be at least two friends in the grid.
Output Format
Print an integer denoting the total travel distance

Sample Input
3 5
1 0 0 0 1
0 0 0 0 0
0 0 1 0 0
Sample Output
6
Explanation
Given three friends living at (0,0), (0,4), and (2,2).
The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal.
So return 6.
 */
import java.util.*;
public class Finding_the_Optimal_Meeting_Point_for_a_Get_Together_Party {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<int []> p=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int a=sc.nextInt();
                if(a==1)p.add(new int[]{i,j});
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum=0;
                for(int a[]:p){
                    sum+=Math.abs(a[0]-i)+Math.abs(a[1]-j);
                }
                min=Math.min(min,sum);
            }
        }
        System.out.println(min);
    }
}
