//bubble sort implementation
import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    int[] a={69,0,-27,3,420,21,12};
    System.out.println(Arrays.toString(bubbleSort(a)));
  } 
  public static int[] bubbleSort(int[] a) {
    int n=a.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j]=a[j+1];
          a[j+1]=temp;
        }
      } 
    }
    return a;
  }
}