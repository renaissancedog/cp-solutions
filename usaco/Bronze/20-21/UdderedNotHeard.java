//use hashmap to keep track of location of all chars
//if we need to repeat alphabet, add 1 to ans
import java.io.*;
import java.util.*;
public class UdderedNotHeard {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    String a=st.nextToken(); 
    st = new StringTokenizer(r.readLine());
    String b=st.nextToken(); 
    //create hashmap
    int i=0;
    HashMap<Character, Integer> hm=new HashMap<>();
    for (char c:a.toCharArray()) {
      hm.put(c, i);
      i++;
    }

    int prev=-1;//location of previous char in alphabet
    int ans=1;
    for (char c:b.toCharArray()) {
      if (hm.get(c)<=prev) {
        ans++;
      }
      prev=hm.get(c);
    }
    pw.print(ans);
    pw.close();
    r.close();
  }
}
