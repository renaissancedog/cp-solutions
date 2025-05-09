//solved with 2 pointers - check if all characters are included, move pointer accordingly, and keep track of the solution
import java.io.*;
import java.util.*;
public class CF701C {
  static PrintWriter pw;
  static BufferedReader r;
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    r = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(System.out);
    solve();
    pw.close();
    r.close();
  }
  static void solve() throws IOException {
    int ans=100000;
    st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    st = new StringTokenizer(r.readLine());
    String s=(st.nextToken());
    HashSet<Character> hs=new HashSet<>();
    for (char c:s.toCharArray()) {
      hs.add(c);
    }
    int chars=hs.size();
    int l=0,r=0;
    HashMap<Character,Integer> hm=new HashMap<Character, Integer>();
    hm.put(s.charAt(0),1);
    while (r!=n) {
      if (hm.size()==chars) {
        ans=Math.min(ans,r-l+1);
        if (hm.get(s.charAt(l))==1) {
          hm.remove(s.charAt(l));
        } else {
          hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
        }
        l++;
      } else {
        r++;
        if (r==n){break;}
        if (!hm.containsKey(s.charAt(r))) {
          hm.put(s.charAt(r),1);
        } else {
          hm.put(s.charAt(r),hm.get(s.charAt(r))+1);
        }
      }
    }
    pw.print(ans);
  }
}
