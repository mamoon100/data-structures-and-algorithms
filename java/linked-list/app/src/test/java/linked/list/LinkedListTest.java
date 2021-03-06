package linked.list;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


// this class conatain all the method inside the LinkedList class
public class LinkedListTest {
  // create new linked list
  LinkedList<Integer> testing = new LinkedList<>();
  ArrayList<Integer> testString = new ArrayList<>();

  public Integer randomNumber(int lower, int upper) {
    return (int) (Math.random() * (upper - lower)) + lower;
  }

  @Test
  public void emptyLinkedListTest() {

    // test for creating new linked list with null for head
    assertNull("There was an error in creating the linked List", this.testing.head);

  }

  @Test
  public void insertingInLinkedList() {
    // insert random value in the head inside linked list
    Integer[] valueToInsert = {randomNumber(0, 1000), randomNumber(0, 1000), randomNumber(0, 1000), randomNumber(0, 1000), randomNumber(0, 1000)};
    boolean checkValueOrder = true;
    for (int num : valueToInsert) {
      this.testing.insert(num);
      this.testString.add(num);
      if (this.testing.head.value != num) checkValueOrder = false;
    }
    assertTrue("There was an error in inserting method", checkValueOrder);

  }


  @Test
  public void includeLinkedList() {
    // insert random value in the head inside linked list
    int randomLength = randomNumber(5, 50);
    Integer[] valueToInclude = new Integer[randomLength];
    for (int i = 0; i < valueToInclude.length; i++) {
      valueToInclude[i] = randomNumber(500, 1000);
      this.testing.insert(valueToInclude[i]);
      this.testString.add(valueToInclude[i]);
    }
    int randomIndex = randomNumber(0, randomLength);
    assertTrue("There was an error in include method when true", this.testing.includes(valueToInclude[randomIndex]));
    assertFalse("There was an error in include method when false", this.testing.includes(randomNumber(1001, 2000)));
  }

  @Test
  public void toStringTest() {
    String actualString = "";
    for (int i = this.testString.size() - 1; i >= 0; i--) actualString += "{" + this.testString.get(i) + "} =>";
    actualString += "Null";
    assertEquals("There was an error in toString method", this.testing.toString(), actualString);
  }

  @Test
  public void appendTest() {
    // appending value to the end *all the random number from 500,1000 so any low number it will not be random
    this.testing.append(25);
    // get the last iterate value of the linked list
    Node<Integer> iter = this.testing.head;
    while (iter.nextPointer != null) {
      iter = iter.nextPointer;
    }
    assertEquals("There was an error in the appending method", iter.value, (Integer) 25);

    // test for an empty linkedList
    LinkedList<Integer> emptyLinkedList = new LinkedList<>();
    emptyLinkedList.append(5);
    assertEquals("There was an error in the appending method", emptyLinkedList.head.value, (Integer) 5);
  }

  @Test
  public void insertBeforeTest() {
    // this appends method to avoid error and be sure that there is number 25
    this.testing.append(25);
    // let's insert number 2 before the 25 we created up
    this.testing.insertBefore(25, 2);
    assertTrue("There was an error in insert before method", this.testing.includes(25));

  }

  @Test
  public void insertAfterTest() {
    // this appends method to avoid error and be sure that there is number 25
    this.testing.append(25);
    // let's insert number 6 after the 25 we created up
    this.testing.insertAfter(25, 6);
    // iterate until we have 25 * again all the random numbers are above 500, so we will not have 25 by accident
    Node<Integer> iter = this.testing.head;
    while (iter.value != 25) {
      iter = iter.nextPointer;
    }
    assertEquals("There was an error in insert after method", iter.nextPointer.value, (Integer) 6);
  }

  @Test
  public void deleteTest() {
    LinkedList<Integer> deleteTest = new LinkedList<>();
    deleteTest.insert(5);
    deleteTest.insert(2);
    deleteTest.insert(3);
    deleteTest.insert(6);
    deleteTest.insert(8);
    deleteTest.insert(9);
    assertTrue("Just Checking the append working", deleteTest.includes(8));
    // delete number 10
    deleteTest.delete(5);
    deleteTest.delete(6);
    // get the boolean if it is there
    boolean isItThere = deleteTest.includes(5);
    assertFalse("There was a problem in the delete method", isItThere);
    isItThere = deleteTest.includes(6);
    assertFalse("There was a problem in the delete method", isItThere);

  }

  @Test
  public void kthTest() {
    this.testing.append(5);   //3
    this.testing.append(3);   //2
    this.testing.append(7);   //1
    this.testing.append(2);   //0
    assertEquals("\nthere was an error in the kth method\n", this.testing.kthFromEnd(2), (Integer) 3);
  }

  @Test
  public void middleTest() {
    LinkedList<String> testString = new LinkedList<>();
    testString.insert("a"); //0
    testString.insert("b"); //1
    testString.insert("c"); //2
    testString.insert("d"); //3
    testString.insert("e"); //4 => middle
    testString.insert("f"); //5
    testString.insert("g"); //6
    testString.insert("h"); //7
    testString.insert("i"); //8
    assertEquals("\nthere was an error in the middle method\n", testString.middleNode(), "e");
  }

}
