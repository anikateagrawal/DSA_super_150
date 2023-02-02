package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Create_level_order {
    class Node{
        int val;
        Node left,right;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;
    Scanner sc=new Scanner(System.in);

    public Create_level_order() {
        createTree();
    }
    private void createTree(){
        Queue<Node> q=new LinkedList<>();
        int val=sc.nextInt();
        if(val==-1)return;
        root=new Node(val);
        q.add(root);
        while (!q.isEmpty()){
            Node n=q.poll();
            int v=sc.nextInt();
            if(v!=-1){
                n.left=new Node(v);
                q.add(n.left);
            }
            v=sc.nextInt();
            if(v!=-1){
                n.right=new Node(v);
                q.add(n.right);
            }
        }
    }
    public void display(){
        display(root);
    }
    private void  display(Node node){
        if(node==null)return;
        String s="";
        s="<-"+s+node.val+"->";
        if(node.left!=null)s=node.left.val+s;
        else s="."+s;
        if(node.right!=null)s+=node.right.val;
        else s+=".";
        System.out.println(s);
        display(node.left);
        display(node.right);
    }
}
