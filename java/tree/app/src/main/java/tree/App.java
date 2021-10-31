/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tree;

public class App {


  public static void main(String[] args) {
    // this will run Binary Tree test for `$gradle run`
    binaryTree();
    // this will run Binary Search Tree test for `$gradle run`
    binarySearchTree();
  }


  public static void binaryTree() {
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
    /*                      My Tree
     *                        Root
     *                      /       \
     *                  Left         Right
     *                /   \         /     \
     *       leftLeaf  rightLeaf leftLeaf  rightLeaf
     */
    System.out.println("The Binary Tree Look like this now =>> \n" + binaryTree.toString());
    System.out.println("Pre Order Tree List  =>>  " + binaryTree.preOrder(root));
    System.out.println("In Order Tree List =>>  " + binaryTree.inOrder(root));
    System.out.println("Post Order Tree List =>>  " + binaryTree.postOrder(root));
  }

  public static void binarySearchTree() {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
    binarySearchTree.add(15);
    binarySearchTree.add(7);
    binarySearchTree.add(10);
    binarySearchTree.add(20);
    binarySearchTree.add(25);
    binarySearchTree.add(21);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    System.out.println("Now let's Define a Binary Search Tree (BST) and add some value to it =>> ");
    System.out.println(binarySearchTree.toString());
    System.out.println("Now let's see the BST in pre order format =>> " + binarySearchTree.preOrder(binarySearchTree.getRoot()));
    System.out.println("Let's see if the BST contains number 10 =>>" + binarySearchTree.contains(10));
    System.out.println("Let's see if the BST contains number 17 =>>" + binarySearchTree.contains(17));
    System.out.println("And if we try to add duplicate value it will give you an error \n");
    binarySearchTree.add(20);
    System.out.println("Let's see the maximum number for this tree => " + binarySearchTree.findMaximumValue().intValue());


  }
}