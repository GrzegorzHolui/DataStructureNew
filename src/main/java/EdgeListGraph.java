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

    public Set<Vertex> getVertices() {
        Set<Vertex> vertices = new HashSet<>();

        for (Edge edge : edges) {
            vertices.add(edge.getStartVertex());
            vertices.add(edge.getTargetVertex());
        }

        return vertices;
    }
}
