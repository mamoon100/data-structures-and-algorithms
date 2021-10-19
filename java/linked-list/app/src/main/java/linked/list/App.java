/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linked.list;


import java.util.Arrays;

public class App<T> {

  public static void main(String[] args) {
    LinkedList<Integer> testing = new LinkedList<>();
    System.out.println(testing.length);
    System.out.println("The head when initialize new linked List is:  =>  " + testing.head);
    System.out.println("Adding {1,2,3,0,5,6,9,8} to the linked list");
    int[] inserted = {1, 2, 3, 0, 5, 6, 9, 8};
//    adding the number to linked list
    for (int num : inserted) testing.insert(num);
    System.out.println("now let's print the string method");
    System.out.println(testing.toString());
    System.out.println("let's check if it include number 5");
    System.out.println(testing.includes(5));
    System.out.println("let's check if it include number 10");
    System.out.println(testing.includes(10));
    System.out.println("Let's append number 15 to the linked list");
    testing.append(15);
    System.out.println(testing.toString());
    System.out.println("Let's add Number 7 before the 5 Value");
    testing.insertBefore(5, 7);
    System.out.println(testing.toString());
    System.out.println("Now let's add Number 11 after number 2");
    testing.insertAfter(2, 11);
    System.out.println(testing.toString());
    System.out.println("let's delete number 3");
    testing.delete(3);
    System.out.println(testing.toString());
    System.out.print("let's test for determine the length from the tail to index 3 =>> ");
    System.out.println(testing.kthFromEnd(3));
    System.out.println("let's now test the middle method =>> " + testing.middleNode());
    System.out.println("now let's create another linked list =>> ");
    LinkedList<Integer> anotherList = new LinkedList<>();
    //inserting sorted node into linked list

    for (int i = 50; i < 90; i += 10) anotherList.insert(i);
    System.out.println(testing.toString());
    System.out.println(anotherList.toString());
    System.out.println("Now let's merge the both linked list together =>");
    System.out.println(new App<Integer>().zipLists(testing, anotherList).toString());
    LinkedList<Integer> sortedList = new LinkedList<>();
    for (int i = 0; i < 100; i += 5) sortedList.insert(i);
    System.out.println("we created a new sorted list with this value =>> \n" + sortedList.toString());
    System.out.println("and the we need to merge it and sorted with this => \n" + anotherList.toString());
    System.out.println("Now after margined and sorted it =>> ");
    System.out.println(new App<Integer>().zipListSort(anotherList, sortedList).toString());
  }


  public LinkedList<T> zipLists(LinkedList<T> list1, LinkedList<T> list2) {
    Node<T> pointer1 = list1.head;
    Node<T> pointer2 = list2.head;
    LinkedList<T> list = new LinkedList<>();
    for (int i = 0; i < (Math.max(list1.length, list2.length)); i++) {
      if (pointer1 != null) {
        list.append(pointer1.value);
        pointer1 = pointer1.nextPointer;
      }
      if (pointer2 != null) {
        list.append(pointer2.value);
        pointer2 = pointer2.nextPointer;
      }
    }
    return list;
  }

  // the sorting method only work with Integer
  public LinkedList<Integer> zipListSort(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    Node<Integer> pointer1 = list1.head;
    Node<Integer> pointer2 = list2.head;
    LinkedList<Integer> list = new LinkedList<>();
    int count = 0;
    while (count < list1.length + list2.length) {
      if (pointer1.value > pointer2.value) {
        list.insert(pointer1.value);
        // to prevent null when list length is bigger than the other
        if (pointer1.nextPointer != null) pointer1 = pointer1.nextPointer;
        else pointer1.value = Integer.MIN_VALUE;
      } else if (pointer2.value > pointer1.value) {
        list.insert(pointer2.value);
        // to prevent null when list length is bigger than the other
        if (pointer2.nextPointer != null) pointer2 = pointer2.nextPointer;
        else pointer2.value = Integer.MIN_VALUE;
      } else { // to prevent stuck on equal value1==value2
        // to prevent null when getting next pointer
        if (pointer1.nextPointer != null) pointer1 = pointer1.nextPointer;
        else pointer2 = pointer2.nextPointer;
      }
      count++;
    }
    return list;
  }
}
