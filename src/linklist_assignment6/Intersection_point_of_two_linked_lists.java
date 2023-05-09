package linklist_assignment6;
/*
Given two intersecting linked lists, write a function to find its point of intersection. If the lists do not intersect , return NULL.

Note : You are required to only write a single function. Do not modify / alter the remaining code.

This is a stub problem so you need not worry about taking input or displaying output. Only focus on the designated function.

Input Format
You are given a function which accepts head pointers of two linked lists.

Constraints
Your function should run in linear time.

Output Format
Return the intersection point node.

Sample Input
Consider these linked lists :
1 -> 2 -> 3  -> null
   ↗
4

(This is not the actual input that will be provided but rather a description of it)
Sample Output
The two linked lists 1->2->3->null and 4->2->3-> null intersect at node with data 2.
Return the node with data = 2.
Explanation
The two linked lists intersect at 2. Return their intersection point.
 */
import java.util.HashMap;
import java.util.Scanner;



class Solution1 {
    // This function gets two arguments - the head pointers of the two linked lists
    // Return the node which is the intersection point of these linked lists
    // It is assured that the two lists intersect
    Node intersectionOfTwoLinkedLists(Node l1, Node l2) {
        /* Code here */
        Node a=l1;
        Node b=l2;
        while(a!=b){
            a=a==null?l2:a.next;
            b=b==null?l1:b.next;
        }
        return a;
    }

}

/*
 *
 *
 *   You do not need to refer or modify any code below this.
 *   Only modify the above class definition.
 *	Any modications to code below could lead to a 'Wrong Answer' verdict despite above code being correct.
 *	You do not even need to read or know about the code below.
 *
 *
 *
 */

public class Intersection_point_of_two_linked_lists {

    static Scanner sc = new Scanner(System.in);

    public static Node buildList(HashMap<Integer, Node> hash) {
        int x = sc.nextInt();
        Node head = new Node(x);
        Node current = head;
        hash.put(x, head);
        while (x != -1) {
            x = sc.nextInt();
            if (x == -1)
                break;
            Node n = new Node(x);
            hash.put(x, n);
            current.next = n;
            current = n;
        }
        current.next = null;
        return head;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        HashMap<Integer, Node> hash = new HashMap<Integer, Node>();
        Node l1 = buildList(hash);

        Node l2 = null;
        int x = sc.nextInt();
        l2 = new Node(x);
        Node temp = l2;

        while (x != -1) {
            x = sc.nextInt();
            if (x == -1)
                break;
            if (hash.containsKey(x)) {
                temp.next = hash.get(x);
                break;
            }
            Node n = new Node(x);
            temp.next = n;
            temp = n;
        }

        System.out.print("L1 - ");
        printLinkedList(l1);
        System.out.print("L2 - ");
        printLinkedList(l2);

        Solution1 s = new Solution1();

        Node intersectionPoint = s.intersectionOfTwoLinkedLists(l1, l2);
        System.out.println("Intersection at node with data = " + intersectionPoint.data);

    }
}
