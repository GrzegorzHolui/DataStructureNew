import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class XmlToGraphConverter {

    public GraphNeighborhoodList convertXmlToGraph(String filePath) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new File(filePath));
            Element rootElement = document.getRootElement();
            Element graphElement = rootElement.getChild("graph");
            List<Element> vertexElements = graphElement.getChildren("vertex");

            GraphNeighborhoodList graph = new GraphNeighborhoodList();

            // Iterating over vertices
            int nameInInteger = 0;
            for (Element vertexElement : vertexElements) {
                String id = vertexElement.getAttributeValue("id");
                Vertex vertex = new Vertex(String.valueOf(nameInInteger));
                graph.addVertex(vertex);

                // Iterating over edges for this vertex
                List<Element> edgeElements = vertexElement.getChildren("edge");
                for (Element edgeElement : edgeElements) {
                    String text = edgeElement.getText();
                    Vertex adjacentVertex = new Vertex(text);

                    String cost1 = edgeElement.getAttributeValue("cost");
                    String cost2 = cost1.substring(0, 1);
                    int cost = Integer.parseInt(cost2);
                    graph.addEdge(vertex, adjacentVertex, cost);
                }
                nameInInteger++;
            }

            return graph;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Vertex> convertListOfVertexFromXmlToGraph(String filePath) {
        Set<Vertex> vertexList = new LinkedHashSet<>();
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new File(filePath));
            Element rootElement = document.getRootElement();
            Element graphElement = rootElement.getChild("graph");
            List<Element> vertexElements = graphElement.getChildren("vertex");
            // Iterating over vertices
            int counter = 0;
            for (Element vertexElement : vertexElements) {
                List<Element> edgeElements = vertexElement.getChildren("edge");
                for (Element edgeElement : edgeElements) {
                    String text = edgeElement.getText();
                    Vertex adjacentVertex = new Vertex(text);
                    vertexList.add(adjacentVertex);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return new ArrayList<>(vertexList);
    }

    public List<Edge> convertListOfEdgeFromXmlToGraph(String filePath) {
        List<Edge> result = new ArrayList<>();

        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new File(filePath));
            Element rootElement = document.getRootElement();
            Element graphElement = rootElement.getChild("graph");
            List<Element> vertexElements = graphElement.getChildren("vertex");

            // Iterating over vertices
            int letter = 0;
            for (Element vertexElement : vertexElements) {
                // Iterating over edges for this vertex
                List<Element> edgeElements = vertexElement.getChildren("edge");
                for (Element edgeElement : edgeElements) {
                    String text = edgeElement.getText();
                    Vertex startVertex = new Vertex(String.valueOf(letter));
                    Vertex targetVertex = new Vertex(text);
                    String cost1 = edgeElement.getAttributeValue("cost");
                    String cost2 = cost1.substring(0, 1);
                    int cost = Integer.parseInt(cost2);
                    Edge edge = new Edge(startVertex, targetVertex, cost);
                    result.add(edge);
                }
                letter++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return result;
    }

}