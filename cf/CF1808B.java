//columns in a testcase are independently computed
//in each column, sort values, then for every i compute columnValue[i]*i-prefix (try it yourself!)
import java.io.*;
import java.util.*;
public class CF1808B {
  static PrintWriter pw;
  static BufferedReader r;
  public static void main(String[] args) throws IOException {
    r = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(System.out);
    StringTokenizer st=new StringTokenizer(r.readLine());
    int t=Integer.parseInt(st.nextToken());
    while (t>0) {
      solve();
      t--;
    }
    r.close();
    pw.close();
  }
  static void solve() throws IOException {
    long sol=0;
    StringTokenizer st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int m=Integer.parseInt(st.nextToken());
    int[][] nums=new int[n][m];
    for (int a=0; a<n; a++) {
      st=new StringTokenizer(r.readLine());
      for (int j=0; j<m; j++) {
        nums[a][j]=Integer.parseInt(st.nextToken());
      }
    }
    if (n==1) {
      pw.println(0);
    } else {
      for (int a=0; a<m; a++) {
        Integer[] cache=new Integer[n];
        for (int j=0; j<n; j++) {
          cache[j]=nums[j][a];
        }
        Arrays.sort(cache);
        int count=n-1;
        for (int j=n-1; j>=0; j--) {
          sol+=(long)count*cache[j];
          count-=2;
        }
      }
      pw.println(sol);
    }
  } 
}