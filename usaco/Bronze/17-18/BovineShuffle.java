//brute force reverse the process
import java.io.*;
import java.util.*;
public class BovineShuffle {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("shuffle.in"));
    PrintWriter pw = new PrintWriter("shuffle.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    int[] shuffle=new int[n];
    int[] id=new int[n];
    st = new StringTokenizer(r.readLine());
    for (int i = 0; i < n; i++) {
      shuffle[i]=Integer.parseInt(st.nextToken()); 
    }
    st = new StringTokenizer(r.readLine());
    for (int i = 0; i < n; i++) {
      id[i]=Integer.parseInt(st.nextToken()); 
    }
    for (int i=0; i<3; i++) {
      int[] temp=new int[n];
      for (int j=0;j<n;j++) {
        temp[j]=id[shuffle[j]-1];
      }
      id=Arrays.copyOf(temp, n);
    } 
    for (int i:id) {
      pw.println(i);
    } 
    
    pw.close();
    r.close();
  }
}
