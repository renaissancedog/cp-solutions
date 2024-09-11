//simulate all possible doors
import java.io.*;
import java.util.*;
public class CircularBarn {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("cbarn.in"));
    PrintWriter pw = new PrintWriter("cbarn.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int[] rooms=new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(r.readLine());
      rooms[i]=Integer.parseInt(st.nextToken());
    }
    int ans=Integer.MAX_VALUE;
    for (int i=0; i<n; i++) {
      int count=i;
      int localans=0;
      for (int j=0;j<n;j++) {
        localans+=rooms[count]*j;
        count++;
        if (count==n) {count=0;}
      }
      ans=Math.min(ans, localans);
    }
    pw.print(ans);
    pw.close();
    r.close();
  }
}