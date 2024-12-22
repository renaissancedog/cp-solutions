//pretty easy, simpler than p1 in my opinion
import java.io.*;
import java.util.*;
public class CheeseBlock {
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        long ans=0;
        //for every xy, xz, and yz axis, check if a cheese block could fit there
        int[][] xy=new int[n][n];
        int[][] yz=new int[n][n];
        int[][] xz=new int[n][n];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(r.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());
            xy[x][y]++;
            yz[y][z]++;
            xz[x][z]++;
            if (xy[x][y]==n) {
                ans++;
                xy[x][y]=0; //so it won't get counted again
            }
            if (yz[y][z]==n) {
                ans++;
                yz[y][z]=0;
            }
            if (xz[x][z]==n) {
                ans++;
                xz[x][z]=0;
            }
            pw.println(ans);
        } 
        pw.close();
        r.close();
    }
}