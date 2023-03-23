package graph;

public class Dijkstra_Client {
    public static void main(String[] args) {
        Dijkstra g=new Dijkstra(7);
        g.addEdge(1,4,6);
        g.addEdge(1,2,10);
        g.addEdge(2,3,7);
        g.addEdge(3,4,5);
        g.addEdge(4,5,1);
        g.addEdge(5,6,4);
        g.addEdge(7,5,2);
        g.addEdge(6,7,3);
        g.cost();
    }
}
