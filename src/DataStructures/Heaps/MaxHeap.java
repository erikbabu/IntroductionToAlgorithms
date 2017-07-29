package DataStructures.Heaps;

public class MaxHeap<T extends Comparable> extends AbstractHeap<T> {

  public MaxHeap(T[] elements) {
    super(elements);
  }

  public MaxHeap() {
    super();
  }

  @Override
  @SuppressWarnings("unchecked")
  void heapify(int current, int heapSize) {
    while (!isLeaf(current, heapSize)) {
      //determine larger child
      int larger = getLeft(current);

      if (larger + 1 < heapSize && elements[larger].compareTo
          (elements[larger + 1]) < 0) {
        larger++;
      }

      int largest = (elements[larger].compareTo(elements[current]) > 0) ?
          larger : current;

      if (largest == current) {
        return;
      }

      swap(current, largest);
      current = largest;
    }
  }
}
