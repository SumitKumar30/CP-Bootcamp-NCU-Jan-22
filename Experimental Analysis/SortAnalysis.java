/* Experimental analysis of soring algorithms using nanoTime()
1. Insertion Sort
2. Bubble Sort
3. Quick Sort */
import java.util.*;
import java.util.stream.IntStream;

public class SortAnalysis {

  public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  static void bubbleSort(int array[]) {
    int size = array.length;

    // loop to access each array element
    for (
      int i = 0;
      i < size - 1;
      i++
    ) for ( // loop to compare array elements
      int j = 0;
      j < size - i - 1;
      j++
    ) // change > to < to sort in descending order // compare two adjacent elements
    if (array[j] > array[j + 1]) {
      // swapping occurs if elements
      // are not in the intended order
      int temp = array[j];
      array[j] = array[j + 1];
      array[j + 1] = temp;
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }

  private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int p = partition(arr, low, high);

      quickSort(arr, low, p - 1);
      quickSort(arr, p + 1, high);
    }
  }

  public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private static int[] buildArray(int size) {
    Random random = new Random();
    return IntStream.range(0, size).map(i -> random.nextInt(1000000)).toArray();
  }

  private static void measurePerformance(int[] input) {
    for (int i = 0; i < 10; i++) {
      int[] newArray = Arrays.copyOf(input, input.length);
      long start = System.nanoTime();
      SortAnalysis.quickSort(newArray);
      long end = System.nanoTime();
      System.out.println("Sorting took " + (end - start) / 1000000f + " ms ");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n = sc.nextInt();
    measurePerformance(buildArray(n));
  }
}
