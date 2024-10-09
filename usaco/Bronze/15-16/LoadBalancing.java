import java.io.*;
import java.util.*;
public class LoadBalancing {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("balancing.in"));
    PrintWriter pw = new PrintWriter("balancing.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());//i didn't use this
    int[][] loc=new int[n][2];
    HashSet<Integer> x=new HashSet<>();
    HashSet<Integer> y=new HashSet<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(r.readLine());
      int x1=Integer.parseInt(st.nextToken());
      int y1=Integer.parseInt(st.nextToken());
      loc[i][0]=x1;
      loc[i][1]=y1;
      x.add(x1);
      y.add(y1);
    }
    int ans=Integer.MAX_VALUE;
    for (int a:x) {
      for (int c:y) {
        ans=Math.min(ans, findMax(a, c, loc));
      }
    }
    pw.print(ans);
    pw.close();
    r.close();
  } 
  static int findMax(int x, int y, int[][] loc) {
    int q1=0, q2=0, q3=0, q4=0;//represents 4 quadrants of coordinate grid
    int scanX=x+1, scanY=y+1;//the axes of our new coordinate grid
    for (int i=0; i<loc.length; i++) {//loops through all points and determines quadrant
      int checkX=loc[i][0];
      int checkY=loc[i][1];
      if (checkX>scanX&&checkY>scanY) {
        q1++;
      }
      if (checkX<scanX&&checkY>scanY) {
        q2++;
      }
      if (checkX>scanX&&checkY<scanY) {
        q4++;
      }
      if (checkX<scanX&&checkY<scanY) {
        q3++;
      }
    } 
    int max=Math.max(Math.max(q1, q2), Math.max(q3, q4));
    return max;
  }
}