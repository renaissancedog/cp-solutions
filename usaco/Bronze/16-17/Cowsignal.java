//brute force repeat all lines and chars
import java.io.*;
import java.util.*;
public class Cowsignal {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("cowsignal.in"));
    PrintWriter pw = new PrintWriter("cowsignal.out");
    st = new StringTokenizer(r.readLine()); 
    int n=Integer.parseInt(st.nextToken());
    int m=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());
    String[] sign=new String[n];
    for (int i=0; i<n; i++) {
      st = new StringTokenizer(r.readLine()); 
      sign[i]=st.nextToken();
    }
    for (int i=0; i<n; i++) {
      for (int j2 = 0; j2< k; j2++) {
        //runs each line k times
        String line=sign[i];
        for (int j=0; j<m; j++) {
          for (int l=0; l<k; l++) {
            //also runs each char k times
            pw.print(line.charAt(j));
          }
        }
        pw.print("\n");
      }
    }
    r.close();
    pw.close();
  }
}