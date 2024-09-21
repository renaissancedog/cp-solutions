import java.util.*;
public class InsertionSort {
  public static void main(String[] args) {
    int[] a={69,0,-27,3,420,21,12};
    System.out.println(Arrays.toString(insertionSort(a)));
  } 
  public static int[] insertionSort(int[] a) {
    for (int i=1; i<a.length; i++) {
      int j=i;
      while (j>0&&a[j-1]>a[j]) {
        //swap a[j] and a[j-1]
        int temp=a[j];
        a[j]=a[j-1];
        a[j-1]=temp;
        j--; 
      }
    }
    return a;
  }
}
