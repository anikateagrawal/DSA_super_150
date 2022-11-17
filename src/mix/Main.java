package mix;

/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
 C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
public class Main
{
    private ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        Main sll=new Main();
        sll.insertFirst(11);
        sll.insertFirst(8);
        sll.insertFirst(1);
        sll.insertFirst(10);
        sll.display();
        System.out.println("Length is- "+sll.length());

    }
    public void display(){
        ListNode current=this.head;
        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("null");
    }
    public int length(){
        int count=0;
        ListNode current=this.head;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }
    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        newNode.next=head;
        head=newNode;
    }
}
