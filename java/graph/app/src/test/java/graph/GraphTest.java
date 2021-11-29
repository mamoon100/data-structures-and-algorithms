package graph;


import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GraphTest {
  @Test
  public void graphTest () {
    Graph<String> graph = new Graph<>();
    Vertex<String> a = graph.addVertex("A");
    Vertex<String> b = graph.addVertex("B");
    Vertex<String> c = graph.addVertex("C");
    Vertex<String> d = graph.addVertex("D");
    Vertex<String> e = graph.addVertex("E");
    graph.addEdge(a, b, 5);
    graph.addEdge(a, c);
    graph.addEdge(b, d);
    graph.addEdge(c, d);
    graph.addEdge(d, e);
    Map<Vertex<String>, List<Vertex<String>>> vertexListMap = graph.getAdjacencyList();

    assertEquals("There was an error in the graph imp",graph.getAdjacencyList(), vertexListMap);
  }

}
