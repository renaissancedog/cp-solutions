//Got 16/20 in contest, fixed it with better infinite loop handling
import java.io.*;
import java.util.*;
public class Cannonball {
    public static void main(String[] args) throws IOException {
        int power=1;
        boolean dir=true; //dir controls direction (true is right, false is left)
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());

        int[][] loc=new int[n][2];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(r.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            loc[i][0]=a;
            loc[i][1]=b;
        }

        HashSet<Integer> targets=new HashSet<>();
        int bounces=0; //this is my (lazy) way of dealing with infinite loops. when Bessie reaches 500k bounces, the simulation terminates
        while (s>0&&s<=n&&bounces<500000) {
            //ez simulation
            if (loc[s-1][0]==0) {
                power+=loc[s-1][1];
                dir=!dir;
            } else {
                if (power>=loc[s-1][1]) {
                    targets.add(s-1);
                }
            }
            if (dir) {
                s+=power;
            } else {
                s-=power;
            }
            bounces++;
        }
        pw.print(targets.size());
        r.close();
        pw.close();
    }
}