package tree_assignment;
/*
Given a Binary Tree, write a program that returns the size of the largest subtree which is also a Binary Search Tree (BST)

Input Format
The first line of input will contain an integer n. The next line will contain n integers denoting the the preorder traversal of the BT. The next line will contain n more integers denoting the inorder traversal of the BT.

Constraints
2 ≤ N ≤ 10^3

Output Format
A single integer denoting the size ( no of nodes in tree ) of largest BST in the given tree.

Sample Input
4
60 65 50 70
50 65 60 70
Sample Output
2
Explanation
The tree looks like

             60
          /      \
       65           70
     /
   50
The largest BST subtree is

       65
     /
   50
which has the size 2 i.e. it has 2 nodes in it.
 */
import java.util.Scanner;

class Largest_BST_in_a_Binary_Tree {
    static class BinaryTree {

        private class Node {
            int data;
            Node left;
            Node right;

            Node(int data, Node left, Node right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }

        private Node root;
        private int size;

        public int size() {
            return this.size;
        }

        public boolean isempty() {
            return this.size == 0;
        }

        public BinaryTree() {
            Scanner scn = new Scanner(System.in);
            this.root = this.takeinput(scn, null, false);
        }

        private Node takeinput(Scanner scn, Node parent, boolean leftorright) {
            if (parent == null) {
                System.out.println("Enter the data for root");
            } else {
                if (leftorright) {
                    System.out.println("Enter the data for left child of" + parent.data);
                } else {
                    System.out.println("Enter the data for right child of" + parent.data);
                }
            }
            int cdata = scn.nextInt();
            Node child = new Node(cdata, null, null);
            this.size++;
            boolean choice = false;
            System.out.println("Do you want have left child for" + child.data);
            choice = scn.nextBoolean();
            if (choice) {
                child.left = this.takeinput(scn, child, true);
            }
            System.out.println("Do you have a right child");
            choice = scn.nextBoolean();
            if (choice) {
                child.right = this.takeinput(scn, child, false);
            }
            return child;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node.left != null) {
                System.out.print(node.left.data + " =>");
            } else {
                System.out.print("END =>");
            }
            System.out.print(node.data + "<= ");
            if (node.right != null) {
                System.out.print(node.right.data);
            } else {
                System.out.print("END");
            }
            System.out.println();
            if (node.left != null) {
                this.display(node.left);
            }
            if (node.right != null) {
                this.display(node.right);
            }
        }

        /////////////////// New Constructor//////////

        public BinaryTree(int[] pre, int[] in) {
            // this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length -
            // 1);//for preorder
            this.root = this.construct(pre, in, 0, in.length - 1);// for
            // postorder

        }

        private static int preIndex = 0;

        private Node construct(int[] pre, int[] in, int isi, int iei) {
            if (isi > iei) {
                return null;
            }
            Node tNode = new Node(pre[preIndex++], null, null);

            if (isi == iei) {
                return tNode;
            }

            int inIndex = search(in, isi, iei, tNode.data);
            tNode.left = construct(pre, in, isi, inIndex - 1);
            tNode.right = construct(pre, in, inIndex + 1, iei);
            return tNode;

        }

        private int search(int[] arr, int si, int ei, int data) {
            for (int i = si; i <= ei; i++) {
                if (arr[i] == data)
                    return i;
            }
            return -1;
        }

        class Info {
            int size;
            int max;
            int min;
            int ans;
            boolean isBST;

            Info() {
                size=0;
                max=Integer.MIN_VALUE;
                min=Integer.MAX_VALUE;
                ans=0;
                isBST=true;
            }

            Info(int s, int max, int min, int ans, boolean isBST) {
                this.size = s;
                this.max = max;
                this.min = min;
                this.ans = ans;
                this.isBST = isBST;
            }
        }

        public int largestBSTinBT() {
            return this.largestBSTinBT(this.root).ans;
        }

        //Complete this
        private Info largestBSTinBT(Node root) {
            if(root==null)return new Info();
            Info l=largestBSTinBT(root.left);
            Info r=largestBSTinBT(root.right);
            Info n=new Info();
            if(!l.isBST||!r.isBST || root.data<l.max || root.data>r.min){
                n.isBST=false;
            }
            n.size=l.size+r.size+1;
            if(n.isBST)n.ans=n.size;
            else n.ans=Math.max(l.ans,r.ans);
            n.min=Math.min(l.min,Math.min(root.data,r.min));
            n.max=Math.max(l.max,Math.max(root.data,r.max));
            return n;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] pre = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            in[i] = scn.nextInt();
        }

        BinaryTree bt = new BinaryTree(pre, in);
//		bt.display();
        System.out.println(bt.largestBSTinBT());
    }
}

