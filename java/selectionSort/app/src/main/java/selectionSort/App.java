/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package selectionSort;

import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    int[] ints;
    int[] ints2;
    System.out.println("==========================Selection Sort============================");
    ints = randomArray();
    ints2 = randomArray();
    System.out.println("Let's Try To Sort this Array =>> " + Arrays.toString(ints));
    selectionSort(ints);
    System.out.println("Sorted Array in selection Sort method =>> " + Arrays.toString(ints));
    System.out.println("Let's Try To Sort this Array =>> " + Arrays.toString(ints2));
    selectionSort(ints2);
    System.out.println("Sorted Array in selection Sort method =>> " + Arrays.toString(ints2));
    System.out.println("==========================Merge Sort============================");
    ints = randomArray();
    ints2 = randomArray();
    System.out.println("Let's Try To Sort this Array =>> " + Arrays.toString(ints));
    mergeSort(ints);
    System.out.println("Sorted Array in Merge Sort method =>> " + Arrays.toString(ints));
    System.out.println("Let's Try To Sort this Array =>> " + Arrays.toString(ints2));
    mergeSort(ints2);
    System.out.println("Sorted Array in Merge Sort method =>> " + Arrays.toString(ints2));
    System.out.println("==========================Insertion Sort============================");
    ints = randomArray();
    ints2 = randomArray();
    System.out.println("Let's Try To Sort this Array =>> " + Arrays.toString(ints));
    insertionSort(ints);
    System.out.println("Sorted Array in Insertion Sort method =>> " + Arrays.toString(ints));
    System.out.println("Let's Try To Sort this Array =>> " + Arrays.toString(ints2));
    insertionSort(ints2);
    System.out.println("Sorted Array in Insertion Sort method =>> " + Arrays.toString(ints2));
    System.out.println("==========================Quick Sort============================");
    ints = randomArray();
    ints2 = randomArray();
    System.out.println("Let's Try To Sort this Array =>> " + Arrays.toString(ints));
    quickSort(ints, 0, ints.length - 1);
    System.out.println("Sorted Array in Quick Sort method =>> " + Arrays.toString(ints));
    System.out.println("Let's Try To Sort this Array =>> " + Arrays.toString(ints2));
    quickSort(ints2, 0, ints2.length - 1);
    System.out.println("Sorted Array in Quick Sort method =>> " + Arrays.toString(ints2));
    
  }

  // generate random array of 10 elements with numbers between 0 and 100
  public static int[] randomArray() {
    int[] array = new int[10];
    for (int i = 0; i < array.length; i++) {
      array[i] = (int) (Math.random() * 100);
    }
    return array;
  }


  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
      }
      int temp = array[i];
      array[i] = array[min];
      array[min] = temp;
    }
  }

  public static void mergeSort(int[] arr) {
    int length = arr.length;
    if (length > 1) {
      int mid = length / 2;
      int[] left = Arrays.copyOfRange(arr, 0, mid);
      int[] right = Arrays.copyOfRange(arr, mid, length);
      mergeSort(left);
      mergeSort(right);
      merge(left, right, arr);
    }

  }


  public static void merge(int[] left, int[] right, int[] arr) {
    int i = 0, j = 0, k = 0;
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
    while (i < left.length) {
      arr[k++] = left[i++];
    }
    while (j < right.length) {
      arr[k++] = right[j++];
    }
  }

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int j = i - 1;
      int temp = arr[i];
      while (j >= 0 && temp < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = temp;
    }
  }

  public static void quickSort(int[] arr, int left, int right) {
    if (left < right) {
      int position = partition(arr, left, right);
      quickSort(arr, left, position - 1);
      quickSort(arr, position + 1, right);
    }
  }

  public static int partition(int[] arr, int left, int right) {
    int pivot = arr[right];
    int low = left - 1;
    for (int i = left; i < right; i++) {
      if (arr[i] <= pivot) {
        low++;
        swap(arr, i, low);
      }
    }
    swap(arr, right, low + 1);
    return low + 1;
  }


  public static void swap(int[] arr, int i, int low) {
    int temp = arr[i];
    arr[i] = arr[low];
    arr[low] = temp;
  }
}
