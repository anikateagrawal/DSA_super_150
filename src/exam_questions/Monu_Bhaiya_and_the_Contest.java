package exam_questions;

/*
Monu Bhaiya is an awesome Instructor at Coding Blocks with really cool mentoring skills and his hardworking students have done really great and have submitted all the questions till now.

So, he decided to test their coding skills and announced a Coding Contest in her batch of N students. All the students are not available at the same time for the test and the arrival time of the students can be different.

Let the time when a student can to the CB to give the test and the time when a student leave the CB premises be denoted by Ai and Di respectively, where 0<= i < n .
For the contest, he needs to provide laptops so that students can attempt the contest.
Your task is to help him with the minimum number of laptops he needs to purchase to conduct the Hackathon without keeping even a single student waiting.

Input Format
The first line contains a single integer T denoting the number of test cases.
The next input is N, denoting the number of students.
The next line will be the input Ai and Di, i∈[0,n), denoting the arrival and departure time of the students to CB premises.

Constraints
0 < A[i] <= 2400,
A[i] < D[i], where 0<=i<n

Output Format
Display the minimum number of laptop required for each test case separated by a newline.

Sample Input
1
6
900 940 950 1100 1500 1800
910 1200 1120 1130 1900 2000
Sample Output
3
Explanation
Here, A[] = {900, 940, 950, 1100, 1500, 1800}, D[] = {910, 1200, 1120, 1130, 1900, 2000}
There are at most 3 laptops needed at a time (time between 11:00 to 11:20).
 */
import java.util.*;
public class Monu_Bhaiya_and_the_Contest {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int s[]=new int[n];
            int f[]=new int[n];
            for(int i=0;i<n;i++)s[i]=sc.nextInt();
            for(int i=0;i<n;i++)f[i]=sc.nextInt();
            Arrays.sort(s);
            Arrays.sort(f);
            int l=1;
            int in=0;
            for(int i=1;i<n;i++){
                if(s[i]<f[in])l++;
                else in++;
            }
            System.out.println(l);
        }
    }
}