//fairly simple, keep track of # of days from outbreak, check for discrepancies
//count # of 0's as lo and add # of -1's as hi
import java.io.*;
import java.util.*;
public class TamingHerd {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("taming.in"));
    PrintWriter pw = new PrintWriter("taming.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int[] log=new int[n];
    int lo=0, hi=0;
    st = new StringTokenizer(r.readLine());
    for (int i=0; i<n; i++) {
      log[i]=Integer.parseInt(st.nextToken());
    }
    loop:
    for (int i=0; i<n; i++) {
      if (log[i]>0) {
        for (int j=i; j>=0; j--) {
          if (log[j]>-1&&log[j]!=log[i]-(i-j)) {
            pw.print(-1);
            pw.close();r.close();
            return;
          }
          if (log[0]>0) {
            pw.print(-1);
            pw.close();r.close();
            return;
          }
          log[j]=log[i]-(i-j);
          if (log[j]==0) {
            continue loop;
          }
        }
      }
    }
    log[0]=0;
    for (int i:log) {
      if (i==-1) {
        hi++;
      }
      if (i==0) {
        hi++;
        lo++;
      }
    }
    pw.println(lo+" "+hi);
    r.close();
    pw.close();
  }
}