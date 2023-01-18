package tree;

/*
10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false
 */
public class BinaryTree_Client {
    public static void main(String[] args) {
        Binary_Tree bt=new Binary_Tree();
        bt.display();
        bt.PreOrder();
        bt.PostOrder();
        bt.InOrder();
        System.out.println(bt.search(-50));
        System.out.println(bt.maximum());
        System.out.println(bt.height());
        System.out.println(bt.level_order());
    }
}
