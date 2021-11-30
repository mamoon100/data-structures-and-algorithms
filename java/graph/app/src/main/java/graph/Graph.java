package graph;

import com.google.common.collect.Lists;

import java.util.*;

public class Graph<T> {
  private final Map<Vertex<T>, List<Vertex<T>>> adjacencyList;
  private int size;

  public Graph() {
    adjacencyList = new HashMap<>();
    size = 0;
  }

  public Vertex<T> addVertex(T value) {
    Vertex<T> vertex = new Vertex<T>(value);
    adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    size++;
    return vertex;
  }

  public boolean isVertexFound(T value) {
    return adjacencyList.containsKey(new Vertex<>(value));
  }


  public void addEdge(Vertex<T> v1, Vertex<T> v2) {
    if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
      Edge<T> edge = new Edge<T>(v1, v2);
      v1.addEdge(edge);
      v2.addEdge(edge);
      adjacencyList.get(v1).add(v2);
      adjacencyList.get(v2).add(v1);
    }
  }

  public Vertex<T> getVertex(T value) {
    for (Vertex<T> vertex : getVertices()) {
      if (vertex.getValue() == value) return vertex;
    }
    return null;
  }

  public List<Vertex<T>> getVertices() {
    return new ArrayList<>(adjacencyList.keySet());
  }

  public void addEdge(Vertex<T> v1, Vertex<T> v2, int weight) {
    if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
      Edge<T> edge = new Edge<T>(v1, v2, weight);
      v1.addEdge(edge);
      v2.addEdge(edge);
      adjacencyList.get(v1).add(v2);
      adjacencyList.get(v2).add(v1);

    }
  }

  public void printEdges() {
    for (Vertex<T> vertex : adjacencyList.keySet()) {
      for (Vertex<T> neighbor : adjacencyList.get(vertex)) {
        System.out.println(vertex + " " + neighbor);
      }
    }
  }

  public Map<Vertex<T>, List<Vertex<T>>> getAdjacencyList() {
    return adjacencyList;
  }

  public List<Vertex<T>> getNeighbors(Vertex<T> vertex) {
    return adjacencyList.get(vertex);
  }


  public int size() {
    return size;
  }

  public List<T> breadthFirst(Vertex<T> vertex) {
    List<T> vertices = new ArrayList<>();
    Queue<Vertex<T>> breadth = new LinkedList<>();
    Set<T> visited = new HashSet<>();
    breadth.add(vertex);
    visited.add(vertex.getValue());
    while (!breadth.isEmpty()) {
      Vertex<T> front = breadth.remove();
      vertices.add(front.getValue());

      for (Vertex<T> child : getNeighbors(front)) {
        if (!visited.contains(child.getValue())) {
          visited.add(child.getValue());
          breadth.add(child);
        }
      }
    }
    return vertices;
  }


  public List<T> depthFirst(Vertex<T> vertex) {
    List<T> vertices = new ArrayList<>();
    Stack<Vertex<T>> breadth = new Stack<>();
    Set<Vertex<T>> visited = new HashSet<>();
    breadth.add(vertex);
    while (!breadth.isEmpty()) {
      Vertex<T> top = breadth.pop();

      boolean isAllVisited = visited.containsAll(getNeighbors(top));
      if (!isAllVisited) {
        visited.add(top);
        for (Vertex<T> child : getNeighbors(top)) {
          if (!visited.contains(child))
            breadth.add(child);
        }

      }
      vertices.add(top.getValue());

    }
    vertices.remove(vertices.size()-1);
    return vertices;
  }

  public void print() {
    for (Vertex<T> vertex : getVertices()) {
      System.out.print(vertex.getValue() + ": ");
      for (Vertex<T> neighbor : getNeighbors(vertex)) {
        System.out.print(neighbor.getValue() + "," + neighbor.getEdge(vertex, neighbor) + " ");
      }
      System.out.println();
    }
  }


}


