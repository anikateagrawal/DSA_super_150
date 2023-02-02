package tree;

public class BST {
    private class Node{
        int val;
        Node left,right;
    }
    private Node root;
    public BST(int in[]){
        root=createTree(in,0,in.length-1);
    }
    private Node createTree(int in[],int ilo,int ihi){
        if(ilo>ihi)return null;
        int mid=(ilo+ihi)/2;
        Node nn=new Node();
        nn.val=in[mid];
        nn.left=createTree(in,ilo,mid-1);
        nn.right=createTree(in,mid+1,ihi);
        return nn;
    }
    public void display(){
        display(root);
    }
    private void display(Node root){
        if(root==null)return;
        display(root.left);
        System.out.println(root.val);
        display(root.right);
    }

    public static void main(String[] args) {
        int a[]={10, 20 ,30 ,40 ,50, 60, 70,80,90};
        BST t=new BST(a);
        t.display();
    }
}
