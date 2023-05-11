import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class IncidenceMatrix {
    private int[][] matrix;
    private List<Vertex> vertices;
    private List<Edge> edges;

    public IncidenceMatrix(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.matrix = new int[vertices.size()][edges.size()];
        buildMatrix();
    }

    public List<Edge> getListOfEdges(Vertex sourceVertex) {
        Set<Edge> result = new LinkedHashSet<>();
//        int position = sourceVertex.getName().charAt(0) - 'A';
        int position = Integer.parseInt(sourceVertex.getName());
        for (int i = 0; i < matrix[position].length; i++) {
            int isEdge = matrix[position][i];
            if (isEdge > 0) {
                int finalI = i;
                List<Edge> listOfEdges = edges.stream().filter(edge -> edge.getWhichEdge() == finalI).toList();
                result.addAll(listOfEdges);
            }
        }
        return new ArrayList<>(result);
    }

    private void buildMatrix() {
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                if (edge.getStartVertex().equals(vertices.get(i))) {
                    matrix[i][j] = 1;
                } else if (edge.getTargetVertex().equals(vertices.get(i))) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

}
