import java.util.*;
public class MergeSort {
  public static void main(String[] args) {
    int[] a={69,0,-27,3,420,21,12};
    System.out.println(Arrays.toString(mergeSort(a)));
  }  
  static int[] mergeSort(int[] a) {
    int len=a.length;
    if (len==1) {
      return a;
    }
    int mid = len/2;
    int[] left = mergeSort(Arrays.copyOfRange(a, 0, mid));
    int[] right = mergeSort(Arrays.copyOfRange(a, mid, len));
    return merge(left, right);
  }
  static int[] merge(int[] a, int[] b) {
    int[] out = new int[a.length+b.length];
    int i=0, j=0, counter=0;
    while (i<a.length&&j<b.length) {
      if (a[i] < b[j]) {
        out[counter]=a[i];
        i++;
      } else {
        out[counter]=b[j];
        j++;
      }
      counter++;
    }
    // Copy remaining elements from one of the arrays as one will not have been fully copied 
    while (i < a.length) {
      out[counter] = a[i];
      i++;
      counter++;
    }
    
    while (j < b.length) {
      out[counter] = b[j];
      j++;
      counter++;
    }
    return out;
  }
}
