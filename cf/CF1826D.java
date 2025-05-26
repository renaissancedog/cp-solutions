import java.io.*;
import java.util.*;
public class CF1826D {
  static PrintWriter pw;
  static BufferedReader r;
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    r = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(System.out);
    st=new StringTokenizer(r.readLine());
    int t=Integer.parseInt(st.nextToken());
    for (int i=0; i<t; i++) {
      solve();
    }
    pw.close();
    r.close();
  }
  static void solve() throws IOException {
    st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int ans=-1;
    int[] beauty=new int[n];
    st=new StringTokenizer(r.readLine());
    for (int i=0; i<n; i++) {
      beauty[i]=Integer.parseInt(st.nextToken());
    }
    int[] left=Arrays.copyOf(beauty, beauty.length);
    int[] right=Arrays.copyOf(beauty, beauty.length);
    for (int i=0; i<n; i++) {
      left[i]+=i;
      right[i]-=i;
    }
    for (int i=1; i<n-1; i++) {
      left[i]=Math.max(left[i], left[i-1]);
    }
    for (int i=n-2; i>=0; i--) {
      right[i]=Math.max(right[i], right[i+1]);
    }
    for (int i=1; i<n-1; i++) {
      ans=Math.max(ans, beauty[i]+left[i-1]+right[i+1]);
    }
    pw.println(ans);
  }
}
