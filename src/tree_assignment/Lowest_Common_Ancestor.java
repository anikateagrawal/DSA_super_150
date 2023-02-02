package tree_assignment;
/*
Find LCA(Lowest Common Ancestor) of two elements in a Binary Tree.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL next two line contains 2 element of BT

Constraints
None

Output Format
Display the LCA value.

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
50
60
Sample Output
10
 */
import java.util.*;
public class Lowest_Common_Ancestor {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Lowest_Common_Ancestor m = new Lowest_Common_Ancestor();
        BinaryTree bt = m.new BinaryTree();
        // System.out.println(bt.root.data);
        int a=scn.nextInt(),b=scn.nextInt();
        int d=bt.lca(a,b);
        System.out.println(d);
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        public Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }
        int lca(int a,int b){
            return lca(root,a,b).data;
        }
        Node lca(Node root,int a,int b){
            if(root==null||root.data==a||root.data==b)return root;
            Node l=lca(root.left,a,b);
            Node r=lca(root.right,a,b);
            if(l==null)return r;
            if(r==null)return l;
            return root;
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
                child.right = this.takeInput(child, true);
            }

            // return
            return child;
        }
    }
}