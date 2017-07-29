package DataStructures.Heaps;

public abstract class AbstractHeap<T extends Comparable> implements HeapInterface<T> {
  protected final T[] elements;
  protected int size;
  protected final static int MAX_SIZE = 100;

  @SuppressWarnings("unchecked")
  public AbstractHeap(T[] elements) {
    this.elements = elements;
    this.size = elements.length;
  }

  @SuppressWarnings("unchecked")
  public AbstractHeap() {
    this.elements = (T[]) new Comparable[MAX_SIZE];
    this.size = 0;
  }

  int getParent(int index) {
    if (index >= 1) {
      return (index - 1) / 2;
    }

    throw new UnsupportedOperationException("No parent for root node");
  }

  int getLeft(int index) {
    if (index < size / 2 && index < size()) {
      return 2 * index + 1;
    }
    throw new UnsupportedOperationException("No children for leaf nodes");

  }

  boolean isLeaf(int index, int heapSize) {
    return (index >= heapSize / 2 && index < heapSize);
  }

  void swap(int i, int j) {
    T temp = elements[i];
    elements[i] = elements[j];
    elements[j] = temp;
  }

  @Override
  public void buildHeap() {
    for (int i = (size() / 2) - 1; i >= 0; i--) {
      heapify(i, size());
    }
  }

  abstract void heapify(int current, int heapSize);

  @Override
  public T extract() {
    if (isEmpty()) {
      return null;
    }

    swap(0, size() - 1);
    T toReturn = elements[--size];
    buildHeap();
    return toReturn;
  }

  @Override
  public T peek() {
    return (isEmpty()) ? null : elements[0];
  }

  @Override
  public void insert(T item) {
    if (size() >= MAX_SIZE) {
      throw new ArrayStoreException("Error. Heap is full");
    }
    elements[size++] = item;
    buildHeap();
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < size(); i++) {
      sb.append(elements[i]);
      if (i < size() - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  @Override
  public void heapSort() {
    buildHeap();
    for (int i = size() - 1; i > 0; i--) {
      swap(0, i);
      heapify(0, i);
    }
  }
}
