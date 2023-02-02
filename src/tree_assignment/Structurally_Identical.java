package tree_assignment;
/*
Given two trees check if they are structurally identically. Structurally identical trees are trees that have same structure. They may or may not have the same data though.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
1 <= N <= 10^4

Output Format
Display the Boolean result

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
true
Explanation
The given two trees have the exact same structure and hence we print true.
 */
import java.util.*;
public class Structurally_Identical {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Structurally_Identical m = new Structurally_Identical();
        BinaryTree bt1 = m.new BinaryTree();
        BinaryTree bt2 = m.new BinaryTree();
        System.out.println(bt1.structurallyIdentical(bt2));
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {
            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;
            boolean hlc = scn.nextBoolean();
            if (hlc) {
                child.left = this.takeInput(child, true);
            }
            boolean hrc = scn.nextBoolean();
            if (hrc) {
                child.right = this.takeInput(child, false);
            }
            return child;
        }

        public boolean structurallyIdentical(BinaryTree other) {
            return this.hlp(this.root, other.root);
        }

        private boolean hlp(Node t1, Node t2) {
            if(t1==null&&t2==null)return true;
            if(t1==null||t2==null)return false;
            return hlp(t1.left,t2.left)&& hlp(t1.right,t2.right);
        }

    }
}

