//this took embarassingly long to get
//didn't figure out life hack on line 18 for 15 mins lmao

import java.io.*;
import java.util.*;
public class ABC {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    int[] a=new int[7];
    for (int i = 0; i < 7; i++) {
      int n=Integer.parseInt(st.nextToken());
      a[i]=n;
    }
    Arrays.sort(a);
    int i1=a[6]-a[0]-a[1];
    int i3=a[6]-a[5];
    int i2=a[6]-i1-i3;
    pw.print(i3+" "+i2+" "+i1);
    pw.close();
    r.close();
  }
}
