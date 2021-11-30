/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph;


import java.util.List;

public class App {
  public static void main(String[] args) {

    System.out.println("Let's define a new graph using some vertices");
    Graph<String> graph = new Graph<>();
    Vertex<String> a = graph.addVertex("A");
    Vertex<String> b = graph.addVertex("B");
    Vertex<String> c = graph.addVertex("C");
    Vertex<String> d = graph.addVertex("D");
    Vertex<String> e = graph.addVertex("E");
    System.out.print("The vertices we are using ->");
    System.out.print("  1." + a);
    System.out.print("  2." + b);
    System.out.print("  3." + c);
    System.out.print("  4." + d);
    System.out.println("  5." + e);

    System.out.println("Now let's add connect some edges");
    graph.addEdge(a, b, 5);
    System.out.println("We connected A and B with edge and weight 5.");
    graph.addEdge(a, c);
    System.out.println("We connected A and C with edge.");
    graph.addEdge(b, d);
    System.out.println("We connected B and D with edge.");
    graph.addEdge(c, d);
    System.out.println("We connected C and D with edge.");
    graph.addEdge(d, e);
    System.out.println("We connected D and E with edge.");

    System.out.println("Now Let's print the graph in adjacency List");
    graph.print();

    System.out.println("Now let's print the breadth first graph");
    System.out.println(graph.breadthFirst(a));

    String[] cityNames = {"A","B","D", "E"};



    System.out.println("Now Let's say we have business trip for the same graph and we ant to travel from A -> B -> D -> E\nLet's see how much does it cost");
    System.out.println(businessTrip(graph,cityNames));
    System.out.println("Now we want to travel directly from A -> D which is not available so the cost is");
    System.out.println(businessTrip(graph,new String[]{"A", "D"}));
    System.out.println("You see it's null because there is no direct way from A -> D");

  }


  public static Integer businessTrip(Graph<String> graph, String[] cityNames) {
    int sum = 0;
    for (int i=0 ; i<cityNames.length-1; i++) {
      Vertex<String> parent = graph.getVertex(cityNames[i]);
      if (parent == null) return null;
      Vertex<String> child = graph.getVertex(cityNames[i+1]);
      List<Vertex<String>> childList = graph.getNeighbors(parent);
      if (childList.contains(child)) sum+= child.getEdge(parent,child);
      else return null;
    }
    return sum;
  }
}
