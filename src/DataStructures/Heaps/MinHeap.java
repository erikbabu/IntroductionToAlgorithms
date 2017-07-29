package DataStructures.Heaps;

public class MinHeap<T extends Comparable> extends AbstractHeap<T> {
  public MinHeap(T[] elements) {
    super(elements);
  }

  public MinHeap() {
    super();
  }

  @Override
  @SuppressWarnings("unchecked")
  void heapify(int current, int heapSize) {
    while (!isLeaf(current, heapSize)) {
      //determine smaller child
      int smaller = getLeft(current);

      if (smaller + 1 < heapSize && elements[smaller].compareTo
          (elements[smaller + 1]) > 0) {
        smaller++;
      }

      int smallest = (elements[smaller].compareTo(elements[current]) < 0) ?
          smaller : current;

      if (smallest == current) {
        return;
      }

      swap(current, smallest);
      current = smallest;
    }
  }
}
