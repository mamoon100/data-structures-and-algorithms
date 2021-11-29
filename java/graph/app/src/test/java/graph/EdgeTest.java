package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {
  Vertex<String> start = new Vertex<>("Start");
  Vertex<String> end = new Vertex<>("End");
  Edge<String> edge = new Edge<>(start, end);


  @Test
  public void initializeEdgeTest() {
    assertEquals("There was problem with initialize Edge", "Start", edge.getStart().getValue());
    assertEquals("There was problem with initialize Edge", "End", edge.getEnd().getValue());
    assertEquals("There was problem with initialize Edge with weight of one", 1, edge.getWeight());
  }


  @Test
  public void setterAndGetterTest() {
    Vertex<String> anotherStart = new Vertex<>("Another Start");
    Vertex<String> anotherEnd = new Vertex<>("Another End");
    edge.setStart(anotherStart);
    edge.setEnd(anotherEnd);
    edge.setWeight(5);
    assertEquals("There was an error in the setter of start", "Another Start", edge.getStart().getValue());
    assertEquals("There was an error in the setter of end", "Another End", edge.getEnd().getValue());
    assertEquals("There was an error in the setter of weight", 5, edge.getWeight());
  }


  @Test
  public void toStringTest (){
    String toStringEdge = "A<-7->B";
    edge.setStart(new Vertex<>("A"));
    edge.setEnd(new Vertex<>("B"));
    edge.setWeight(7);
    assertEquals("There was problem in to string method in edge",edge.toString(),toStringEdge);

  }
}
