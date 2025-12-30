// dfs and check for bipartite coloring
import java.io.*;
import java.util.*;
public class BuildingTeams {
    static PrintWriter pw;
    static BufferedReader r;
    static StringTokenizer st;
    
    static int[] visited; // have we searched this person? what team are they on? (0,1,2)
    static ArrayList<Integer>[] friends; // adjacency matrix of friends for every person
    static boolean isPossible;
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
        friends=new ArrayList[n];
        for (int i=0; i<n; i++) {
            friends[i]=new ArrayList<Integer>();
        }
        visited=new int[n];
        isPossible=true;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            friends[a].add(b);
            friends[b].add(a);
        } 
        for (int i=0; i<n; i++) {
            if (visited[i]==0) {
                dfs(i, 1);
            }
        }
        if (!isPossible) {
            pw.print("IMPOSSIBLE");
        } else {
            for (int i:visited) {
                pw.print(i+" ");
            }
        }
    }
    static void dfs(int a, int counter) { //counter indicates which team person is on, then flips for all their friends
        if (visited[a]!=0) {
            if (visited[a]==3-counter) {
                isPossible=false;
            }
            return;
        }
        visited[a]=counter;
        for (int city:friends[a]) {
            dfs(city, 3-counter);
        }
    }
}
