//iterate thru all nums (0,17) to (83,100)
//check if each hill is in group and compute
//O(N) time?? I'm not sure 

import java.io.*;
import java.util.*;
public class SkiDesign {
  public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("skidesign.in"));
    PrintWriter pw = new PrintWriter("skidesign.out");
		StringTokenizer st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int[] hills=new int[n];
    for (int i=0;i<n;i++) {
      st=new StringTokenizer(r.readLine());
      hills[i]=Integer.parseInt(st.nextToken());
    } 
    Arrays.sort(hills);
    int ans=Integer.MAX_VALUE;
    for (int i=0; i<=83; i++) {
      int max=i+17;
      int curr=0;
      for (int j=0; j<n; j++) {
        int c=hills[j];
        if (c>=i&&c<=max) {
          continue;
        } else if (c<i) {
          curr+=(i-c)*(i-c);
        } else {
          curr+=(max-c)*(max-c);
        }
      }
      ans=Math.min(curr,ans);
    }
    pw.print(ans);
    pw.close();
    r.close();
  }
}