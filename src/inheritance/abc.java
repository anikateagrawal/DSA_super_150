package inheritance;

public class abc {
    public static void main(String[] args) throws Exception{
        base obj=new base();
        System.out.println(obj.fun());

        try{

        }
        catch (Exception e){

        }

        fun(10);
    }
//    static void fun(int a){
//        System.out.println("int");
//    }
//    static void fun(long a){
//        System.out.println("long");
//    }

    static void fun(Integer a){
        System.out.println("Integer");
    }
    static void fun(Number a){
        System.out.println("Number");
    }
}
