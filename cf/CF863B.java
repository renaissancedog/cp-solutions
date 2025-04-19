//recurse through all possible pairs of weights to remove
//then sort arraylist and pair off people
import java.io.*;
import java.util.*;
public class CF863B {
  static PrintWriter pw;
  static BufferedReader r;
  public static void main(String[] args) throws IOException {
    r = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(System.out);
    solve();
    r.close();
    pw.close();
  }
  static void solve() throws IOException {
    StringTokenizer st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    ArrayList<Integer> weights=new ArrayList<Integer>();
    
    st=new StringTokenizer(r.readLine());
    for (int i=0; i<2*n; i++) {
      weights.add(Integer.parseInt(st.nextToken()));
    }
    
    Collections.sort(weights);
    long unstable=10000000;
    if (n==1) {
      pw.print(0);
    } else {
      for (int i=0; i<2*n; i++) {
        for (int j=i+1; j<2*n; j++) {
          ArrayList<Integer> cache=new ArrayList<Integer>(weights);
          weights.remove(i);
          weights.remove(j-1);
          int f=0;
          for (int k=0; k<2*n-2; k+=2) {
            f+=weights.get(k+1)- weights.get(k);
          }
          unstable=Math.min(unstable, f);
          weights=cache;
        }
      }
      pw.print(unstable);
    }
  }
}