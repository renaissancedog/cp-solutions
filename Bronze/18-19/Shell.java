import java.io.*;
import java.util.*;
public class Shell {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("shell.in"));
    PrintWriter pw = new PrintWriter("shell.out");
    st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int[] pebbles={1,2,3};
    int[] ans=new int[3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(r.readLine());
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      int g=Integer.parseInt(st.nextToken());
      int cache=pebbles[a-1];
      pebbles[a-1]=pebbles[b-1];
      pebbles[b-1]=cache;
      int guess=pebbles[g-1];
      ans[guess-1]++;
    }
    pw.print(Math.max(Math.max(ans[0],ans[1]),ans[2]));
    r.close();
    pw.close();
  }
}