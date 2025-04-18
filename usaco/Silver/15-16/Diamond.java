//this took forever
//we can use a two pointer approach to find the best amount of diamonds that can be stored
import java.io.*;
import java.util.*;
public class Diamond {
  static PrintWriter pw;
  static BufferedReader r;
  static String fileName="diamond";
  public static void main(String[] args) throws IOException {
    r = new BufferedReader(new FileReader(fileName+".in"));
    pw = new PrintWriter(fileName+".out");
    solve();
    r.close();
    pw.close();
  }
  static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());
    int[] list=new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(r.readLine());
      list[i]=Integer.parseInt(st.nextToken());
    }
    //bests stores the best number of diamonds that can be stored, given a largest diamond
    //bestleft stores the best amount of diamonds stored left of the current window
    int[] bests=new int[n];
    int bestleft=0;
    Arrays.sort(list);
    int ans=0, l=0, r=0;
    while (r!=n) {
      while (list[r]-list[l]>k) {
        bestleft=Math.max(bestleft, bests[l]);
        l++;
      }
      bests[r]=r-l+1;
      ans=Math.max(ans, bests[r]+bestleft);
      r++;
    } 
    pw.println(ans);
  }
}