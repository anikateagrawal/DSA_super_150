package linklist_assignment6;
/*
Given a singly linked list delete all nodes which are having a greater value among any of the nodes residing on the right side.

Input Format
First line contains N, the number of nodes in the linked list.
Next line contains the N nodes data .

Constraints
0<N<10^9

Output Format
Print the linked list after deleting the nodes which are having a greater value on right side.

Sample Input
8
12 15 10 11 5 6 2 3
Sample Output
15 11 6 3
Explanation
In the given case 12 is having right node greater than itself i.e. 12<15 so delete it.
Similarly, 10<11, 5<6 and 2<3 so delete 10, 5 and 2 as well.
Thus, linked list becomes 15->11->6->3.
 */
import java.util.Scanner;

public class delete_node {
    static class LinkedList {
        // Complete the function below
        public void deleteLarger() throws Exception {
            for(int i=0;i<size;i++){
                int d=getAt(i);
                for(int j=i+1;j<size;j++){
                    if(d<getAt(j)){
                        removeAt(i);
                        i--;
                        break;
                    }
                }
            }
        }


        //  You dont need to read the code below.

        private class Node {
            int data;
            Node next;

            Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public LinkedList(Node head, Node tail, int size) {
            this.head = head;
            this.tail = tail;
            this.size = size;
        }

        // O(1)
        public int size() {
            return this.size;
        }

        // O(1)
        public boolean isEmpty() {
            return this.size() == 0;
        }

        // O(1)
        public int getFirst() throws Exception {
            if (this.isEmpty()) {
                throw new Exception("List is empty.");
            }

            return this.head.data;
        }

        // O(1)
        public int getLast() throws Exception {
            if (this.isEmpty()) {
                throw new Exception("List is empty.");
            }

            return this.tail.data;
        }

        // O(N)
        public int getAt(int idx) throws Exception {
            Node temp = this.getNodeAt(idx);
            return temp.data;
        }

        // O(N)
        private Node getNodeAt(int idx) throws Exception {
            if (this.isEmpty()) {
                throw new Exception("List is empty");
            }

            if (idx < 0 || idx >= this.size()) {
                throw new Exception("Invalid arguments");
            }

            Node retVal = this.head;
            for (int i = 0; i < idx; i++) {
                retVal = retVal.next;
            }

            return retVal;
        }

        // O(1)
        public void addFirst(int data) {
            Node node = new Node(data, this.head);

            if (this.size() == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.head = node;
            }

            this.size++;
        }

        // O(1)
        public void addLast(int data) {
            Node node = new Node(data, null);

            if (this.size() == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                this.tail = node;
            }

            this.size++;
        }

        // O(n)
        public void addAt(int idx, int data) throws Exception {
            if (idx < 0 || idx > this.size()) {
                throw new Exception("Invalid arguments");
            }

            if (idx == 0) {
                this.addFirst(data);
            } else if (idx == this.size()) {
                this.addLast(data);
            } else {
                Node nm1 = this.getNodeAt(idx - 1);
                Node n = nm1.next;

                Node node = new Node(data, n);
                nm1.next = node;

                this.size++;
            }
        }

        // O(1)
        public int removeFirst() throws Exception {
            if (this.isEmpty()) {
                throw new Exception("List is empty");
            }

            int retVal = this.head.data;

            if (this.size() == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
            }

            this.size--;
            return retVal;
        }

        // O(n)
        public int removeLast() throws Exception {
            if (this.isEmpty()) {
                throw new Exception("List is empty");
            }

            int retVal = this.tail.data;

            if (this.size() == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node sm2 = this.getNodeAt(this.size() - 2);
                sm2.next = null;
                this.tail = sm2;
            }

            this.size--;
            return retVal;
        }

        // O(n)
        public int removeAt(int idx) throws Exception {
            if (this.isEmpty()) {
                throw new Exception("List is empty");
            }

            if (idx < 0 || idx >= this.size()) {
                throw new Exception("Invalid arguments");
            }

            if (idx == 0) {
                return this.removeFirst();
            } else if (idx == this.size() - 1) {
                return this.removeLast();
            } else {
                Node nm1 = this.getNodeAt(idx - 1);
                Node n = nm1.next;
                Node np1 = n.next;

                nm1.next = np1;
                this.size--;

                return n.data;
            }
        }

        // O(n)
        public void display() {
            Node node = this.head;

            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }

            // System.out.println("END");
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        LinkedList list = new LinkedList();

        for (int i = 0; i < N; i++) {
            list.addLast(scn.nextInt());
        }

        list.deleteLarger();
        list.display();
    }
}
