//casework
import java.io.*;
import java.util.*;
public class RoundaboutRounding {
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t=Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            long ans=0;
            st = new StringTokenizer(r.readLine());
            long a=Integer.parseInt(st.nextToken());
            String as=String.valueOf(a);
            as=String.valueOf(a-1); //to calculate magnitude, because 100 -> magnitude 2
            int mag=as.length();
            for (int l=mag; l>0; l--) {
                String cutoff=""; //find "cutoff" number that determines rounding up/down
                for (int j=0; j<l-1; j++) {
                    cutoff+="4";
                }
                cutoff+="5";
                long ct=Integer.parseInt(cutoff);
                if (l==mag) { //casework
                    if (Math.pow(10,l)/2<=a) {
                        ans+=Math.max((Math.pow(10,l)/2-ct),0);
                    } else {
                        ans+=Math.max(0, a-ct+1);
                    }
                } else {
                    ans+=Math.pow(10, l)/2-ct;
                }
            }
            pw.println(ans); 
        } 
        pw.close();
        r.close();
    }
}