import java.io.*;
import java.util.*;
public class CowCross2 {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("circlecross.in"));
    PrintWriter pw = new PrintWriter("circlecross.out");
    int[][] cross=new int[26][2];
    st=new StringTokenizer(r.readLine());
    String s=st.nextToken();
    for (int i=0; i<52; i++) {
      char c=s.charAt(i);
      if (cross[c-'A'][0]!=0) {
        cross[c-'A'][1]=i+1;
      } else {
        cross[c-'A'][0]=i+1;
      }
    }
    int ans=0;
    for (int i=0; i<26; i++) {
      for (int j=0; j<26; j++) {
        //if and only if A enters, B enters, A exits, then B exits, the cows cross
        int one=cross[i][0];
        int two=cross[j][0];
        int three=cross[i][1];
        int four=cross[j][1];
        if (one<two&&two<three&&three<four) {
          ans++;
        } 
      }
    }
    pw.print(ans);
    r.close();
    pw.close();
  }
}