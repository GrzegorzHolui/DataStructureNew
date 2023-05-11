import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph {
    private int[][] matrix;
    private List<Vertex> vertices;

    public AdjacencyMatrixGraph(List<Vertex> vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices.size()][vertices.size()];
    }

    public void addEdge(Edge edge) {
        int sourceIndex = vertices.indexOf(edge.getStartVertex());
        int destIndex = vertices.indexOf(edge.getTargetVertex());
        matrix[sourceIndex][destIndex] = edge.getWeight();
    }

    public List<Edge> getEdges(Vertex startVertex) {
//        char letter = startVertex.getName().charAt(0);
//        int position = letter - 'A';
        int position = Integer.parseInt(startVertex.getName());
        int row[] = matrix[position];
        List<Edge> result = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            int currentWeight = row[i];
            if (currentWeight > 0) {
//                char letterOfVertex = (char) (i + 65);
                String letterOfVertex = String.valueOf(i);
                String stringLetterOfVertex = String.valueOf(letterOfVertex);
                Vertex falseDestination = new Vertex(stringLetterOfVertex);
                int i1 = vertices.indexOf(falseDestination);
                Vertex destination = vertices.get(i1);
                Edge edge = new Edge(startVertex, destination, currentWeight);
                result.add(edge);
            }
        }
        return result;
    }

//    public static void main(String[] args) {
////        char ch = 'B';
////        int pos = ch - 'A';
////        System.out.println(pos);
//        char a = (char) (48 + 17);
//        System.out.println(a);
//    }

    public int getWeight(Vertex source, Vertex destination) {
        int sourceIndex = vertices.indexOf(source);
        int destIndex = vertices.indexOf(destination);
        return matrix[sourceIndex][destIndex];
    }

}
