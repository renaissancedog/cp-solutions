//used a 2001x2001 grid with center at (1000, 1000)
import java.io.*;
import java.util.*;
public class MowingField {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("mowing.in"));
    PrintWriter pw = new PrintWriter("mowing.out");
    StringTokenizer st=new StringTokenizer(r.readLine());
    //initializing stuff
    int n=Integer.parseInt(st.nextToken());
    int time=0;
    int x=1000;
    int y=1000;
    int ans=Integer.MAX_VALUE;
    int[][] grid=new int[2001][2001];//will hold times
    grid[1000][1000]=0;
    for (int[] row:grid) {
      Arrays.fill(row, -1);
    }
    //main logic
    for (int i = 0; i < n; i++) {
      st=new StringTokenizer(r.readLine());
      String dir=(st.nextToken());
      int dist=Integer.parseInt(st.nextToken());
      if (dir.equals("N")) {
        for (int j=0; j<dist; j++) {
          time++;
          y--;
          if (grid[x][y]!=-1) {
            ans=Math.min(ans, time-grid[x][y]);//represents time since FJ was last there
          }
          grid[x][y]=time;
        }
      }
      if (dir.equals("S")) {
        for (int j=0; j<dist; j++) {
          time++;
          y++;
          if (grid[x][y]!=-1) {
            ans=Math.min(ans, time-grid[x][y]);
          }
          grid[x][y]=time;
        }
      }
      if (dir.equals("E")) {
        for (int j=0; j<dist; j++) {
          time++;
          x++;
          if (grid[x][y]!=-1) {
            ans=Math.min(ans, time-grid[x][y]);
          }
          grid[x][y]=time;
        }
      }
      if (dir.equals("W")) {
        for (int j=0; j<dist; j++) {
          time++;
          x--;
          if (grid[x][y]!=-1) {
            ans=Math.min(ans, time-grid[x][y]);
          }
          grid[x][y]=time;
        }
      }
    }
    if (ans!=Integer.MAX_VALUE) {
      pw.print(ans);
    } else {
      //FJ did not come across a square more than once
      pw.print(-1);
    }
    pw.close();
    r.close();
  }
}