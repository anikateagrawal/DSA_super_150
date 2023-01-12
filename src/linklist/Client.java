package linklist;

public class Client {
    public static void main(String[] args) {
        LinkedList ob=new LinkedList();
        ob.add(50);
        ob.addFirst(40);
        ob.add(60);
        ob.addAt(1,100);
        ob.addAt(3,10);
//        ob.display();
//        System.out.println(ob.get(2));
//        ob.remove(1);
//        ob.display();
//        ob.remove(0);
//        ob.display();
//        ob.remove(2);
        ob.display();
        ob.reverse();
        ob.display();
        ob.rcycle();
        ob.rcycle2();
    }
}
