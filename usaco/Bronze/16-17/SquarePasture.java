//found smallest and largest x/y values
//then found difference
//the larder difference squared was the answer

import java.io.*;
import java.util.*;
public class SquarePasture {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("square.in"));
    PrintWriter pw = new PrintWriter("square.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int a=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());
    int c=Integer.parseInt(st.nextToken());
    int d=Integer.parseInt(st.nextToken());
    st = new StringTokenizer(r.readLine());
    int e=Integer.parseInt(st.nextToken());
    int f=Integer.parseInt(st.nextToken());
    int g=Integer.parseInt(st.nextToken());
    int h=Integer.parseInt(st.nextToken());
    int xL=Math.max(Math.max(a,c),Math.max(e, g));
    int xS=Math.min(Math.min(a,c),Math.min(e, g));

    int yL=Math.max(Math.max(b,d),Math.max(f, h));
    int yS=Math.min(Math.min(b,d),Math.min(f, h));

    int size=Math.max(yL-yS, xL-xS);
    pw.print(size*size);
    pw.close();
    r.close();
  }
}
