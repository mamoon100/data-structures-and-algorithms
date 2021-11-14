/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package selectionSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
  @Test
  public void selectionSortTest() {
    int[] array = {5, 4, 3, 2, 1};
    int[] expected = {1, 2, 3, 4, 5};
    App.selectionSort(array);
    assertArrayEquals(expected, array);
    // another test
    int[] array2 = {20, 18, 12, 8, 5, -2};
    int[] expected2 = {-2, 5, 8, 12, 18, 20};
    App.selectionSort(array2);
    assertArrayEquals(expected2, array2);
  }
}