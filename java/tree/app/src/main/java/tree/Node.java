package tree;

public class Node<T> {
  private T value;
  private Node<T> leftChild;
  private Node<T> rightChild;

  public Node(T value) {
    this.value = value;
    leftChild = null;
    rightChild = null;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node<T> leftChild) {
    this.leftChild = leftChild;
  }

  public Node<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node<T> rightChild) {
    this.rightChild = rightChild;
  }

  @Override
  public String toString() {
    return "Node{" +
      "value=" + value +
      ", leftChild=" + leftChild +
      ", rightChild=" + rightChild +
      '}';
  }
}
