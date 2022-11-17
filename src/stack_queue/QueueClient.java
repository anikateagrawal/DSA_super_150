package stack_queue;

import stack_queue.Queue;

public class QueueClient {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Queue q = new Queue();
        q.Enqueue(10);
        q.Enqueue(20);
        q.Enqueue(30);
        q.Enqueue(40);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.Enqueue(50);
        q.Enqueue(60);
        q.Display();

    }

}
