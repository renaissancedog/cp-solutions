//not-so-clean solution, but it works
import java.io.*;
import java.util.*;
public class AngryCows {
  static PrintWriter pw;
  static BufferedReader r;
  static StringTokenizer st;
  static String fileName="angry";
  public static void main(String[] args) throws IOException {
    r = new BufferedReader(new FileReader(fileName+".in"));
    pw = new PrintWriter(fileName+".out");
    solve();
    pw.close();
    r.close();
  }
  static void solve() throws IOException {
    st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int[] loc=new int[n];
    int ans=-1;
    for (int i=0; i<n; i++) {
      st=new StringTokenizer(r.readLine());
      loc[i]=Integer.parseInt(st.nextToken());
    }
    Arrays.sort(loc);
    for (int i=0; i<n; i++) { //iterate through every starting point
      int localAns=1;
      int l=i, r=i;
      int radius=1;
      while (r<n) { //check how far we can go to the right
        int a=0; //distance from r to the furthest bale that we can reach
        while ((r+a<n-1)&&loc[r+a]-loc[r]<=radius) {
          a++;
          if (loc[r+a]-loc[r]>radius) { //too far
            a--;
            break;
          }
        }
        if (a==0) break; //we didn't hit any more bales
        r+=a;
        localAns+=a;
        radius++;
      } 
      radius=1;
      while (l>=0) { //check how far we can go to the left
        int a=0;
        while ((l-a>0)&&loc[l]-loc[l-a]<=radius) {
          a++;
          if (loc[l]-loc[l-a]>radius) {
            a--;
            break;
          }
        }
        if (a==0) break;
        l-=a;
        localAns+=a;
        radius++;
      }
      ans=Math.max(ans, localAns);
    }
    pw.println(ans);
  }
}
