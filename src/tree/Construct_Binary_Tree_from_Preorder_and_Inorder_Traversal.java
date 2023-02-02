package tree;

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return CreateTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }
    public TreeNode CreateTree(int in[],int ilo,int ihi,int pre[],int plo,int phi){
        if(ilo>ihi)return null;
        TreeNode nn=new TreeNode(pre[plo]);
        int p=search(in,ilo,ihi,pre[plo]);
        int d=p-ilo;
        nn.left=CreateTree(in,ilo,p-1,pre,plo+1,plo+d);
        nn.right=CreateTree(in,p+1,ihi,pre,plo+d+1,phi);
        return nn;
    }
    public int search(int in[],int s,int e,int v){
        for (int i = s; i <= e; i++) {
            if(in[i]==v)return i;
        }
        return -1;
    }
}
