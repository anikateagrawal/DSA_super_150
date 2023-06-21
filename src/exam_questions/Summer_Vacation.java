package exam_questions;

/*
Mohan has completed his second year of engineering. He has his summer vacation ahead, of 2 months, so he decided to take some online courses for his internship and placement preparation. For this, he browsed some renowned institutions for the training and found Coding Blocks to be the best than others. Now, in Coding Blocks, there were n different online courses numbered from 1 to n. Mohan wants to select maximum number of courses so that he can earn more skills and technical knowledge to be a best Software Engineer. Now, You are given an array course where :

course[i] = [timei , Ldayi]

indicate that the ith course should be taken continuously for timei days and must be finished before or on Ldayi.

Mohan will start on the 1st day and he cannot take two or more courses simultaneously.

Print the maximum number of courses that Mohan can take.

Input Format
First Line contains Number of Rows of Matrix
Second Line contains Number of Columns of Matrix
Third Line contains Matrix

Constraints
1 <= course.length <= 104
1 <= timei , Ldayi<= 104

Output Format
Print the maximum number of courses. (Integer)

Sample Input
4
2
100 200
200 1300
1000 1250
2000 3200
Sample Output
3
Explanation
There are total 4 courses, but Mohan can take 3 courses at most:

First, take the 1st course, it costs 100 days so Mohan will finish it on the 100th day, and ready to take the next course on the 101st day.

Second, take the 3rd course, it costs 1000 days so Mohan will finish it on the 1100th day, and ready to take the next course on the 1101st day.

Third, take the 2nd course, it costs 200 days so Mohan will finish it on the 1300th day.

The 4th course cannot be taken now, since Mohan will finish it on the 3300th day, which exceeds the closed date.
 */
import java.util.*;
class Summer_Vacation {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int c[][]=new int[n][m];
        for(int i=0;i<n;i++){
            c[i][0]=sc.nextInt();
            c[i][1]=sc.nextInt();
        }
        Arrays.sort(c,(i1,i2)->i1[1]-i2[1]);
        int s=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            if(s+c[i][0]<=c[i][1]){
                pq.add(c[i][0]);
                s+=c[i][0];
            }
            else if(!pq.isEmpty()&&pq.peek()>c[i][0]){
                s+=c[i][0]-pq.poll();
                pq.add(c[i][0]);
            }
        }
        System.out.println(pq.size());
    }
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue < Integer > queue = new PriorityQueue < > ((a, b) -> b - a);
        int time = 0;
        for (int[] c: courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }
}
