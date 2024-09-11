import java.io.*;
import java.util.*;
public class BlockGame {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("blocks.in"));
    PrintWriter pw = new PrintWriter("blocks.out");
    //store values
    int[] amt=new int[26];
    st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      //idea is to take max char count for each pair of words
      st=new StringTokenizer(r.readLine());
      String a=st.nextToken();
      String b=st.nextToken();
      int[] freq1=freq(a); 
      int[] freq2=freq(b);
      for (int j=0; j<26; j++) {
        amt[j]+=Math.max(freq1[j],freq2[j]);
      }
    } 
    for (int i:amt) {
      pw.println(i);
    }
    r.close();
    pw.close();
  }
  static int[] freq(String a) {
    int[] frequency=new int[26];
    for (char c:a.toCharArray()) {
      frequency[c-'a']++;
    }
    return frequency;
  }
}