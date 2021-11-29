package graph;

public class Edge<T> {
  private Vertex<T> start;
  private Vertex<T> end;
  private int weight;

  public Edge(Vertex<T> start, Vertex<T> end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  public Edge(Vertex<T> start, Vertex<T> end) {
    this.start = start;
    this.end = end;
    this.weight = 1;
  }

  public Vertex<T> getStart() {
    return start;
  }

  public Vertex<T> getEnd() {
    return end;
  }

  public int getWeight() {
    return weight;
  }



  public String toString() {
    return start +"<-"+weight+"->"+ end ;
  }

  public void setStart(Vertex<T> start) {
    this.start = start;
  }

  public void setEnd(Vertex<T> end) {
    this.end = end;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
