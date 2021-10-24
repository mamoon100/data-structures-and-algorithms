package linked.list;

public class Node<T> {
  public T value;
  public Node<T> nextPointer;

  public Node(T value) {
    this.value = value;
  }
}
