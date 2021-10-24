package queue;

import linked.list.Node;

public class PseudoQueue<T> {

  private Node<T> front;
  private Node<T> back;
  private int length;

  public void enqueue(T value) {
    Node<T> node = new Node<>(value);
    if (this.front == null) this.front = node;
    else this.back.nextPointer = node;
    this.back = node;
    this.length++;
  }

  public T dequeue() {
    Node<T> temp = this.front;
    try {
      if (this.front == null) throw new NullPointerException("The Queue is empty nothing to dequeue \uD83E\uDD28");
      this.front = this.front.nextPointer;
      this.length--;
      return temp.value;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }
}
