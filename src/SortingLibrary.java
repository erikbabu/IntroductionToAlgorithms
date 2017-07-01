import java.util.stream.IntStream;

public class SortingLibrary {

  //Generic implementation of Insertion Sort
  public static <T extends Comparable<T>> void insertionSort(T[] arr) {
    long startTime = System.nanoTime();

    for (int i = 1; i < arr.length; i++) {
      T key = arr[i];
      //j is current index array is sorted up to
      int j = i - 1;
      //locate index to insert the key
      while (j >= 0 && arr[j].compareTo(key) > 0) {
        //sift from right to left to find insertion index
        arr[j + 1] = arr[j--];
      }
      //insert key at correct index
      arr[++j] = key;
    }
    //measures and outputs total time taken for sort in us
    long totalTime = (System.nanoTime() - startTime) / 1000;
    System.out.println("Total time: " + totalTime + " microseconds");
  }

  //Generic implementation of Selection Sort
  public static <T extends Comparable<T>> void selectionSort(T[] arr) {
    long startTime = System.nanoTime();
    //only needs to loop up to n - 1 because it will be sorted at that point
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j].compareTo(arr[minIndex]) < 0) {
          minIndex = j;
        }
      }
      //swap values
      T temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
    //measures and outputs total time taken for sort in us
    long totalTime = (System.nanoTime() - startTime) / 1000;
    System.out.println("Total time: " + totalTime + " microseconds");
  }

  //Generic implementation of Merge Sort
  public static <T extends Comparable<T>> void mergeSort(T[] arr) {
    long startTime = System.nanoTime();

    //call helper with initial indices
    mergeSortHelper(arr, 0, arr.length - 1);

    //measures and outputs total time taken for sort in us
    long totalTime = (System.nanoTime() - startTime) / 1000;
    System.out.println("Total time: " + totalTime + " microseconds");
  }

  private static <T extends Comparable<T>> void mergeSortHelper(T[] arr, int p
      , int r) {
    if (p < r) {
      int q = (int) Math.floor((p + r) / 2);
      //partition arr into 2 sub arrays
      mergeSortHelper(arr, p, q);
      mergeSortHelper(arr, q + 1, r);
      //merge the pairs of sequences
      merge(arr, p, q, r);
    } //else
    //subarray has at most 1 element and is already sorted
  }

  //helper method to merge subarrays into a single sorted subarray
  //PRE: arr[p..q] && arr[q+1..r] are sorted
  @SuppressWarnings("unchecked")
  private static <T extends Comparable<T>>  void merge(T[] arr, int p, int q,
                            int r) {
    assert (p <= q && q < r) : "Invariant p <= q < r violated";

    //n1 is length of subarray arr[p..q]
    int n1 = q - p + 1;
    //n2 is length of subarray arr[q+1..r]
    int n2 = r - q;

    //declare arrays to store sub arrays
    T[] leftArr = (T[]) new Comparable[n1];
    T[] rightArr = (T[]) new Comparable[n2];

    //copy arr[p.q] into leftArr
    IntStream.range(0, n1).forEach(i -> leftArr[i] = arr[p + i]);

    //copy arr[q+1..r] into rightArr
    IntStream.range(0, n2).forEach(j -> rightArr[j] = arr[(q + 1) + j]);

    int i = 0;
    int j = 0;
    int k = p;
    while (i != n1 && j != n2) {
      //update the array at index k with the smaller of the left and right array
      arr[k++] = (leftArr[i].compareTo(rightArr[j]) <= 0) ? leftArr[i++] :
          rightArr[j++];
    }

    //stop once either L or R has had all its elements copied back to A
    //copy remainder of other array back to A
    if (i == n1) {
      while (j < n2) {
        arr[k++] = rightArr[j++];
      }
    }

    if (j == n2) {
      while (i < n1) {
        arr[k++] = leftArr[i++];
      }
    }
  }
}
