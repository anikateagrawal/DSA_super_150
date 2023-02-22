package heap;

import inheritance.C;

public class Cars implements Comparable<Cars> {
    int price;
    int speed;
    String color;
    public Cars() {

    }

    public Cars(int price, int speed, String color) {
        this.price = price;
        this.speed = speed;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "price=" + price +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Cars c1=new Cars(10,30,"red");
        Cars c2=new Cars(20,50,"black");
        Cars c3=new Cars(40,20,"blue");
        Cars c4=new Cars(5,70,"green");
        Generic_Heap<Cars> h=new Generic_Heap<>();
        h.add(c1);
        h.add(c2);
        h.add(c3);
        h.add(c4);
        h.display();
        System.out.println(h.remove());
        h.display();
    }
    @Override
    public int compareTo(Cars o) {
        return o.speed-this.speed;
    }
}
