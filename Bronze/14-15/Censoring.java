//i made a StringBuilder and foreached the original string, appending to SB
//when end of SB is censored word, remove and recheck
//took a while to solve
import java.io.*;
import java.util.*;
public class Censoring {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("censor.in"));
    PrintWriter pw = new PrintWriter("censor.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    String a=st.nextToken();
    st = new StringTokenizer(r.readLine());
    String b=st.nextToken();
    StringBuilder sb=new StringBuilder();
    for (int i=0; i<a.length(); i++) {
      sb.append(a.charAt(i));
      while (sb.length()>=b.length()&&sb.substring(sb.length()-b.length()).equals(b)) {
        sb=new StringBuilder(sb.substring(0,sb.length()-b.length()));
      }
    } 
    pw.println(sb);
    pw.close();
    r.close();
  }
}
