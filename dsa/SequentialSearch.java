//sequential search - O(n) time
public class SequentialSearch {
  public static void main(String[] args) {
    int[] a={-1,0,3,5,9,12};
    System.out.println(sequentialSearch(a, 9));
    System.out.println(sequentialSearch(a, 70));
  }
  public static int sequentialSearch(int[] a, int target) {
    //returns index of target or -1
    int n=a.length;
    for (int i=0; i<n; i++) {
      if (a[i]==target) {
        return i;
      }
    }
    return -1;
  }
}
