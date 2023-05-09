package stack_queue_assignment_5;

import java.util.Scanner;
/*
It's winter season. There is a long queue of students from the four prime courses at Coding Blocks and everyone is here to grab his hoodie. Each student of a course has a different roll number. Whenever a new student will come, he will search for his friend from the end of the queue. Note that a student can only has friend from his course and not from any other course. As soon as he will find any of the friend in the queue, he will stand behind him, otherwise he will stand at the end of the queue. At any moment Kartik Bhaiya will ask the student, who is standing in front of the queue, to come and put his name and grab his hoodie and then remove that student from the queue. There are Q operations of one of the following types:

E x y : A new student of course x whose roll number is y will stand in queue according to the method mentioned above.
D : Kartik Bhaiya will ask the student, who is standing in front of the queue, to come and put his name for the hoodie and remove him from the queue.
Find out the order in which student put their name.

Note: Number of dequeue operations will never be greater than enqueue operations at any point of time.

Input Format
First line contains an integer Q, denoting the number of operations. Next Q lines will contains one of the 2 types of operations.

Constraints
1 ≤ x ≤ 4 1 ≤ y ≤ 50000 1 ≤ Q ≤ 100000

Output Format
For each 2nd type of operation, print two space separated integers, the front student's course and roll number.

Sample Input
5
E 1 1
E 2 1
E 1 2
D
D
Sample Output
1 1
1 2
 */
public class HoodiesAtCodingBlocks {
        static Scanner scn = new Scanner(System.in);
        public static void main(String[] args) throws Exception {
            int n = scn.nextInt();
            hoodies(n);
        }
        public static void hoodies(int q) throws Exception{
            // Write your Code here
            MQueue q1=new MQueue();
            MQueue q2=new MQueue();
            MQueue q3=new MQueue();
            MQueue q4=new MQueue();
            MQueue or=new MQueue();
            boolean qq1=false,qq2=false,qq3=false,qq4=false;
            while(q-->0){
                char c=scn.next().charAt(0);
                if(c=='E'){
                    int co=scn.nextInt();
                    int ro=scn.nextInt();
                    if(co==1){
                        q1.enqueue(ro);
                        if(qq1==false){
                            qq1=true;
                            or.enqueue(1);
                        }
                    }
                    if(co==2){
                        q2.enqueue(ro);
                        if(qq2==false){
                            qq2=true;
                            or.enqueue(2);
                        }
                    }
                    if(co==3){
                        q3.enqueue(ro);
                        if(qq3==false){
                            qq3=true;
                            or.enqueue(3);
                        }
                    }
                    if(co==4){
                        q4.enqueue(ro);
                        if(qq4==false){
                            qq4=true;
                            or.enqueue(4);
                        }
                    }
                }
                else{
                    int g=or.getFront();
                    if(g==1){
                        int r=q1.dequeue();
                        System.out.println(g+" "+r);
                        if(q1.isEmpty()){
                            qq1=false;
                            or.dequeue();
                        }
                    }
                    if(g==2){
                        int r=q2.dequeue();
                        System.out.println(g+" "+r);
                        if(q2.isEmpty()){
                            qq2=false;
                            or.dequeue();
                        }
                    }
                    if(g==3){
                        int r=q3.dequeue();
                        System.out.println(g+" "+r);
                        if(q3.isEmpty()){
                            qq3=false;
                            or.dequeue();
                        }
                    }
                    if(g==4){
                        int r=q4.dequeue();
                        System.out.println(g+" "+r);
                        if(q4.isEmpty()){
                            qq4=false;
                            or.dequeue();
                        }
                    }
                }
            }
        }
}
class MQueue {

    protected int size;

    protected int front;
    protected int[] data;

    public MQueue() {
        this.size = 0;
        this.front = 0;
        this.data = new int[5];
    }

    public MQueue(int cap) {
        this.size = 0;
        this.front = 0;
        this.data = new int[cap];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void enqueue(int item) throws Exception {
        if (this.size() == this.data.length) {
            int[] oa = this.data;
            int[] na = new int[oa.length * 2];
            for (int i = 0; i < this.size(); i++) {
                int idx = (i + front) % oa.length;
                na[i] = oa[idx];
            }

            this.data = na;
            this.front = 0;
        }

        // if (this.size == this.data.length) {
        // throw new Exception("queue is full");
        // }

        this.data[(front + size) % this.data.length] = item;
        size++;

    }

    public int dequeue() throws Exception {
        if (this.size == 0) {
            throw new Exception("queue is empty");

        }

        int rv = this.data[front];
        front = (front + 1) % this.data.length;
        size--;

        return rv;

    }

    public int getFront() throws Exception {
        if (this.size == 0) {
            throw new Exception("queue is empty");
        }

        int rv = this.data[front];

        return rv;
    }

    public void display() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            int idx = (i + front) % this.data.length;
            System.out.print(this.data[idx] + " ");
        }
        System.out.print("END");
    }
}
