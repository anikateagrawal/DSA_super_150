package stack_queue;

public class queue {
    protected int[] arr;
    protected int front = 0;
    protected int size = 0;

    public queue() {
        // TODO Auto-generated constructor stub
        arr = new int[5];
    }

    public queue(int n) {
        // TODO Auto-generated constructor stub
        arr = new int[n];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isfull() {
        return size == arr.length;
    }

    public void Enqueue(int item) throws Exception {
        if (isfull()) {
            throw new Exception("Bklol queue full h");
        }
        int idx = (front + size) % arr.length;
        arr[idx] = item;
        size++;
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue khali hai");
        }
        int rv = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return rv;
    }

    public int GetFront() {
        int rv = arr[front];

        return rv;
    }

    public void Display() {
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % arr.length;
            System.out.print(arr[idx] + " ");

        }

    }
}
