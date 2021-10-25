package stack;

import org.junit.Test;
import stack.Stack;

import static org.junit.Assert.*;

public class StackTest {
  @Test
  public void emptyStackTest() {
    // create new stack
    Stack<String> names = new Stack<>();
    assertNull("There was a problem creating Stack", names.getTop());
    // checking for an empty Stack
    assertTrue("The stack is not Empty", names.isEmpty());
  }

  @Test
  public void stackPushTest() {
    Stack<String> names = new Stack<>();
    names.push("Mamoun");
    assertEquals("There was problem pushing into Stack ", names.toString(), "top => {Mamoun} => Null");
    names.push("Ali");
    names.push("Maram");
    assertEquals("There was problem pushing the names into stack", names.toString(), "top => {Maram} =>{Ali} =>{Mamoun} => Null");
  }


  @Test
  public void stackPeekTest() {
    Stack<String> names = new Stack<>();
    names.push("Mamoun");
    assertEquals("There was problem peeking into Stack ", names.peek(), "Mamoun");
    names.push("Ali");
    names.push("Maram");
    assertEquals("There was problem peeking the names into stack", names.peek(), "Maram");
  }

  @Test
  public void stackPopTest() {
    Stack<String> names = new Stack<>();
    names.push("Mamoun");
    assertEquals("There was problem poping from Stack ", names.pop(), "Mamoun");
    names.push("Ali");
    names.push("Maram");
    assertEquals("There was problem poping the names into stack", names.pop(), "Maram");
    assertEquals("There was problem poping the names into stack", names.pop(), "Ali");
    assertNull("The Stack is not empty after multiable pop", names.getTop());
  }
}
