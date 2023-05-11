import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphNeighborhoodList {
    private Map<Vertex, List<Edge>> vertices;

    public GraphNeighborhoodList() {
        this.vertices = new LinkedHashMap<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        List<Edge> sourceNeighbors = vertices.get(source);
        sourceNeighbors.add(new Edge(source, destination, weight));
    }

    public void addEdge(Edge edge) {
        List<Edge> sourceNeighbors = vertices.get(edge.getStartVertex());
        sourceNeighbors.add(edge);
    }

    public List<Edge> getNeighbors(Vertex vertex) {
        return vertices.get(vertex);
    }

    public Set<Vertex> getVertices() {
        return vertices.keySet();
    }

    @Override
    public String toString() {
        return "GraphNeighborhoodList{" +
                "vertices=" + vertices +
                '}';
    }
}

