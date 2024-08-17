//created an array of buckets
//counted buckets needed at any given time
//then found max
import java.io.*;
import java.util.*;
public class Bucketlist {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("blist.in"));
    PrintWriter pw = new PrintWriter("blist.out");
    st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int[] buckets=new int[1000]; //index 0 is time 1
    for (int i=0;i<n;i++) {
      st=new StringTokenizer(r.readLine());
      int s=Integer.parseInt(st.nextToken());
      int t=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      for (int j=s-1; j<t-1; j++) {
        buckets[j]+=b;
      }
    }
    int ans=-1;
    for (int b:buckets) {
      ans=Math.max(ans, b);
    }
    pw.print(ans);
    r.close();
    pw.close();
  }
}