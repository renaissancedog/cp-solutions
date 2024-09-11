//pretty ez, just tried cases until i found the pattern

import java.io.*;
import java.util.*;
public class PalindromeGame {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    for (int i=0; i<n; i++) {
      st = new StringTokenizer(r.readLine());
      String t=(st.nextToken());
      if (t.charAt(t.length()-1)=='0') {
        pw.println("E");
      } else {
        pw.println("B");
      }
      
    }
    r.close();
    pw.close();
  }
}
