import java.util.*;

public class EdgeListGraph {
    private List<Edge> edges;

    public EdgeListGraph() {
        edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

}
