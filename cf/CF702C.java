//compute a pointer for towers and check when to increment it
import java.io.*;
import java.util.*;
public class CF702C {
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
        st = new StringTokenizer(r.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] cities=new int[n];
        int[] towers=new int[m];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            cities[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < m; i++) {
            towers[i]=Integer.parseInt(st.nextToken());
        }
        int ans=-1;
        int currTower=0;
        for (int i=0; i<n; i++) {
            int currCity=cities[i];
            while (currTower!=m-1&&Math.abs(towers[currTower+1]-currCity)<=Math.abs(towers[currTower]-currCity)) {
                currTower++;
            }
            ans=Math.max(ans, Math.abs(currCity-towers[currTower]));
        }
        pw.println(ans);
    }
}