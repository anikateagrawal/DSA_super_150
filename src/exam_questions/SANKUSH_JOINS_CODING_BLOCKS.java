package exam_questions;

/*
Sankush is a first year student at Netaji Subhas University of Technology. He is already quite proficient in programming but to polish his skills more he decides to join “COMPETITIVE PROGRAMMING BOOTCAMP” of Coding Blocks. The batch is taken by everyone’s favourite mentor Prateek Bhaiya. The course is going on currently and Sankush has solved all of the given assignment questions on HackerBlocks.So Prateek Bhaiya decides to have Sankush as a teaching assistant in his next batch.

The first task assigned to Sankush is to modify the questions on HackerBlocks and classify them again as either ‘Medium’ or ‘Difficult’. Prateek Bhaiya wants exactly n/2 questions to be of ‘Difficult’ level and others to be of ‘Medium’’ level. Sankush can modify some questions and rate them again as ‘Medium’ or ‘Difficult’ in one hour. In how many hours Sankush will be able to make the course perfect. A perfect course means it will have exactly n/2 ‘Difficult’ questions.

Hint - You have to find it yourself the value of that count of some questions using the sample test cases.

Input Format
The first line contains an integer n. The second line consists of a string of length n. Each character tells about the level of question, the k-th character is 'D' if the question is difficult and 'd' if the question is medium.

Constraints
1) n is always even. 2) 0<=n<=200

Output Format
Print the minimum number of hours required by Sankush to complete the task.

Sample Input
4
ddDd
Sample Output
1
Explanation
No explanation required
 */
import java.util.*;
public class SANKUSH_JOINS_CODING_BLOCKS {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int m=0,d=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='d')m++;
            else d++;
        }
        if(m>d)System.out.println(Math.abs(m-d)/2-1);
        else
            System.out.println(Math.abs(m-d)/2);
    }
}
