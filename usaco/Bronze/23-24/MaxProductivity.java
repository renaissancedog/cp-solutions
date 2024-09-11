//Solved this by finding difference btw closing time and Bessie's planned visit time
import java.io.*;
import java.util.*;
public class MaxProductivity {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
    int[] data=new int[n];
    st = new StringTokenizer(r.readLine());
    for (int i=0; i<n; i++) {
      data[i]=Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(r.readLine());
    for (int i=0; i<n; i++) {
      data[i]-=Integer.parseInt(st.nextToken());
    }
    Arrays.sort(data);
    for (int i=0; i<q; i++) {
      st = new StringTokenizer(r.readLine());
      int v=Integer.parseInt(st.nextToken()), s=Integer.parseInt(st.nextToken());
      //if Bessie can't get to her biggest 'stretch' of a farm in time, she fails
      //if she can, she succeeds
      int z=data[n-v];
      if (z>s) {
        pw.println("YES");
      } else {
        pw.println("NO");
      }
    }
    r.close();
    pw.close();
  }
}