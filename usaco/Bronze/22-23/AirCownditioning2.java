//recursion solves
import java.io.*;
import java.util.*;
public class AirCownditioning2 {
  static int[] cows; //array of cooling requirements
  static int[][] conditioners;//conditioner info
  static int m;//number of conditioners, needed for recursion
  static int ans=Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    m=Integer.parseInt(st.nextToken());
    cows=new int[100];
    conditioners=new int[m][4];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(r.readLine());
      int s=Integer.parseInt(st.nextToken());
      int t=Integer.parseInt(st.nextToken());
      int c=Integer.parseInt(st.nextToken());
      //keep track of requirements
      for (int j=s-1; j<=t-1; j++) {
        cows[j]+=c;
      }
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(r.readLine());
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      int p=Integer.parseInt(st.nextToken());
      int mm=Integer.parseInt(st.nextToken());
      conditioners[i][0]=a;
      conditioners[i][1]=b;
      conditioners[i][2]=p;
      conditioners[i][3]=mm;
    }

    //fun part below

    int[] e=new int[100];//empty array
    recurse(0, 0, e);
    pw.print(ans);
    pw.close();
  }
  static void recurse(int c, int i, int[] e) {
    if (i == m) {
      //finished creating a permutation
      for (int j=0; j<e.length; j++) {
        if (cows[j]>e[j]) {//failed to work
          return;
        }
      }
      //success!! check cost
      ans=Math.min(ans, c);
      return;
    } else {
      int[] effectCopy=Arrays.copyOf(e, e.length);
      //add and check a conditioner
      for (int j=conditioners[i][0]-1; j<=conditioners[i][1]-1; j++) {
        e[j]+=conditioners[i][2];
      }
      recurse(c+conditioners[i][3], i+1, e);
      //don't add a conditioner
      recurse(c, i+1, effectCopy);
    }
  } 
}