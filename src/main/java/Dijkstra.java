import java.util.*;

public class Dijkstra {

    public void computePathNeighborhoodList(Vertex sourceVertex, GraphNeighborhoodList graphNeighborhoodList) {
        sourceVertex.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        while (!priorityQueue.isEmpty()) {
            Vertex startVertex = priorityQueue.poll();
            for (Edge edge : graphNeighborhoodList.getNeighbors(startVertex)) {
                Vertex nextVertex = edge.getTargetVertex();
                int weight = edge.getWeight();
                int minDistance = startVertex.getMinDistance() + weight;
                if (minDistance < nextVertex.getMinDistance()) {
                    priorityQueue.remove(startVertex);
                    nextVertex.setPreviosVertex(startVertex);
                    nextVertex.setMinDistance(minDistance);
                    priorityQueue.add(nextVertex);
                }
            }
        }
    }

    public void computePathEdgeList(Vertex sourceVertex, EdgeListGraph EdgeListGraph) {
        sourceVertex.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        while (!priorityQueue.isEmpty()) {
            Vertex startVertex = priorityQueue.poll();
            for (Edge edge : EdgeListGraph.getEdges()) {
                if (edge.getStartVertex().equals(startVertex)) {
                    Vertex nextVertex = edge.getTargetVertex();
                    int weight = edge.getWeight();
                    int minDistance = startVertex.getMinDistance() + weight;
                    if (minDistance < nextVertex.getMinDistance()) {
                        priorityQueue.remove(startVertex);
                        nextVertex.setPreviosVertex(startVertex);
                        nextVertex.setMinDistance(minDistance);
                        priorityQueue.add(nextVertex);
                    }
                }
            }
        }
    }


    public void computePathAdjacencyMatrixGraph(Vertex sourceVertex, AdjacencyMatrixGraph adjacencyMatrixGraph) {
        sourceVertex.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        while (!priorityQueue.isEmpty()) {
            Vertex startVertex = priorityQueue.poll();
            for (Edge edge : adjacencyMatrixGraph.getEdges(startVertex)) {
                Vertex nextVertex = edge.getTargetVertex();
//                int weight = adjacencyMatrixGraph.getWeight(startVertex, sourceVertex);
                int weight = edge.getWeight();
                int minDistance = startVertex.getMinDistance() + weight;
                if (minDistance < nextVertex.getMinDistance()) {
                    priorityQueue.remove(startVertex);
                    nextVertex.setPreviosVertex(startVertex);
                    nextVertex.setMinDistance(minDistance);
                    priorityQueue.add(nextVertex);
                }
            }
        }
    }

    public void computePathIncidenceMatrix(Vertex sourceVertex, IncidenceMatrix incidenceMatrix) {
        sourceVertex.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        while (!priorityQueue.isEmpty()) {
            Vertex startVertex = priorityQueue.poll();
            for (Edge edge : incidenceMatrix.getListOfEdges(startVertex)) {

                Vertex nextVertex = edge.getTargetVertex();

                int weight = edge.getWeight();


                int minDistance = startVertex.getMinDistance() + weight;


                if (minDistance < nextVertex.getMinDistance()) {
                    priorityQueue.remove(startVertex);
                    nextVertex.setPreviosVertex(startVertex);
                    nextVertex.setMinDistance(minDistance);
                    priorityQueue.add(nextVertex);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex destination) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = destination; vertex != null; vertex = vertex.getPreviosVertex()) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }

}
