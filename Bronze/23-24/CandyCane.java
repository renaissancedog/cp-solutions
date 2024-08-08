//BF and breaking the loop solves the problem
//was struggling but realized I had to use long
//lesson: longs are important!

import java.io.*;
import java.util.*;
public class CandyCane {
  public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int m=Integer.parseInt(st.nextToken());
    long[] cows=new long[n];
    int[] canes=new int[m];
    st = new StringTokenizer(r.readLine());
    for (int i=0;i<n;i++) {
      cows[i]=Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(r.readLine());
    for (int i=0;i<m;i++) {
      canes[i]=Integer.parseInt(st.nextToken());
    }
    cane:
    for (int i=0;i<m;i++) {
      int height=canes[i];
      long above=0;
      for (int j=0;j<n;j++) {
        long cowH=cows[j];
        if (above<cowH) {
          if (cowH>height) {
            cows[j]+=height-above;
            continue cane;
          } else {
            cows[j]+=cowH-above;
            above=cowH;
          }
        }
      }
    }
    for (long i:cows) {
      pw.println(i);
    }
    pw.close();
    r.close();
  }
}
