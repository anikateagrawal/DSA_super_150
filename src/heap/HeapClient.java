package heap;

public class HeapClient {
    public static void main(String[] args) {
        MinHeap h=new MinHeap();
        h.add(10);
        h.add((20));
        h.add(30);
        h.add(5);
        h.add(7);
        h.add(3);
        h.add(2);
        h.add(-10);
        h.add(-20);
        System.out.println(h.min());
        h.display();
        System.out.println(h.remove());
        h.display();
    }
}
