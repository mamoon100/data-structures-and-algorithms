package queue;

import linked.list.Node;

public class Queue<T> {
  Node<T> front;
  Node<T> back;
  int length = 0;

  public Queue() {
    this.front = null;
    this.back = null;
  }

  public void enqueue(T value) {
    Node<T> node = new Node<>(value);
    if (isEmpty()) this.front = node;
    else this.back.nextPointer = node;
    this.back = node;
    length++;
  }

  public T dequeue() {
    Node<T> temp = this.front;
    try {
      if (isEmpty()) throw new NullPointerException("The Queue is empty nothing to dequeue \uD83E\uDD28");
      this.front = this.front.nextPointer;
      this.length--;
      return temp.value;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }

  public T peek() {
    try {
      if (isEmpty()) throw new NullPointerException("The Queue is empty there no one in the line to peek \uD83E\uDD73");
      return this.front.value;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }


  public boolean isEmpty() {
    return this.front == null;
  }

  @Override
  public String toString() {
    Node<T> front = this.front;
    String msg = "";
    msg += "Front => ";
    while (front != null) {
      msg += "{" + front.value + "} =>";
      front = front.nextPointer;
    }
    msg += " Null";
    return msg;
  }
}
