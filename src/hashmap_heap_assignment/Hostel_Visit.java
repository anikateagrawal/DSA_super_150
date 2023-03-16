package hashmap_heap_assignment;

/*
Dean of MAIT is going to visit Hostels of MAIT. As you know that he is a very busy person so he decided to visit only first "K" nearest Hostels. Hostels are situated in 2D plane. You are given the coordinates of hostels and you have to answer the Rocket distance of Kth nearest hostel from origin ( Dean's place ) .

Input Format
First line of input contains Q Total no. of queries and K There are two types of queries:

first type : 1 x y For query of 1st type, you came to know about the co-ordinates ( x , y ) of newly constructed hostel. second type : 2 For query of 2nd type, you have to output the Rocket distance of Kth nearest hostel till now.

The Dean will always stay at his place ( origin ). It is gauranted that there will be atleast k queries of type 1 before first query of type 2.

Rocket distance between two points ( x2 , y2 ) and ( x1 , y1 ) is defined as (x2 - x1)2 + (y2 - y1)2

Constraints
1 < = k < = Q < = 10^5
-10^6 < = x , y < = 10^6
Output Format
For each query of type 2 output the Rocket distance of Kth nearest hostel from Origin.

Sample Input
9 3
1 10 10
1 9 9
1 -8 -8
2
1 7 7
2
1 6 6
1 5 5
2
Sample Output
200
162
98
Explanation
Here , No of queries = n = 9
k = 3

We have to print the kth distance from the hotel.

We are calculating and storing the rocket distance here i.e. (x2-x1)^2 + (y2-y1)^2 … basically the cartesian distance but without the squareroot.

First integer of each input defines the query type. 1 means take the coordinates input and 2 means display the kth distance so far.

Iteration 1 :
First we get 1 10 10
Distance = 10^2 + 10^2 = 200
We store it in our data structure. Lets call it A.
A = { 200 }

Iteration 2 :
1 9 9
Distance = 9^2 + 9^2 = 162
A = { 162 , 200 }

Iteration 3 :
1 -8 -8
Distance = (-8)^2 + (-8)^2 = 168
A = { 128, 162 , 200 }

Iteration 4 :
2
A = { 128, 162 , 200 }
Time to print the 3rd nearest distance ( k=3 )
Output : 200


Iteration 5 :
1 7 7
Distance = 7^2 + 7^2 = 98
A = { 98, 128, 162 , 200 }

Iteration 6 :
2
A = { 98, 128, 162 , 200 }
Time to print the 3rd nearest distance ( k=3 )
Output : 162

Iteration 7 :
1 6 6
Distance = 6^2 + 6^2 = 72
A = { 72, 98, 128, 162 , 200 }

Iteration 8 :
1 5 5
Distance = 5^2 + 5^2 = 50
A = { 50, 72, 98, 128, 162 , 200 }

Iteration 9 :
2
A = { 50, 72, 98, 128, 162 , 200 }
Time to print the 3rd nearest distance ( k=3 )
Output : 98
 */
import java.util.*;
public class Hostel_Visit {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Long> l=new PriorityQueue<Long>((e,f)->Long.compare(f,e));
        int q=sc.nextInt();
        int k=sc.nextInt();
        while(q-->0){
            int t=sc.nextInt();
            if(t==1){
                long x=sc.nextInt();
                long y=sc.nextInt();
                long d=x*x+y*y;
                if(l.size()<k){
                    l.add(d);
                }
                else{
                    if(d<l.peek()){
                        l.poll();
                        l.add(d);
                    }
                }
            }
            else {
                System.out.println(l.peek());
            }
        }
    }
}
