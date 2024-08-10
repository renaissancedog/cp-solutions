//Brute force check all 100 miles
import java.io.*;
import java.util.*;
public class Speeding {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter("speeding.out");
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
        int[] limit=new int[100];
        int[] speed=new int[100];
        int counter=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
            for (int j=counter; j<counter+a; j++) {
                limit[j]=b;
            }
            counter+=a;
        }  
        counter=0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(r.readLine());
            int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
            for (int j=counter; j<counter+a; j++) {
                speed[j]=b;
            }
            counter+=a;
        }  
        int max=-1;
        for (int i=0; i<100; i++) {
            max=Math.max(max, speed[i]-limit[i]);
        }
        pw.println(Math.max(max,0));
        r.close();
        pw.close();
    }
}