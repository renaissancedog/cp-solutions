//not pretty but it works
import java.io.*;
import java.util.*;
public class Photoshoot {
  static int[] sums;
  static int n;
  static PrintWriter pw;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("photo.in"));
    pw = new PrintWriter("photo.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    n=Integer.parseInt(st.nextToken());
    sums=new int[n-1];
    st = new StringTokenizer(r.readLine());
    for (int i = 0; i < n-1; i++) {
      sums[i]=Integer.parseInt(st.nextToken());
    }
    //iterate through all possible starting values until one works
    for (int i = 1; i <= n; i++) {
      if (loop(i, false)!=null) {
        loop(i, true);
        break;
      }
    } 
    pw.close();
    r.close();
  }
  static Integer[] loop(int i, boolean print) { //if print is true, prints output
    HashSet<Integer> a=new HashSet<>();//keep track of all computed values
    int last=i;
    if (print) {
      pw.print(last+" ");
    }
    a.add(last);
    for (int j=0; j<n-1; j++) {
      int diff=sums[j]-last;//find what next value must be
      if (print) {
        pw.print(diff);
        if (j!=n-2) {
          pw.print(" ");
        }
      }
      if (diff>n||diff<=0) {//checks illegal values
        return null;
      }
      a.add(diff);
      last=diff;
    }
    if (a.size()==n) {//if all values are unique
      return a.toArray(new Integer[a.size()]);
    } else {
      return null;
    }
  }
  
}
