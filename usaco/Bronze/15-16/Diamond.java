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
    HashMap<Integer, Integer> map=new HashMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(r.readLine());
      int a=Integer.parseInt(st.nextToken());
      if (map.containsKey(a)) {
        map.put(a, map.get(a)+1);
      } else {
        map.put(a, 1);
      }
    }
    int ans=0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int locAns=0;
      int val=entry.getKey();
      for (int i=val; i<val+k+1; i++) {
        if (i>0) {
          locAns+=map.getOrDefault(i, 0);
        }
      }
      ans=Math.max(ans, locAns);
    }
    pw.print(ans);
  }
}