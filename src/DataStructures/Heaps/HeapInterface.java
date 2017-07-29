package DataStructures.Heaps;



public interface HeapInterface<T extends Comparable> {

  void buildHeap();

  T extract();

  T peek();

  void insert(T item);

  boolean isEmpty();

  int size();

  void heapSort();
}
