package linked.list;

public class Node <T> {
  public T value;
  Node<T> nextPointer;

  public Node(T value) {
    this.value = value;
  }
}
