//two pointers, solved with help of usaco giude
import java.io.*;
import java.util.*;
public class Books279B {
    static PrintWriter pw;
    static BufferedReader r;
    public static void main(String[] args) throws IOException {
        solve(); 
    }
    static void solve() throws IOException {
        r = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n=Integer.parseInt(st.nextToken());
        int t=Integer.parseInt(st.nextToken());
        int[] len=new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            len[i]=Integer.parseInt(st.nextToken());
        }
        int lo=0, hi=0, total=len[0], ans=0;
        if (n==1&&len[0]<=t) {
            ans=1;
        }
        while (hi!=n-1) {
            hi++;
            total+=len[hi];
            while (total>t) {
                total-=len[lo];
                lo++;
            }
            ans=Math.max(ans, hi-lo+1);
        }
        pw.println(ans);
        pw.close();
        r.close();
    }
}
