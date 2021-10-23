package linked.list;

import org.junit.Test;

import static org.junit.Assert.*;


// this class conatain all the method inside the App class
public class AppTest {
  @Test
  public void zipListsTest() {
    LinkedList<Integer> testingList = new LinkedList<>();
    LinkedList<Integer> anotherList = new LinkedList<>();
    LinkedList<Integer> fullList = new LinkedList<>();
    for (int i = 0; i < 20; i++) {
      testingList.insert(i);
      fullList.insert(i * 5);
      fullList.insert(i);
      anotherList.insert(i * 5);

    }
    LinkedList<Integer> mergedList = new App<Integer>().zipLists(testingList, anotherList);
    assertEquals("There was an error in the zipLists method", fullList.toString(), mergedList.toString());
  }

  @Test
  public void zipListSortTest() {
    LinkedList<Integer> testingList = new LinkedList<>();
    LinkedList<Integer> anotherList = new LinkedList<>();
    LinkedList<Integer> fullList = new LinkedList<>();
    testingList.insert(10);
    testingList.insert(13);
    testingList.insert(17);
    testingList.insert(18);
    //==============
    anotherList.insert(11);
    anotherList.insert(13);
    anotherList.insert(20);
    //==============
    fullList.insert(20);
    fullList.insert(18);
    fullList.insert(17);
    fullList.insert(13);
    fullList.insert(11);
    fullList.insert(10);
    LinkedList<Integer> sortedList = new App<>().zipListSort(testingList, anotherList);
    assertEquals("There was an error in the zipListSort method", fullList.toString(), sortedList.toString());
  }

}
