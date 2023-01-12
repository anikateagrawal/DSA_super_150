package linklist;

public class LinkedList {
    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head,tail;
    private  int size;
    public void addFirst(int val){
        Node n=new Node(val);
        size++;
        if(tail==null)tail=n;
        n.next=head;
        head=n;
    }
    public void add(int val){
        Node n=new Node(val);
        size++;
        if(head==null){
            head=tail=n;
            return;
        }
        tail.next=n;
        tail=n;
    }
    public void addAt(int i,int val){
        if(i>size||i<0){
            System.out.println("invalid index");
            return;
        }
        if(i==0){
            addFirst((val));return;
        }
        if(i==size){
            add(val);return;
        }
        Node t=getNode(i-1);
        Node n=new Node(val);
//        while(--i>0){
//            t=t.next;
//        }
        n.next=t.next;
        t.next=n;
        size++;
    }
    public int get(int i){
        return getNode(i).val;
    }
    public int remove(int i){
        if(i<0||i>=size){
            System.out.println("Invalid Index");
            return -1;
        }
        if(size==1){
            int v=head.val;
            head=tail=null;
            size--;
            return v;
        }
        if(i==0){
            int v=head.val;
            size--;
            head=head.next;return v;
        }
        Node t=getNode(i-1);
        int v=t.next.val;
        t.next=t.next.next;
        if(i==size-1)tail=t;
        size--;
        return v;
    }
    private Node getNode(int i){
        if(i<0||i>=size){
            System.out.println("invalid");return null;
        }
        if(i==size-1)return tail;
        Node t=head;
        while(i-->0){
            t=t.next;
        }
        return t;
    }
    public void display(){
        Node tmp=head;
        if(head==null){
            System.out.println("Empty");
            return;
        }
        while(tmp!=null){
            System.out.print((tmp.val+"-->"));
            tmp=tmp.next;
        }
        System.out.println("Null");
    }
    void reverse(){
        c=0;
        h=head;
        rev(head,0);
    }
    int c;
    Node h;
    void rev(Node tmp,int i){
        if(tmp==null)return;
        rev(tmp.next,i+1);
        if(c<i){
            int t=tmp.val;
            tmp.val=h.val;
            h.val=t;
            h=h.next;
            c++;
        }
    }

    Node cycle(){
        tail.next=getNode(1);
//        display();
        Node fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return fast;
            }
        }
        return null;
    }
    void rcycle(){
        Node meet=cycle();
        if(meet==null)return;
        Node t=meet;
        int c=1;
        while(t.next!=meet){
            c++;
            t=t.next;
        }
        Node fast=head;
        for(int i=1;i<=c;i++){
            fast=fast.next;
        }
        Node slow=head;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
        display();
    }
    void rcycle2(){
        Node fast=cycle();
        if(fast==null)return;
        Node slow=head;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
        display();
    }

}
