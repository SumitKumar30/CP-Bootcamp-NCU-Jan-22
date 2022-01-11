import java.util.*;
import java.util.stream.IntStream;
public class BubbleSortAnalysis{

    // perform the bubble sort
  static void bubbleSort(int array[]) {
    int size = array.length;
    
    // loop to access each array element
    for (int i = 0; i < size - 1; i++)
    
      // loop to compare array elements
      for (int j = 0; j < size - i - 1; j++)

        // compare two adjacent elements
        // change > to < to sort in descending order
        if (array[j] > array[j + 1]) {

          // swapping occurs if elements
          // are not in the intended order
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
  }    

  // Optimized Bubble Sort - using flag variable
  static void optimizedBubbleSort(int array[]) {
    int size = array.length;
    
    // loop to access each array element
    for (int i = 0; i < (size-1); i++) {
    
      // check if swapping occurs
      boolean swapped = false;
      
      // loop to compare adjacent elements
      for (int j = 0; j < (size-i-1); j++) {

        // compare two array elements
        // change > to < to sort in descending order
        if (array[j] > array[j + 1]) {

          // swapping occurs if elements
          // are not in the intended order
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          
          swapped = true;
        }
      }
      // no swapping means the array is already sorted
      // so no need for further comparison
      if (!swapped)
        break;

    }
  }

  private static int[] buildArray(int size) {
    Random random = new Random();
    return IntStream.range(0, size).map(i -> random.nextInt(1000000)).toArray();
  }

  private static void measurePerformance(int[] input) {
    for (int i = 0; i < 10; i++) {
      int[] newArray = Arrays.copyOf(input, input.length);
      long start = System.nanoTime();
      BubbleSortAnalysis.optimizedBubbleSort(newArray);
      long end = System.nanoTime();
      System.out.println("Sorting took " + (end - start) / 1000000f + " ms ");
    }
  }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n = sc.nextInt();
    measurePerformance(buildArray(n));
    }
}