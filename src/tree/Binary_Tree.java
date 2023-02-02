package tree;

import java.util.*;

public class Binary_Tree {
    private class Node{
        int val;
        Node left,right;
    }
    private Node root;
    Scanner sc=new Scanner(System.in);
    public Binary_Tree(){
        root=CreateTree();
    }
    private Node CreateTree(){
        int item=sc.nextInt();
        Node nn=new Node();
        nn.val=item;
        boolean hlc=sc.nextBoolean();
        if(hlc){
            nn.left=CreateTree();
        }
        boolean hrc=sc.nextBoolean();
        if(hrc){
            nn.right=CreateTree();
        }
        return nn;
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
    public void PreOrder(){
        PreOrder(root);
        System.out.println();
    }
    private void PreOrder(Node node){
        if(node==null)return;
        System.out.print(node.val +" ");
        PreOrder(node.left);
        PreOrder(node.right);
    }
    public void PostOrder(){
        PostOrder(root);
        System.out.println();
    }
    private void PostOrder(Node node){
        if(node==null)return;
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.val+" ");

    }
    public void InOrder(){
        InOrder(root);
        System.out.println();
    }
    private void InOrder(Node node){
        if(node==null)return;
        InOrder(node.left);
        System.out.print(node.val+" ");
        InOrder(node.right);
    }
    public boolean search(int val){
        return search(root,val);
    }
    private boolean search(Node node,int val){
        if(node ==null)return false;
        if(node.val==val)return true;
        return search(node.left,val)||search(node.right,val);
    }
    public int maximum(){
        return maximum(root);
    }
    private int maximum(Node node){
        if(node==null)return Integer.MIN_VALUE;
        int l=maximum(node.left);
        int r=maximum(node.right);
        return Math.max(Math.max(l,r),node.val);
    }
    public int height(){
        return height(root,0)-1;
    }
    private int height(Node node,int h){
        if(node==null)return h;
        int l=height(node.left,h+1);
        int r=height(node.right,h+1);
        return Math.max(l,r);
    }
    public boolean isSymmetric(Node root) {
        return hlp(root.left,root.right);
    }
    boolean hlp(Node t1,Node t2){
        if(t1==null&&t2==null)return true;
        if(t1==null||t2==null)return false;
        if(t1.val!=t2.val)return false;
        return hlp(t1.left,t2.right)&& hlp(t1.right,t2.left);
    }

    public List<List<Integer>> level_order(){
        List<List<Integer>> l=new ArrayList<>();
        if(root==null)return l;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Queue<Node> q2=new LinkedList<>();
        List<Integer> ll=new ArrayList<>();
        while(!q.isEmpty()){
            Node n=q.poll();
            ll.add(n.val);
            if(n.left!=null)q2.add(n.left);
            if(n.right!=null)q2.add(n.right);
            if(q.isEmpty()){
                l.add(ll);
                ll=new ArrayList<>();
                q=q2;
                q2=new LinkedList<>();
            }
        }
        return l;
    }
    class pair{
        int ht=-1;
        int d=0;
    }
    public int diameter(){
        return diameter(root).d;
    }
    public pair diameter(Node root){
        pair p=new pair();
        if(root==null)return p;
        pair left=diameter(root.left);
        pair right=diameter(root.right);
        p.ht=Math.max(left.ht,right.ht)+1;
        p.d=Math.max(left.d,Math.max(right.d,left.ht+right.ht+2));
        return p;
    }
}
