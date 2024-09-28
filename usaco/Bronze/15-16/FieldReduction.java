import java.io.*;
import java.util.*;
public class FieldReduction {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("reduce.in"));
    PrintWriter pw = new PrintWriter("reduce.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    //cow locations
    int[][] loc=new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(r.readLine());
      int x=Integer.parseInt(st.nextToken());
      int y=Integer.parseInt(st.nextToken());
      loc[i][0]=x;
      loc[i][1]=y;
    }
    //find four extreme cows because one will be removed
    int minX=50000,maxX=-1,minY=50000,maxY=-1;
    //store locations of four cows in array
    int[] maxind=new int[4];
    for (int i=0; i<n; i++) {
      int x=loc[i][0];
      int y=loc[i][1];
      if (x>maxX) {
        maxX=x;
        maxind[0]=i;
      }
      if (x<minX) {
        minX=x;
        maxind[1]=i;
      }
      if (y>maxY) {
        maxY=y;
        maxind[2]=i;
      }
      if (y<minY) {
        minY=y;
        maxind[3]=i;
      }
    }
    long minArea=Integer.MAX_VALUE;
    //for all four extreme cows, try removing and then find min area
    for (int i=0; i<4; i++){
      int c=0;
      int skippedIndex=maxind[i];
      int[][] newLoc=new int[n-1][2];
      for (int j = 0; j < loc.length; j++) {
        if (j!=skippedIndex) {
          newLoc[c][0]=loc[j][0];
          newLoc[c][1]=loc[j][1];
          c++;
        } 
      }
      minArea=Math.min(minArea, area(newLoc));
    }
    pw.print(minArea);
    pw.close();
    r.close();
  }
  //find area of a set of coords
  static long area(int[][] a) {
    long minX=50000,maxX=-1,minY=50000,maxY=-1;
    for (int i=0; i<a.length; i++) {
      long x=(long)a[i][0];
      long y=(long)a[i][1];
      if (x>maxX) {
        maxX=x;
      }
      if (x<minX) {
        minX=x;
      }
      if (y>maxY) {
        maxY=y;
      }
      if (y<minY) {
        minY=y;
      }
    }
    return Math.abs((maxX-minX))*Math.abs(maxY-minY);
  }
}