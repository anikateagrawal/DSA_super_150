package hashmap;

public class Client_HashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("Anikate",90);
        map.put("abc",100);
        map.put("efg",10);
        System.out.println(map);
        map.put("abc",40);
        System.out.println(map);
        System.out.println(map.get("Anikate"));
        System.out.println(map.get("AAA"));
        System.out.println(map.containsKey("Anikate"));
        System.out.println(map.containsKey("AAA"));
        map.remove("efg");
        System.out.println(map);
        map.remove("AAA");
        System.out.println(map);

    }
}
