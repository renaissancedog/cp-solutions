import java.io.*;
import java.util.*;
public class Gymnastics {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("gymnastics.in"));
    PrintWriter pw = new PrintWriter("gymnastics.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int k=Integer.parseInt(st.nextToken());
    int n=Integer.parseInt(st.nextToken());
    int[][] pos=new int[k][n];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(r.readLine());
      for (int j = 0; j < n; j++) {
        pos[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    int ans=0;
    for (int i=1; i<=n; i++) {
      for (int j=i+1; j<=n; j++) { //loop through all pairs of cows
        int last=-1; //2nd cow in pair in last row
        int curr=-1; //2nd cow in pair in current row
        boolean works=true; //does it work?
        for (int l=0; l<k; l++) {
          for (int c:pos[l]) {
            if (c==i||c==j) {
              curr=c; //find the 2nd cow
            }
          }
          if (last!=curr&&last!=-1) { //if the 2nd cows don't match
            works=false; //then it doesn't work!
          }
          last=curr;
        }
        if (works) {
          ans++;
        }
      }
    }
    pw.print(ans);
    pw.close();
    r.close();
  }
}
