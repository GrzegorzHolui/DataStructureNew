import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> edges;
    private boolean visited;
    private Vertex previosVertex;
    private int minDistance = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Vertex getPreviosVertex() {
        return previosVertex;
    }

    public void setPreviosVertex(Vertex previosVertex) {
        this.previosVertex = previosVertex;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Integer.compare(this.minDistance, otherVertex.minDistance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}