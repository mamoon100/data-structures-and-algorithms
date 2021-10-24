package stack;

import linked.list.Node;

public class Stack<T> {
  Node<T> top;
  int length = 0;

  public Stack() {
    this.top = null;
  }

  public void push(T value) { // O(1) for space and time.
    Node<T> node = new Node<>(value);
    node.nextPointer = this.top;
    this.top = node;
    length++;
  }

  public T pop() { // O(1) for space and time.
    Node<T> temp = this.top; // just for return value.
    try { // to handle the empty stack
      if (this.isEmpty()) throw new NullPointerException("The Stack is empty nothing to pop \uD83E\uDD2D");
      this.top = this.top.nextPointer;
      length--;
      return temp.value;
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    return null;
  }

  public T peek() { // O(1) for both time and space
    try { // to handle the empty stack
      if (this.isEmpty()) throw new NullPointerException("The stack is empty nothing to peek \uD83D\uDC40");
      return this.top.value;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean isEmpty() {
    return this.top == null;
  }

  @Override
  public String toString() {
    Node<T> current = this.top;
    String msg = "";
    msg += "top => ";
    while (current != null) {
      msg += "{" + current.value + "} =>";
      current = current.nextPointer;
    }
    msg += " Null";
    return msg;
  }
}
