//binary search
import java.io.*;
import java.util.*;
public class CountingHaybales {
  static PrintWriter pw;
  static BufferedReader r;
  static StringTokenizer st;
  static String fileName="haybales";
  public static void main(String[] args) throws IOException {
    r = new BufferedReader(new FileReader(fileName+".in"));
    pw = new PrintWriter(fileName+".out");
    solve();
    pw.close();
    r.close();
  }
  static void solve() throws IOException {
    st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int q=Integer.parseInt(st.nextToken());
    int[] loc=new int[n];
    st=new StringTokenizer(r.readLine());
    for (int i=0; i<n; i++) {
      loc[i]=Integer.parseInt(st.nextToken());
    }
    Arrays.sort(loc);
    for (int i=0; i<q; i++) {
      st=new StringTokenizer(r.readLine());
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      //find leftmost bale in [a,b] and rightmost bale in [a,b]
      int rIndex=Arrays.binarySearch(loc, b);
      int lIndex=Arrays.binarySearch(loc, a);
      //annoying casework
      if (rIndex<0) { rIndex=Math.abs(rIndex+2); } 
      if (lIndex<0) { lIndex=Math.abs(lIndex+1); }
      pw.println(rIndex-lIndex+1);
    } 
  }
}
