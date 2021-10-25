package queue;

import linked.list.Node;
import stack.Stack;

public class PseudoQueue<T> {

  private Stack<T> primary = new Stack<>();
  private int length = 0;

  public PseudoQueue() {
  }

  public void enqueue(T value) {
    primary.push(value);
    length++;
  }

  public T dequeue() {
    reverse(primary);
    T value = primary.pop();
    reverse(primary);
    length--;
    return value;
  }

  public void reverse(Stack<T> first) {
    Node<T> current = first.getTop();
    Stack<T> last = new Stack<>();
    while (current != null) {
      last.push(current.value);
      current = current.nextPointer;
    }
    this.primary = last;
  }

  public T getPrimary() {
    reverse(primary);
    T value = this.primary.getTop().value;
    reverse(primary);
    return value;
  }

  @Override
  public String toString() {
    String msg = "";
    msg += "Front =>";
    reverse(primary);
    Node<T> current = primary.getTop();
    while (current != null) {
      msg += "{" + current.value + "} =>";
      current = current.nextPointer;
    }
    reverse(primary);
    msg += " Null";
    return msg;
  }
}
