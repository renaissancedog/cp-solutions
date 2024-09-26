import java.util.*;
public class Quicksort {
  public static void main(String[] args) {
    int[] a={69,0,-27,3,420,21,12};
    quickSort(a, 0, a.length-1);
    System.out.println(Arrays.toString(a));
  } 
  static void quickSort(int array[], int low, int high) {
    if (low < high) {
      int pi = partition(array, low, high);
      quickSort(array, low, pi - 1);
      quickSort(array, pi + 1, high);
    }
  }
  static int partition(int array[], int low, int high) {
    int pivot = array[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      //compare each element with pivot
      if (array[j] <= pivot) {
        i++;
        //swap element i with element j
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    int temp = array[i + 1];
    //swap pivot with element greater than it
    array[i + 1] = array[high];
    array[high] = temp;
    //return partition point
    return (i + 1);
  } 
}
