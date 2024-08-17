//directly simulate
import java.io.*;
import java.util.*;
public class Lostcow {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("lostcow.in"));
    PrintWriter pw = new PrintWriter("lostcow.out");
    st=new StringTokenizer(r.readLine());
    int m=Integer.parseInt(st.nextToken());
    int n=Integer.parseInt(st.nextToken());
    int prevPos=-1, currPos=m;
    int dist=0;
    for (int i=0; i<100; i++) {
      prevPos=currPos;
      currPos=m+(int)Math.pow(-2, i);
      if (n>prevPos&&n<=currPos) {
        dist+=(int)Math.abs(prevPos-n);
        break;
      }
      if (n<prevPos&&n>=currPos) {
        dist+=(int)Math.abs(prevPos-n);
        break;
      }
      dist+=Math.abs(currPos-prevPos);
    } 
    pw.print(dist);
    r.close();
    pw.close();
  }
}