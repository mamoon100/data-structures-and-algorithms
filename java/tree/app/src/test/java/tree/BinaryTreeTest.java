package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BinaryTreeTest {

  @Test
  public void binaryTreeTest() {
    BinaryTree<String> binaryTree = new BinaryTree<>();
    Node<String> root = new Node<>("Root");
    binaryTree.setRoot(root);
    Node<String> leftRoot = new Node<>("Left");
    Node<String> rightRoot = new Node<>("Right");
    root.setLeftChild(leftRoot);
    root.setRightChild(rightRoot);
    Node<String> leftLeftLeaf = new Node<>("Left Left Leaf");
    Node<String> rightLeftLeaf = new Node<>("Right Left Leaf");
    leftRoot.setLeftChild(leftLeftLeaf);
    leftRoot.setRightChild(rightLeftLeaf);
    Node<String> leftRightLeaf = new Node<>("Left Right Leaf");
    Node<String> rightRightLeaf = new Node<>("Right Right Leaf");
    rightRoot.setRightChild(rightRightLeaf);
    rightRoot.setLeftChild(leftRightLeaf);
    ArrayList<String> preOrder = new ArrayList<>(Arrays.asList("Root", "Left", "Left Left Leaf", "Right Left Leaf", "Right", "Left Right Leaf", "Right Right Leaf"));
    ArrayList<String> inOrder = new ArrayList<>(Arrays.asList("Left Left Leaf", "Left", "Right Left Leaf", "Root", "Left Right Leaf", "Right", "Right Right Leaf"));
    ArrayList<String> postOrder = new ArrayList<>(Arrays.asList("Left Left Leaf", "Right Left Leaf", "Left", "Left Right Leaf", "Right Right Leaf", "Right", "Root"));
    ArrayList<String> breadthFirst = new ArrayList<>(Arrays.asList("Root", "Left", "Right", "Left Left Leaf", "Right Left Leaf", "Left Right Leaf", "Right Right Leaf"));
    ArrayList<String> breadthFirstTest = new App<String>().breadthFirst(binaryTree);
    assertEquals("There was an error in the initialization and the root of the tree", binaryTree.getRoot().getValue(), "Root");
    assertEquals("There was an error in left child", binaryTree.getRoot().getLeftChild().getValue(), "Left");
    assertEquals("There was an error in left child", binaryTree.getRoot().getRightChild().getValue(), "Right");
    assertEquals("There was an error in the pre order method", binaryTree.preOrder(root), preOrder);
    assertEquals("There was an error in the in order method", binaryTree.inOrder(root), inOrder);
    assertEquals("There was an error in the post order method", binaryTree.postOrder(root), postOrder);
    assertEquals("There was an error in the breadth first method in the app", breadthFirst, breadthFirstTest);
    assertNull("There was an error in find max value when binary tree is empty", new BinaryTree<Integer>().findMaximumValue());
  }
}
