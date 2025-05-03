import java.io.*;
import java.util.*;
public class FileIO {
  static PrintWriter pw;
  static BufferedReader r;
  static StringTokenizer st;
  static String fileName="paint";
  public static void main(String[] args) throws IOException {
    r = new BufferedReader(new FileReader(fileName+".in"));
    pw = new PrintWriter(fileName+".out");
    solve();
    r.close();
    pw.close();
  }
  static void solve() throws IOException {
    st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    pw.print(n+1);
  }
}