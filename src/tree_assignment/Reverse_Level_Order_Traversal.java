package tree_assignment;
/*
Given a binary tree, print it's nodes level by level in reverse order, i.e., print all nodes present at the last level first, followed by nodes of the second last level and so on. Print nodes at any level from left to right.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
The number of nodes in the tree is in the range [1, 1000]
0 <= root->data <= 1000

Output Format
Reverse level order print of the node values.

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
40 50 60 73 20 30 10
Explanation
Last level should be printed first, then second last , then third last and so on.
 */
import java.util.*;
public class Reverse_Level_Order_Traversal {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Reverse_Level_Order_Traversal m = new Reverse_Level_Order_Traversal();
        BinaryTree bt1 = m.new BinaryTree();
        ArrayList<ArrayList<Integer>> l=bt1.levelArrayList();
        for(int i=l.size()-1;i>=0;i--){
            ArrayList<Integer> k=l.get(i);
            for(int j:k)System.out.print(j+" ");
        }
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

            // left
            boolean hlc = scn.nextBoolean();

            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            // right
            boolean hrc = scn.nextBoolean();

            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            // return
            return child;
        }

        public ArrayList<ArrayList<Integer>> levelArrayList() {
            ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();
            if(root==null)return l;
            Queue < Node > queue = new LinkedList <Node > ();
            queue.add(root);
            while (!queue.isEmpty()) {
                ArrayList<Integer> ll=new ArrayList<Integer>();
                Queue < Node > temp = new LinkedList < Node> ();
                while (!queue.isEmpty()) {
                    Node n = queue.remove();
                    ll.add(n.data);
                    if (n.left != null)
                        temp.add(n.left);
                    if (n.right != null)
                        temp.add(n.right);
                }
                queue = temp;
                l.add(ll);
            }
            return l;
            // write your code here
        }

    }
}