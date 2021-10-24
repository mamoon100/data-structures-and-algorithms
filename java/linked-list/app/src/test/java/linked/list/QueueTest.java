package linked.list;

import org.junit.Test;
import queue.Queue;

import static org.junit.Assert.*;

public class QueueTest {

  @Test
  public void emptyQueueTest() {
    // create new stack
    Queue<String> names = new Queue<>();
    assertNull("There was a problem creating Front of the Queue", names.front);
    assertNull("There was a problem in creating the back of the Queue", names.back);
    // checking for an empty Stack
    assertTrue("The Queue is not Empty", names.isEmpty());
  }

  @Test
  public void queueEnqueueTest() {
    Queue<String> names = new Queue<>();
    names.enqueue("Mamoun");
    assertEquals("There was problem enqueue into the Queue ", names.toString(), "Front => {Mamoun} => Null");
    names.enqueue("Ali");
    names.enqueue("Maram");
    assertEquals("There was problem enqueuing the names into Queue", names.toString(), "Front => {Mamoun} =>{Ali} =>{Maram} => Null");
  }


  @Test
  public void queuePeekTest() {
    Queue<String> names = new Queue<>();
    names.enqueue("Mamoun");
    assertEquals("There was problem peeking into Stack ", names.peek(), "Mamoun");
    names.enqueue("Ali");
    names.enqueue("Maram");
    assertEquals("There was problem peeking the names into stack", names.peek(), "Mamoun");
    assertEquals("There was problem in the back of the queue", names.back.value, "Maram");
  }

  @Test
  public void queuePopTest() {
    Queue<String> names = new Queue<>();
    names.enqueue("Mamoun");
    assertEquals("There was problem dequeuing from Queue ", names.dequeue(), "Mamoun");
    names.enqueue("Ali");
    names.enqueue("Maram");
    assertEquals("There was problem dequeuing the names from Queue", names.dequeue(), "Ali");
    assertEquals("There was problem dequeuing the names from Queue", names.dequeue(), "Maram");
    assertNull("The Queube Front is not empty after multiable dequeue", names.front);

  }
}
