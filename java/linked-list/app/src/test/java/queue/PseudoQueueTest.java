package queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class PseudoQueueTest {
  @Test
  public void pseudoQueueTest() {
    PseudoQueue<String> names = new PseudoQueue<>();
    names.enqueue("Mamoun");
    names.enqueue("Hussein");
    names.enqueue("Osama");
    assertEquals("There was problem in the initilision of pseudo class", names.getPrimary(), "Mamoun");

    assertEquals("There was problem in dequeue", names.dequeue(), "Mamoun");
  }
}
