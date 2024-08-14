//iterate thru all tuitions and find most optimal one
import java.io.*;
import java.util.*;
public class CowCollege {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int[] c=new int[n];
    st = new StringTokenizer(r.readLine());
    for (int i=0;i<n;i++) {
      int a=Integer.parseInt(st.nextToken());
      c[i]=a;    
    }
    Arrays.sort(c);
    long costAns=0,tuition=0;
    for (int i=0; i<c.length; i++) {
      long t=c[i]*(long)(n-i); //cast into long!!!
      if (t>costAns) {
        costAns=t;
        tuition=c[i];
      }
    }
    pw.print(costAns+" "+tuition);
    r.close();
    pw.close();
  }
}