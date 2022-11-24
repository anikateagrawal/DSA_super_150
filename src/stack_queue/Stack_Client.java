package stack_queue;

public class Stack_Client {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        stack s = new stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.display();
        //s.push(60);
        System.out.println(s.peek());

    }

}
