package string_assignment_3;

import java.util.Scanner;
/*
Deepak and Gautam are having a discussion on a new type of number that they call Coding Blocks Number or CB Number. They use following criteria to define a CB Number.

0 and 1 are not a CB number.
2,3,5,7,11,13,17,19,23,29 are CB numbers.
Any number not divisible by the numbers in point 2( Given above) are also CB numbers.
Deepak said he loved CB numbers.Hearing it, Gautam throws a challenge to him.

Gautam will give Deepak a string of digits. Deepak's task is to find the number of CB numbers in the string.

CB number once detected should not be sub-string or super-string of any other CB number.
Ex- In 4991, both 499 and 991 are CB numbers but you can choose either 499 or 991, not both.

Further, the CB number formed can only be a sub-string of the string.
Ex - In 481, you can not take 41 as CB number because 41 is not a sub-string of 481.

As there can be multiple solutions, Gautam asks Deepak to find the maximum number of CB numbers that can be formed from the given string.

Deepak has to take class of Launchpad students. Help him by solving Gautam's challenge.

Input Format
First line contain size of the string.

Next line is A string of digits.

Constraints
1 <= Length of strings of digits <= 17

Output Format
Maximum number of CB numbers that can be formed.

Sample Input
5
81615
Sample Output
2
Explanation
61 and 5 are two CB numbers.
 */
public class Finding_cb_numbers {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        boolean vis[]=new boolean[s.length()];
        int c=0;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<s.length()-i+1;j++){
                if(check(s.substring(j,j+i))&&isvalid(vis,j,j+i)){
                    c++;
                    for(int k=j;k<j+i;k++)vis[k]=true;
                }
            }
        }
        System.out.println(c);
    }
    static boolean isvalid(boolean vis[],int s,int e){
        for(int i=s;i<e;i++){
            if(vis[i])return false;
        }
        return true;
    }
    static boolean check(String s){
        int a[]={2,3,5,7,11,13,17,19,23,29};
        long l=Long.parseLong(s);
        if(l==0||l==1)return false;
        for(int i=0;i<a.length;i++){
            if(a[i]-l==0)return true;
        }
        for(int i=0;i<a.length;i++){
            if(l%a[i]==0)return false;
        }
        return true;
    }
}
