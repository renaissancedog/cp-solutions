//this was from the oldest contest I could submit in
//pretty easy, count number of '((' and when you find a '))', add amt of lefts to the answer
import java.io.*;
import java.util.*;
public class Cowfind {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("cowfind.in"));
    PrintWriter pw = new PrintWriter("cowfind.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    long left=0;
    long ans=0;
    String s=st.nextToken();
    char prev=s.charAt(0);
    char curr;
    for (int i=1; i<s.length(); i++) {
      curr=s.charAt(i);
      if (curr==prev) {
        if (curr=='(') {
          left++;
        } else {
          ans+=left; 
        }
      }
      prev=curr;
    }
    pw.println(ans);
    pw.close();
    r.close();
  }
}
