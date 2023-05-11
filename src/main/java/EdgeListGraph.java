import java.util.*;

public class EdgeListGraph {
    private List<Edge> edges;

    public EdgeListGraph() {
//       this.edges = new MyLinkedList<>();
       this.edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
//        List<Edge> result = new ArrayList<>();
//        for (int i = 0; i < edges.size(); i++) {
//            Edge data = edges.get(i).getData();
//            result.add(data);
//        }
//        return new ArrayList<>(result);
        return edges;
    }

}
