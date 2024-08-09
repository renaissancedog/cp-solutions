//key insight is to count node connections

import java.io.*;
import java.util.*;
public class GrassPlanting {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("planting.in"));
    PrintWriter pw = new PrintWriter("planting.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    HashMap<Integer,Integer> hm=new HashMap<>();
    int n=Integer.parseInt(st.nextToken());
    for (int i=0; i<n-1;i++) {
      st = new StringTokenizer(r.readLine());
      int a=Integer.parseInt(st.nextToken()); 
      int b=Integer.parseInt(st.nextToken()); 
      if (hm.containsKey(a)) {
        hm.put(a,hm.get(a)+1);
      } else {
        hm.put(a,1);
      }
      if (hm.containsKey(b)) {
        hm.put(b,hm.get(b)+1);
      } else {
        hm.put(b,1);
      }
    }
    int max=-1;
    for (Map.Entry<Integer,Integer> a: hm.entrySet()) {
      int w=a.getValue();
      if (w>max) {
        max=w;
      }
    }
    pw.print(max+1);
    pw.close();
    r.close();
  }
}
