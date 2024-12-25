//solved w/ 2 pointers
//key is to match cows w/ highest and lowest milk production
import java.io.*;
import java.util.*;
public class PairedUp {
  static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("pairup.in"));
    PrintWriter pw = new PrintWriter("pairup.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    n=Integer.parseInt(st.nextToken());
    int[][] info=new int[n][2];
    for (int i=0; i<n; i++) {
      st = new StringTokenizer(r.readLine());
      int x=Integer.parseInt(st.nextToken());
      int y=Integer.parseInt(st.nextToken());
      info[i][0]=x;
      info[i][1]=y;
    }
    //sort array based on milk output
    Arrays.sort(info, (a, b) -> Integer.compare(a[1], b[1]));
    long ans=-1;
    int left=0, right=n-1; //two pointers
    while (left <= right) {
      int amtLeft=info[left][0];
      int amtRight=info[right][0];
      int x=Math.min(amtLeft, amtRight); //how much to decrement by
      if (left==right) { //edge case
        x/=2;
      }
      info[left][0]-=x;
      info[right][0]-=x;
      
      ans=Math.max(ans, info[left][1]+info[right][1]);
      //move pointers
      if (info[left][0]==0) {
        left++;
      } 
      if (info[right][0]==0) {
        right--;
      } 
    }
    pw.print(ans);
    r.close();
    pw.close();
  }
}