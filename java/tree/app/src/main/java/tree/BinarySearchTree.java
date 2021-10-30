package tree;


public class BinarySearchTree<T extends Number> extends BinaryTree<T> {

  public BinarySearchTree() {
    super();
  }

  public void add(T value) {
    // if the tree is already empty to insert into the head
    if (this.getRoot() == null) {
      this.setRoot(new Node<>(value));
      return;
    }
    Node<T> current = this.getRoot();
    try {
      while (current != null) {
        // No Duplicate value in Binary Search Tree (BST)
        if (value.doubleValue() == current.getValue().doubleValue()) {
          throw new ArithmeticException("There is no duplication in BST \uD83E\uDD26");
        } else if (value.doubleValue() > current.getValue().doubleValue()) {
          if (current.getRightChild() == null) {
            current.setRightChild(new Node<>(value));
            return;
          }
          current = current.getRightChild();
        } else {
          if (current.getLeftChild() == null) {
            current.setLeftChild(new Node<>(value));
            return;
          }
          current = current.getLeftChild();
        }
      }
    } catch (ArithmeticException e) {
      e.printStackTrace();
    }
  }

  public boolean contains(T value) {
    Node<T> current = this.getRoot();
    while (current != null) {
      if (current.getValue().doubleValue() == value.doubleValue()) return true;
      current = value.doubleValue() > current.getValue().doubleValue() ? current.getRightChild() : current.getLeftChild();
    }
    return false;
  }
}
