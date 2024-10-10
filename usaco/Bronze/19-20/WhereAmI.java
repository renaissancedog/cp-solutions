import java.io.*;
import java.util.*;
public class WhereAmI {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("whereami.in"));
    PrintWriter pw = new PrintWriter("whereami.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    st = new StringTokenizer(r.readLine());
    String s=st.nextToken();
    for (int i = 1; i <= n; i++) {
      HashSet<String> all=new HashSet<>();//stores all substrings
      for (int j = 0; j <= n-i; j++) {//loops thru all substrings of length i
        String sub=s.substring(j, j+i);
        all.add(sub);
      }
      if (all.size()==n-i+1) {//if all substrings are unique
        pw.print(i); 
        break;
      }
    } 
    pw.close();
    r.close();
  } 
}