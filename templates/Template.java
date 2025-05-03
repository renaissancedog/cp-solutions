import java.io.*;
import java.util.*;
public class Template {
	static PrintWriter pw;
	static BufferedReader r;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
    	r = new BufferedReader(new InputStreamReader(System.in));
    	pw = new PrintWriter(System.out);
    	solve();
    	r.close();
    	pw.close();
	}
	static void solve() throws IOException {
    	st = new StringTokenizer(r.readLine());
    	int n=Integer.parseInt(st.nextToken());
    	pw.println(n+1);
	}
}