package tree;

import java.util.ArrayList;

public class BinaryTree<T> {
  private Node<T> root;
  private ArrayList<T> order;

  public BinaryTree() {
    this.root = null;
  }

  public Node<T> getRoot() {
    return root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }

  public ArrayList<T> preOrder(Node<T> root) {
    if (this.root == null) return new ArrayList<>();
    this.order = this.root == root ? new ArrayList<>() : this.order;
    if (root != null) {
      order.add(root.getValue());
      preOrder(root.getLeftChild());
      preOrder(root.getRightChild());
    }
    return order;
  }

  public ArrayList<T> inOrder(Node<T> root) {
    if (this.root == null) return new ArrayList<>();
    this.order = this.root == root ? new ArrayList<>() : this.order;
    if (root != null) {
      inOrder(root.getLeftChild());
      order.add(root.getValue());
      inOrder(root.getRightChild());

    }
    return order;
  }

  public ArrayList<T> postOrder(Node<T> root) {
    if (this.root == null) return new ArrayList<>();
    this.order = this.root == root ? new ArrayList<>() : this.order;
    if (root != null) {
      postOrder(root.getLeftChild());
      postOrder(root.getRightChild());
      order.add(root.getValue());

    }
    return order;
  }

  public Number findMaximumValue() {
    if (this.root == null) return null;
    double max = Double.MIN_VALUE;
    ArrayList<Number> numbers = (ArrayList<Number>) (this.order != null ? this.order : postOrder(this.root));
    for (Number number : numbers) {
      if (number.doubleValue() > max) max = number.doubleValue();
    }
    return max;
  }

  // this method and traversePreOrder I copied them from the internet.
  @Override

  public String toString() {
    StringBuilder sb = new StringBuilder();
    traversePreOrder(sb, "", "", this.getRoot());
//    System.out.println(sb);
    return String.valueOf(sb);
  }

  private void traversePreOrder(StringBuilder sb, String padding, String pointer, Node<T> node) {
    if (node != null) {
      sb.append(padding);
      sb.append(pointer);
      sb.append(node.getValue());
      sb.append("\n");
      String paddingForBoth = padding + "│  ";
      String pointerForRight = "└──";
      String pointerForLeft = (node.getRightChild() != null) ? "├──" : "└──";
      traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeftChild());
      traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRightChild());
    }
  }
}
