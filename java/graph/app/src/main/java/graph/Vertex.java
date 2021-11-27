package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
  private T value;
  private final List<Edge<T>> edges;

  public Vertex(T value) {
    this.value = value;
    edges = new ArrayList<>();
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public List<Edge<T>> getEdges() {
    return edges;
  }

  public int getEdge(Vertex<T> start, Vertex<T> end) {
    for (Edge<T> edge : edges) {
      if ((edge.getStart().equals(start) && edge.getEnd().equals(end)) || edge.getStart().equals(end) && edge.getEnd().equals(start)) {
        return edge.getWeight();
      }
    }
    return 0;
  }

  public void addEdge(Edge<T> edge) {
    edges.add(edge);
  }


  @Override
  public String toString() {
    return value.toString();
  }

}
