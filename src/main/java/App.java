import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        GraphNeighborhoodList graphNeighborhoodList = new GraphNeighborhoodList();
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");

        graphNeighborhoodList.addVertex(A);
        graphNeighborhoodList.addVertex(B);
        graphNeighborhoodList.addVertex(C);
        graphNeighborhoodList.addVertex(D);
        graphNeighborhoodList.addVertex(E);
        graphNeighborhoodList.addVertex(F);
        graphNeighborhoodList.addVertex(G);


        graphNeighborhoodList.addEdge(A, B, 5);
        graphNeighborhoodList.addEdge(A, C, 3);
        graphNeighborhoodList.addEdge(B, C, 1);
        graphNeighborhoodList.addEdge(B, D, 4);
        graphNeighborhoodList.addEdge(C, D, 2);
        graphNeighborhoodList.addEdge(C, E, 6);
        graphNeighborhoodList.addEdge(D, E, 7);
        graphNeighborhoodList.addEdge(D, F, 9);
        graphNeighborhoodList.addEdge(E, F, 8);
        graphNeighborhoodList.addEdge(E, G, 3);
        graphNeighborhoodList.addEdge(F, G, 2);
//
        Dijkstra dijkstra = new Dijkstra();
//        dijkstra.computePathByNeighborhoodList(A, graphNeighborhoodList);
//        System.out.println(dijkstra.getShortestPathTo(G));

//        EdgeListGraph edgeListGraph = new EdgeListGraph();
//        edgeListGraph.addEdge(new Edge(A, B, 5));
//        edgeListGraph.addEdge(new Edge(A, C, 3));
//        edgeListGraph.addEdge(new Edge(B, C, 1));
//        edgeListGraph.addEdge(new Edge(B, D, 4));
//        edgeListGraph.addEdge(new Edge(C, D, 2));
//        edgeListGraph.addEdge(new Edge(C, E, 6));
//        edgeListGraph.addEdge(new Edge(D, E, 7));
//        edgeListGraph.addEdge(new Edge(D, F, 9));
//        edgeListGraph.addEdge(new Edge(E, F, 8));
//        edgeListGraph.addEdge(new Edge(E, G, 3));
//        edgeListGraph.addEdge(new Edge(F, G, 2));
//
//
//        dijkstra.computePathEdgeList(A, edgeListGraph);
//        System.out.println(dijkstra.getShortestPathTo(G));


//        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(new ArrayList<>(List.of(A, B, C, D, E, F, G)));
//        adjacencyMatrixGraph.addEdge(new Edge(A, B, 5));
//        adjacencyMatrixGraph.addEdge(new Edge(A, C, 3));
//        adjacencyMatrixGraph.addEdge(new Edge(B, C, 1));
//        adjacencyMatrixGraph.addEdge(new Edge(B, D, 4));
//        adjacencyMatrixGraph.addEdge(new Edge(C, D, 2));
//        adjacencyMatrixGraph.addEdge(new Edge(C, E, 6));
//        adjacencyMatrixGraph.addEdge(new Edge(D, E, 7));
//        adjacencyMatrixGraph.addEdge(new Edge(D, F, 9));
//        adjacencyMatrixGraph.addEdge(new Edge(E, F, 8));
//        adjacencyMatrixGraph.addEdge(new Edge(E, G, 3));
//        adjacencyMatrixGraph.addEdge(new Edge(F, G, 2));
//
//
//        dijkstra.computePathAdjacencyMatrixGraph(A, adjacencyMatrixGraph);
//        System.out.println(dijkstra.getShortestPathTo(G));


//        List<Vertex> vertices = new ArrayList<>();
//        vertices.add(A);
//        vertices.add(B);
//        vertices.add(C);
//        vertices.add(D);
//        vertices.add(E);
//        vertices.add(F);
//        vertices.add(G);
//
//
//        Edge e1 = new Edge(A, B, 5);
//        e1.setWhichEdge(0);
//        Edge e2 = new Edge(A, C, 3);
//        e2.setWhichEdge(1);
//        Edge e3 = new Edge(B, C, 1);
//        e3.setWhichEdge(2);
//        Edge e4 = new Edge(B, D, 4);
//        e4.setWhichEdge(3);
//        Edge e5 = new Edge(C, D, 2);
//        e5.setWhichEdge(4);
//        Edge e6 = new Edge(C, E, 6);
//        e6.setWhichEdge(5);
//        Edge e7 = new Edge(D, E, 7);
//        e7.setWhichEdge(6);
//        Edge e8 = new Edge(D, F, 9);
//        e8.setWhichEdge(7);
//        Edge e9 = new Edge(E, F, 8);
//        e9.setWhichEdge(8);
//        Edge e10 = new Edge(E, G, 3);
//        e10.setWhichEdge(9);
//        Edge e11 = new Edge(F, G, 2);
//        e11.setWhichEdge(10);
//
//        List<Edge> edges = new ArrayList<>();
//        edges.add(e1);
//        edges.add(e2);
//        edges.add(e3);
//        edges.add(e4);
//        edges.add(e5);
//        edges.add(e6);
//        edges.add(e7);
//        edges.add(e8);
//        edges.add(e9);
//        edges.add(e10);
//        edges.add(e11);
//
//
//        IncidenceMatrix incidenceMatrix = new IncidenceMatrix(vertices, edges);
//        dijkstra.computePathIncidenceMatrix(A, incidenceMatrix);
//        System.out.println(dijkstra.getShortestPathTo(G));


    }
}
