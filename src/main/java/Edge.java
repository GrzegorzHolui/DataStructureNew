public class Edge {
    private int whichEdge;
    private int weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(Vertex startVertex, Vertex targetVertex, int weight) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setWhichEdge(int whichEdge) {
        this.whichEdge = whichEdge;
    }

    public int getWhichEdge() {
        return whichEdge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return whichEdge == edge.whichEdge;
    }

    @Override
    public int hashCode() {
        return whichEdge;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "whichEdge=" + whichEdge +
                '}';
    }
}