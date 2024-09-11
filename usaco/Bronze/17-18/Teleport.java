//casework, find smallest of 3 cases

import java.io.*;
import java.util.*;
public class Teleport {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("teleport.in"));
    PrintWriter pw = new PrintWriter("teleport.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int a=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());
    int c=Integer.parseInt(st.nextToken());
    int d=Integer.parseInt(st.nextToken());
    
    int teleportDis=Math.min(Math.abs(a-c)+Math.abs(d-b), Math.abs(a-d)+Math.abs(c-b));
    int def=Math.abs(a-b);
    pw.print(Math.min(def,teleportDis));
    pw.close();
    r.close();
  }
}
