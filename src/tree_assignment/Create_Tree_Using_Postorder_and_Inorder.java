package tree_assignment;
/*
Given postorder and inorder traversal of a tree. Create the original tree on given information.

Input Format
Enter the size of the postorder array N then add N more elements and store in the array, then enter the size of the inorder array M and add M more elements and store in the array. here M and N are same.

Constraints
None

Output Format
Display the tree using the display function

Sample Input
3
1
3
2
3
1
2
3
Sample Output
1 => 2 <= 3
END => 1 <= END
END => 3 <= END
 */

import java.util.*;
public class Create_Tree_Using_Postorder_and_Inorder {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Create_Tree_Using_Postorder_and_Inorder m = new Create_Tree_Using_Postorder_and_Inorder();
        int[] post = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(post, in);
        bt.display();
    }

    public static int[] takeInput() {
        int n = scn.nextInt();

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] post, int[] in) {
            this.root = this.construct(post, in, 0, in.length - 1);
        }
        int p=-1;
        private Node construct(int[] post, int[] in, int ilo, int ihi) {
            if(ilo>ihi)return null;
            if(p==-1)p=post.length-1;
            Node n=new Node();
            n.data=post[p--];
            if(ilo==ihi)return n;
            int i=search(in,ilo,ihi,n.data);
            n.right=construct(post,in,i+1,ihi);
            n.left=construct(post,in,ilo,i-1);
            return n;
        }
        int search(int a[],int s,int e,int v){
            for(int i=s;i<=e;i++){
                if(a[i]==v)return i;
            }
            return -1;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";

            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);

            this.display(node.left);
            this.display(node.right);
        }

    }

}
