package linked.list;

public class LinkedList<T> {
  Node<T> head;

  public LinkedList() {
    this.head = null;
  }

  // insert a node in the first of the node
  public void insert(T value) {
    if (head == null) head = new Node<T>(value);
    else {
      Node<T> insertingNode = new Node<T>(value);
      insertingNode.nextPointer = this.head;
      this.head = insertingNode;
    }

  }

  // check if the node has certain value
  public boolean includes(T value) {
    Node<T> current = this.head;
    while (current != null) {
      if (current.value == value) {
        return true;
      }
      current = current.nextPointer;

    }
    return false;
  }

  @Override
  public String toString() {

    String nodeMsg = "";
    Node<T> current = this.head;
    while (current != null) {
      nodeMsg += "{" + current.value + "} =>";
      current = current.nextPointer;
    }
    return nodeMsg + "Null";
  }

  public void append(T value) {
    if (head == null) head = new Node<T>(value);
    else {
      Node<T> insertingNode = new Node<T>(value);
      Node<T> current = this.head;
      while (current.nextPointer != null) {
        current = current.nextPointer;
      }
      current.nextPointer = insertingNode;

    }
  }

  public void insertBefore(T desireValue, T value) {
    Node<T> node = new Node<T>(value);
    Node<T> current = this.head;
    while (current.nextPointer != null) {
      if (current.nextPointer.value == desireValue) {
        node.nextPointer = current.nextPointer;
        current.nextPointer = node;
        return;
      } else if (current.value == desireValue) insert(value);
      current = current.nextPointer;
    }


//      throw new Exception("No matching number ");

  }

  public void insertAfter(T desireValue, T value) {
    Node<T> node = new Node<>(value);
    Node<T> current = this.head;
    while (current.value != desireValue) {
      current = current.nextPointer;
    }
    node.nextPointer = current.nextPointer;
    current.nextPointer = node;
//    while (current.value != null) {
//      if (current.value == desireValue) {
//        node.nextPointer = current.nextPointer;
//        current.nextPointer = node;
//        return;
//      }
//      current = current.nextPointer;
//    }

  }
}
