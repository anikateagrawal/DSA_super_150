package inheritance;

public class Client {
    public static void main(String[]args) {
        //cas1
        P obj=new P();
        System.out.println(obj.d);
        System.out.println(obj.d1);
        obj.fun();
        obj.fun1();
        System.out.println();
        //case2
        P obj2=new C();
        System.out.println(obj2.d);
        System.out.println(obj2.d1);
        System.out.println(((C)(obj2)).d2);
        System.out.println(((C)(obj2)).d);
        obj2.fun();
        obj2.fun1();
        ((C)(obj2)).fun2();

        //case3 not possible
//        C obj1=new P();
//        System.out.println(obj1.d);
//        System.out.println(obj1.d1);
//        System.out.println(obj.d2);
        System.out.println();
        //case4
        C obj1=new C();
        System.out.println(obj1.d);
        System.out.println(obj1.d1);
        System.out.println(obj1.d2);
        System.out.println(((P)(obj1)).d);
        obj1.fun();
        obj1.fun1();
        obj1.fun2();
    }

}
