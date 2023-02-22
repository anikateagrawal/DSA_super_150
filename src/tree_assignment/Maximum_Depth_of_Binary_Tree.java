package tree_assignment;
/*
Given a binary tree, find the maximum depth of the tree.

Input Format
Enter the value of the node then the Boolean choice i.e whether the node has a left child , then enter the left child's data . The input acts in a recursive manner i.e when the left child's children are made only then we move onto the parent's right child

Constraints
None

Output Format
Print the depth of the binary tree.

Sample Input
10 true 20 true 73 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
3
Explanation
Calculate the maximum height of the tree.
 */
import java.util.*;
public class Maximum_Depth_of_Binary_Tree {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Maximum_Depth_of_Binary_Tree m = new Maximum_Depth_of_Binary_Tree();
        BinaryTree bt = m.new BinaryTree();
        System.out.println(bt.height());
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
        int height(){
            return height(root);
        }
        int height(Node root){
            if(root==null)return 0;
            int left=height(root.left);
            int right=height(root.right);
            return Math.max(left,right)+1;
        }
    }
}
