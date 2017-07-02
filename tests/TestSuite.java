import org.junit.Test;
import org.junit.Assert;

public class TestSuite {

  @Test
  public void insertionSortIntegers() {
    Integer arr[] = {0, 5, 1, -5, 4, 20, 3, 6, 6};
    SortingLibrary.insertionSort(arr);
    Integer expectedResult[] = {-5, 0, 1, 3, 4, 5, 6, 6, 20};
    Assert.assertArrayEquals(expectedResult, arr);
  }

  @Test
  public void insertionSortCharacters() {
    Character arr[] = {'x', 'b', 'a', 'd', 'c', 'p', 's', 'l', 'l', 'g', 'i',
        'z'};
    SortingLibrary.insertionSort(arr);
    Character expectedResult[] = {'a', 'b', 'c', 'd', 'g', 'i', 'l', 'l',
        'p', 's', 'x',
        'z'};
    Assert.assertArrayEquals(expectedResult, arr);
  }

  @Test
  public void insertionSortStrings() {
    String arr[] = {"Bravo", "Alpha", "Delta", "Albert", "Zebra", "Yellow",
        "Yellows"};
    SortingLibrary.insertionSort(arr);
    String expectedResult[] = {"Albert", "Alpha", "Bravo", "Delta", "Yellow",
        "Yellows", "Zebra"};
    Assert.assertArrayEquals(expectedResult, arr);
  }

  @Test
  public void selectionSortIntegers() {
    Integer arr[] = {0, 5, 1, -5, 4, 20, 3, 6, 6};
    SortingLibrary.selectionSort(arr);
    Integer expectedResult[] = {-5, 0, 1, 3, 4, 5, 6, 6, 20};
    Assert.assertArrayEquals(expectedResult, arr);
  }

  @Test
  public void selectionSortCharacters() {
    Character arr[] = {'x', 'b', 'a', 'd', 'c', 'p', 's', 'l', 'l', 'g', 'i',
        'z'};
    SortingLibrary.selectionSort(arr);
    Character expectedResult[] = {'a', 'b', 'c', 'd', 'g', 'i', 'l', 'l',
        'p', 's', 'x',
        'z'};
    Assert.assertArrayEquals(expectedResult, arr);
  }

  @Test
  public void selectionSortStrings() {
    String arr[] = {"Bravo", "Alpha", "Delta", "Albert", "Zebra", "Yellow",
        "Yellows"};
    SortingLibrary.selectionSort(arr);
    String expectedResult[] = {"Albert", "Alpha", "Bravo", "Delta", "Yellow",
        "Yellows", "Zebra"};
    Assert.assertArrayEquals(expectedResult, arr);
  }

  @Test
  public void mergeSortIntegers() {
    Integer arr[] = {0, 5, 1, -5, 4, 20, 3, 6, 6};
    SortingLibrary.mergeSort(arr);
    Integer expectedResult[] = {-5, 0, 1, 3, 4, 5, 6, 6, 20};
    Assert.assertArrayEquals(expectedResult, arr);
  }

  @Test
  public void mergeSortCharacters() {
    Character arr[] = {'x', 'b', 'a', 'd', 'c', 'p', 's', 'l', 'l', 'g', 'i',
        'z'};
    SortingLibrary.mergeSort(arr);
    Character expectedResult[] = {'a', 'b', 'c', 'd', 'g', 'i', 'l', 'l',
        'p', 's', 'x',
        'z'};
    Assert.assertArrayEquals(expectedResult, arr);
  }

  @Test
  public void mergeSortStrings() {
    String arr[] = {"Bravo", "Alpha", "Delta", "Albert", "Zebra", "Yellow",
        "Yellows"};
    SortingLibrary.mergeSort(arr);
    String expectedResult[] = {"Albert", "Alpha", "Bravo", "Delta", "Yellow",
        "Yellows", "Zebra"};
    Assert.assertArrayEquals(expectedResult, arr);
  }
}