import java.io.*;
import java.util.*;
public class CowCross1 {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("crossroad.in"));
    PrintWriter pw = new PrintWriter("crossroad.out");
    st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int ans=0;
    int[] side=new int[10];
    Arrays.fill(side,-1);
    //keeps track of cow side
    for (int i=0; i<n; i++) {
      st=new StringTokenizer(r.readLine());
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      if (b!=side[a-1]&&side[a-1]!=-1) {
        //if the cow changed sides
        ans++;
      }
      side[a-1]=b;
    }
    pw.print(ans);
    r.close();
    pw.close();
  }
}