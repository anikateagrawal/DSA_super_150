package linklist_assignment6;
/*
Given the head pointer to a linked list , complete the function to check whether there is a cycle present in the linked list. If so , modify the linked list to remove the cycle.

Note : You are only supposed to update the designated function. Do not change/alter the remaining code or your program may not work.

Input Format
Your function accepts one single argument that is the head pointer to the linked list.

Constraints
Your function should run in O(n) time.

Output Format
Your function should return a boolean value - True/False , indicating the presence of the cycle.
True if cycle is present, False otherwise.
If true , remove the cycle as well.

Sample Input
Consider a linked list like
1 -> 2 -> 3
     ^    |
     |    v
     5<-  4
Sample Output
Your function should return True for the above linked list and remove the cycle as well. <br>
The new linked list should look like - 1->2->3->4->5-> NULL
Explanation
Clearly there is a cycle present. We return true to indicate it and remove it.
 */
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

class Node {
    public int data;
    public Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // head - Head pointer of the Linked List
    // Return a boolean value indicating the presence of cycle
    // If the cycle is present, modify the linked list to remove the cycle as well
    boolean floydCycleRemoval(Node head) {
        /*Code here*/
        Node slow=head;
        Node fast=head;
        Node meet=null;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                meet=slow;
                break;
            }
        }
        if(meet==null)return false;
        slow=head;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
        return true;
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

public class Cycle_Detection_and_Removal_in_Linked_List {

    public static Node buildCycleList() {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, Node> hash = new Hashtable<Integer, Node>();
        int x = sc.nextInt();
        if (x == -1) {
            return null;
        }
        Node head = new Node(x);
        hash.put(x, head);
        Node current = head;
        while (x != -1) {
            x = sc.nextInt();
            if (x == -1)
                break;
            if (hash.containsKey(x)) {
                current.next = hash.get(x);
                return head;
            }
            Node n = new Node(x);
            current.next = n;
            current = n;
            hash.put(x, n);
        }
        current.next = null;
        return head;
    }

    public static void printLinkedList(Node head) {
        HashSet<Integer> s = new HashSet<Integer>();
        while (head != null) {
            if (s.contains(head.data)) {
                System.out.println("\nCycle detected at " + head.data);
                return;
            }
            System.out.print(head.data + " ");
            s.add(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node head = buildCycleList();
        Solution s = new Solution();

        boolean cyclePresent = s.floydCycleRemoval(head);
        if (cyclePresent) {
            System.out.println("Cycle was present");
        } else {
            System.out.println("No cycle");
        }

        System.out.print("Linked List - ");
        printLinkedList(head);
    }
}