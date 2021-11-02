package tree;

public class KTree<T> {
  private KNode<T> root;

  public KTree() {

  }

  public KNode<T> getRoot() {
    return root;
  }

  public void setRoot(KNode<T> root) {
    this.root = root;
  }
}
