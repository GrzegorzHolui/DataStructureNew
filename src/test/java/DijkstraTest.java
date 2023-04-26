import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DijkstraTest {

    static List<Vertex> vertexList = new ArrayList<>();
    static List<Edge> edgeList = new ArrayList<>();
    static GraphNeighborhoodList graphNeighborhoodList = new GraphNeighborhoodList();
    static EdgeListGraph edgeListGraph = new EdgeListGraph();
    static AdjacencyMatrixGraph adjacencyMatrixGraph;
    static IncidenceMatrix incidenceMatrix;


    @BeforeEach
    void init1() {
        char letter = 'A';
        for (int i = 0; i < 7; i++) {
            Vertex vertex = new Vertex(String.valueOf(letter));
            vertexList.add(vertex);
            letter++;
        }
        adjacencyMatrixGraph = new AdjacencyMatrixGraph(vertexList);
    }

    @AfterEach
    void init() {
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    @BeforeEach
    void init2() {
        Edge e1 = new Edge(vertexList.get(0), vertexList.get(1), 5);
        Edge e2 = new Edge(vertexList.get(0), vertexList.get(2), 3);
        Edge e3 = new Edge(vertexList.get(1), vertexList.get(2), 1);
        Edge e4 = new Edge(vertexList.get(1), vertexList.get(3), 4);
        Edge e5 = new Edge(vertexList.get(2), vertexList.get(3), 2);
        Edge e6 = new Edge(vertexList.get(2), vertexList.get(4), 6);
        Edge e7 = new Edge(vertexList.get(3), vertexList.get(4), 7);
        Edge e8 = new Edge(vertexList.get(3), vertexList.get(5), 9);
        Edge e9 = new Edge(vertexList.get(4), vertexList.get(5), 8);
        Edge e10 = new Edge(vertexList.get(4), vertexList.get(6), 3);
        Edge e11 = new Edge(vertexList.get(5), vertexList.get(6), 2);

        e1.setWhichEdge(0);
        e2.setWhichEdge(1);
        e3.setWhichEdge(2);
        e4.setWhichEdge(3);
        e5.setWhichEdge(4);
        e6.setWhichEdge(5);
        e7.setWhichEdge(6);
        e8.setWhichEdge(7);
        e9.setWhichEdge(8);
        e10.setWhichEdge(9);
        e11.setWhichEdge(10);

        edgeList.add(e1);
        edgeList.add(e2);
        edgeList.add(e3);
        edgeList.add(e4);
        edgeList.add(e5);
        edgeList.add(e6);
        edgeList.add(e7);
        edgeList.add(e8);
        edgeList.add(e9);
        edgeList.add(e10);
        edgeList.add(e11);

    }

    @BeforeEach
    void init3() {
        incidenceMatrix = new IncidenceMatrix(vertexList, edgeList);
    }

    @Test
    void computePathAdjacencyMatrixGraph() {
        //given
        for (Edge edge : edgeList) {
            adjacencyMatrixGraph.addEdge(edge);
        }
        //when
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePathAdjacencyMatrixGraph(vertexList.get(0), adjacencyMatrixGraph);
        List<Vertex> result = dijkstra.getShortestPathTo(vertexList.get(6));
        //then
        List<Vertex> expected = Arrays.asList(vertexList.get(0), vertexList.get(2), vertexList.get(4), vertexList.get(6));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnGoodListOfGraphNameWhenMethodComputePathByNeighborhoodListIsUsed() {
        //given

        for (Vertex vertex : vertexList) {
            graphNeighborhoodList.addVertex(vertex);
        }
        for (Edge edge : edgeList) {
            graphNeighborhoodList.addEdge(edge);
        }

        //when
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePathByNeighborhoodList(vertexList.get(0), graphNeighborhoodList);
        List<Vertex> result = dijkstra.getShortestPathTo(vertexList.get(6));
        //then
        List<Vertex> expected = Arrays.asList(vertexList.get(0), vertexList.get(2), vertexList.get(4), vertexList.get(6));
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void computePathAdjacencyEdgeListGraph() {
        //given
        for (Edge edge : edgeList) {
            edgeListGraph.addEdge(edge);
        }
        //when
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePathEdgeList(vertexList.get(0), edgeListGraph);
        List<Vertex> result = dijkstra.getShortestPathTo(vertexList.get(6));
        //then
        List<Vertex> expected = Arrays.asList(vertexList.get(0), vertexList.get(2), vertexList.get(4), vertexList.get(6));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    void computePathAdjacencyIncidenceMatrixGraph() {
        //when
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePathIncidenceMatrix(vertexList.get(0), incidenceMatrix);
        List<Vertex> result = dijkstra.getShortestPathTo(vertexList.get(6));
        //then
        List<Vertex> expected = Arrays.asList(vertexList.get(0), vertexList.get(2), vertexList.get(4), vertexList.get(6));
        assertThat(result).isEqualTo(expected);
    }

}