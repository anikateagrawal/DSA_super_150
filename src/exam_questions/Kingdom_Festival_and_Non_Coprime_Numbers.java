package exam_questions;
/*
Once upon a time, there was a kingdom ruled by a wise and just king. The kingdom was home to many different tribes, each with their own unique customs and traditions. The king wanted to promote unity and harmony among the tribes, so he decided to host a grand festival where everyone could come together and celebrate.

To prepare for the festival, the king ordered his advisors to gather supplies and resources from all over the kingdom. Among the resources were bags of stones, each containing a different number of stones.

The king's mathematician, who was in charge of organizing the resources, noticed that some of the bags contained numbers that were not coprime. In other words, there were two adjacent numbers in the bag that shared a common factor other than 1.

The mathematician knew that this could cause problems later on, so he decided to take action. He took the bags with non-coprime numbers and replaced the two adjacent numbers with their LCM. He repeated this process for all bags with non-coprime numbers until there were no more left.

As he worked, the mathematician realized that this process could be generalized. He wanted to create an algorithm to find and replace non-coprime numbers in any array of integers. The algorithm could be used to ensure that all resources gathered for the festival were coprime, promoting unity and harmony among the tribes.

Can you help the mathematician to solve this problem?

Input Format
The first line contains n, size of array. Next line contains n space separated integers.

Constraints
1 <= arr.length <= 105
1 <= arr[i] <= 105

Output Format
Return the modified array as space separated integers.

Sample Input
7
2 2 1 1 3 3 3
Sample Output
2 1 1 3
Explanation
(3, 3) are non-coprime with LCM(3, 3) = 3. Now, nums = [2,2,1,1,3,3].
(3, 3) are non-coprime with LCM(3, 3) = 3. Now, nums = [2,2,1,1,3].
(2, 2) are non-coprime with LCM(2, 2) = 2. Now, nums = [2,1,1,3].

There are no more adjacent non-coprime numbers in nums. Thus, the final modified array is [2,1,1,3].

Note that there are other ways to obtain the same resultant array.
 */


import java.util.*;
public class Kingdom_Festival_and_Non_Coprime_Numbers {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        for(int i:replaceNonCoprimes(a)){
            System.out.print(i+" ");
        }
    }
    public static List<Integer> replaceNonCoprimes(int[] nums) {
        int n=nums.length;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            int a=nums[i];
            while(!s.isEmpty()&&gcd(s.peek(),a)!=1){
                a=lcm(s.pop(),a);
            }
            s.push(a);
        }
        List<Integer> l=new ArrayList<>();
        while(!s.isEmpty()){
            l.add(0,s.pop());
        }
        return l;
    }
    static int gcd(int a,int b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
    static int lcm(int a,int b){
        return a/gcd(a,b)*b;
    }
}