package tree;

import java.util.ArrayList;

public class KNode<T> {
  private T value;
  private ArrayList<KNode<T>> children;

  public KNode(T value) {
    this.value = value;
    this.children = new ArrayList<>();
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public void addChild(KNode<T> value) {
    this.children.add(value);
  }

  public ArrayList<KNode<T>> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<KNode<T>> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "KNode{" +
      "value=" + value +
      ", children=" + children +
      '}';
  }
}
