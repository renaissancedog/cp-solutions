//binary search implementation
public class BinarySearch {
  public static void main(String[] args) {
    int[] a={-1,0,3,5,9,12};
    System.out.println(binarySearch(a, 12));
  } 
  public static int binarySearch(int[] nums, int target) {
    int lo = 0, hi = nums.length-1;
    while (lo < hi) {
        int mid = lo + ((hi-lo+1)/2);
        if (target < nums[mid]) {
            hi = mid - 1;
        } else {
            lo = mid; 
        }
    }
    if (nums[lo]==target) {
      return lo;
    }
    return -1;
  }
}
