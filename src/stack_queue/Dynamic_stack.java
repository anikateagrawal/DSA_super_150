package stack_queue;

public class Dynamic_stack extends stack {
    public void push(int v)throws Exception{
        if(isfull()){
            int a[]=new int[2*arr.length];
            for (int i = 0; i < arr.length; i++) {
                a[i]=arr[i];
            }
            arr=a;
        }
        super.push(v);
    }

    public static void main(String[] args) throws Exception {
        Dynamic_stack s=new Dynamic_stack();

        s.push(50);
        s.push(70);
        s.display();
    }
}
