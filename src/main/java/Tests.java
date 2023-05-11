import java.util.ArrayList;
import java.util.List;


public class Tests {
    public static void main(String[] args) {
        XmlToGraphConverter converter = new XmlToGraphConverter();
//         bayg29
//        29 wierzchołki,  krawędzi 812
//         att48
//        48 wierzchołki,  krawędzi 2256
//         ch130
//        130 wierzchołki,  krawędzi 16770
//         brg180
//        180 wierzchołki,  krawędzi 32220
        List<Vertex> vertexList1 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\bayg29.xml");
        List<Edge> edgeList1 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\bayg29.xml");
        List<Vertex> vertexList2 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\att48.xml");
        List<Edge> edgeList2 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\att48.xml");
        List<Vertex> vertexList3 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\ch130.xml");
        List<Edge> edgeList3 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\ch130.xml");
        List<Vertex> vertexList4 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\brg180.xml");
        List<Edge> edgeList4 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\brg180.xml");
        List<Vertex> vertexList5 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\a280.xml");
        List<Edge> edgeList5 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\a280.xml");

        List<Vertex> vertexList6 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\rbg358.xml");
        List<Edge> edgeList6 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\rbg358.xml");

        List<Vertex> vertexList7 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\fl417.xml");
        List<Edge> edgeList7 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\fl417.xml");

        List<Vertex> vertexList8 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\gr431.xml");
        List<Edge> edgeList8 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\gr431.xml");

        List<Vertex> vertexList9 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\d493.xml");
        List<Edge> edgeList9 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\d493.xml");


        List<Vertex> vertexList10 = converter.convertListOfVertexFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\ali535.xml");
        List<Edge> edgeList10 = converter.convertListOfEdgeFromXmlToGraph("C:\\Users\\grzes\\Downloads\\grafy\\ali535.xml");

        List<List<Vertex>> vertexList = new ArrayList<>();
        vertexList.add(vertexList1);
        vertexList.add(vertexList2);
        vertexList.add(vertexList3);
        vertexList.add(vertexList4);
        vertexList.add(vertexList5);
        vertexList.add(vertexList6);
        vertexList.add(vertexList7);
        vertexList.add(vertexList8);
        vertexList.add(vertexList9);
        vertexList.add(vertexList10);

        List<List<Edge>> edgeList = new ArrayList<>();
        edgeList.add(edgeList1);
        edgeList.add(edgeList2);
        edgeList.add(edgeList3);
        edgeList.add(edgeList4);
        edgeList.add(edgeList5);
        edgeList.add(edgeList6);
        edgeList.add(edgeList7);
        edgeList.add(edgeList8);
        edgeList.add(edgeList9);
        edgeList.add(edgeList10);

        for (int i = 0; i < 10; i++) {
//            dijkstraGraphNeighborhoodList(vertexList.get(i), edgeList.get(i));
            dijkstraAdjacencyMatrixGraph(vertexList.get(i), edgeList.get(i));
//            dijkstraPathEdgeListGraph(vertexList.get(i), edgeList.get(i));
//            dijkstraIncidenceMatrixGraph(vertexList.get(i), edgeList.get(i));
        }


//        dijkstraGraphNeighborhoodList(vertexList6, edgeList6);

//        dijkstraAdjacencyMatrixGraph(vertexList6, edgeList6);
//        dijkstraPathEdgeListGraph(vertexList6, edgeList6);
//        dijkstraIncidenceMatrixGraph(vertexList6, edgeList6);

    }

    static void dijkstraGraphNeighborhoodList(List<Vertex> vertexList, List<Edge> edgeList) {
        GraphNeighborhoodList graphNeighborhoodList = new GraphNeighborhoodList();
        for (Vertex vertex : vertexList) {
            graphNeighborhoodList.addVertex(vertex);
        }
        for (Edge edge : edgeList) {
            graphNeighborhoodList.addEdge(edge);
        }
        Dijkstra dijkstra = new Dijkstra();
        long start = System.nanoTime();
        dijkstra.computePathByNeighborhoodList(vertexList.get(0), graphNeighborhoodList);
        dijkstra.getShortestPathTo(vertexList.get(1));
        long end = System.nanoTime();
        System.out.println("Dla listy sąsiedztwa czas wynosi " + ((end - start) * 0.000000001) + " sekund");
    }

    static void dijkstraAdjacencyMatrixGraph(List<Vertex> vertexList, List<Edge> edgeList) {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(vertexList);
        for (Edge edge : edgeList) {
            adjacencyMatrixGraph.addEdge(edge);
        }
        Dijkstra dijkstra = new Dijkstra();
        long start = System.nanoTime();
        dijkstra.computePathAdjacencyMatrixGraph(vertexList.get(0), adjacencyMatrixGraph);
        long end = System.nanoTime();
        System.out.println("Dla Macierzy sąsiedztwa czas wynosi " + ((end - start) * 0.000000001) + " sekund");
    }

    static void dijkstraPathEdgeListGraph(List<Vertex> vertexList, List<Edge> edgeList) {
        System.out.println(edgeList.size());
        EdgeListGraph edgeListGraph = new EdgeListGraph();
        for (Edge edge : edgeList) {
            edgeListGraph.addEdge(edge);
        }
        Dijkstra dijkstra = new Dijkstra();
        long start = System.nanoTime();
        dijkstra.computePathEdgeList(vertexList.get(0), edgeListGraph);
        dijkstra.getShortestPathTo(vertexList.get(vertexList.size() - 1));
        long end = System.nanoTime();
        System.out.println("Dla listy krawędzi czas wynosi " + ((end - start) * 0.000000001) + " sekund");
    }

    static void dijkstraIncidenceMatrixGraph(List<Vertex> vertexList, List<Edge> edgeList) {
        IncidenceMatrix incidenceMatrix = new IncidenceMatrix(vertexList, edgeList);
        Dijkstra dijkstra = new Dijkstra();
        long start = System.nanoTime();
        dijkstra.computePathIncidenceMatrix(vertexList.get(0), incidenceMatrix);
        dijkstra.getShortestPathTo(vertexList.get(2));
        dijkstra.getShortestPathTo(vertexList.get(vertexList.size() - 1));
        long end = System.nanoTime();
        System.out.println("Dla Macierz Incydencji czas wynosi " + ((end - start) * 0.000000001) + " sekund");
    }

}
