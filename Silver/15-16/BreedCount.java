//trivial with prefix sums
import java.io.*;
import java.util.*;
public class BreedCount {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pw = new PrintWriter("bcount.out");
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
        int[][] prefix=new int[n+1][3];
        prefix[0][0]=0;prefix[0][1]=0;prefix[0][2]=0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(r.readLine());
            int a=Integer.parseInt(st.nextToken());
            prefix[i][0]=prefix[i-1][0];
            prefix[i][1]=prefix[i-1][1];
            prefix[i][2]=prefix[i-1][2];
            prefix[i][a-1]++;
        } 
        for (int i=0;i<q;i++) {
            st = new StringTokenizer(r.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            pw.print(prefix[b][0]-prefix[a-1][0]+" ");
            pw.print(prefix[b][1]-prefix[a-1][1]+" ");
            pw.print(prefix[b][2]-prefix[a-1][2]+"\n");
        }
        r.close();
        pw.close();
    }
}