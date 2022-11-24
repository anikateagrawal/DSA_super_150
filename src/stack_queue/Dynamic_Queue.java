package stack_queue;

public class Dynamic_Queue extends queue {
    @Override
    public void Enqueue(int v)throws Exception{
        if(isfull()){
            int a[]=new int[2*arr.length];
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % arr.length;
                a[i] = arr[idx];
            }
            arr=a;
        }

        super.Enqueue(v);
    }
    public static void main(String[] args) throws Exception{
        Dynamic_Queue q=new Dynamic_Queue();
        q.Enqueue(50);
        q.Enqueue(10);
        q.Display();
    }
}
