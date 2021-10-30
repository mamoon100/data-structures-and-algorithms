package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

  @Test
  public void binarySearchTreeTest() {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
    binarySearchTree.add(15);
    binarySearchTree.add(7);
    binarySearchTree.add(10);
    binarySearchTree.add(20);
    binarySearchTree.add(25);
    binarySearchTree.add(21);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    assertEquals("There was problem in error or the initialize method on BST", binarySearchTree.getRoot().getValue(), (Integer) 15);
    assertTrue("There was an error in contains method", binarySearchTree.contains(21));
    assertFalse("There was an error in contains method", binarySearchTree.contains(22));
    ArrayList<Integer> preOrder = new ArrayList<>(Arrays.asList(15, 7, 3, 6, 10, 20, 25, 21));
    assertEquals("There was a problem in pre order with BST", binarySearchTree.preOrder(binarySearchTree.getRoot()), preOrder);
  }
}
