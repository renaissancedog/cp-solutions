//brute force cases
//involves a lot of casework to solve
import java.io.*;
import java.util.*;
public class Herding {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter("herding.out");
        StringTokenizer st = new StringTokenizer(r.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] q={a,b,c};
        Arrays.sort(q);
        pw.println(minSolve(q));
        pw.print(maxSolve(q));
        r.close();
        pw.close();
    }
    static int maxSolve(int[] n) {
        return Math.max(n[2]-n[1]-1,n[1]-n[0]-1);
    }
    public static int minSolve(int[] n) {
        if (n[0]==n[2]-2) {
            return 0;
        }
        if (n[0]==n[1]-2||n[1]==n[2]-2) {
            return 1;
        }
        return 2;
    }
}