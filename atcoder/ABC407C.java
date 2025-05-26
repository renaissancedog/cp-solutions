//fairly easy
import java.io.*;
import java.util.*;
public class ABC407C {
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
		long ans=0;
		int totalMod=0;
		st = new StringTokenizer(r.readLine());
		char[] s=st.nextToken().toCharArray();
		for (int i=s.length-1; i>=0; i--) {
			int a=Character.getNumericValue(s[i]);
			ans+=(a+1);
			totalMod=(totalMod+a)%10;
			if (i>0) {
				int next=((int)s[i-1]-(totalMod+'0'));
				if (next<0) {
					next+=10;
				}
				s[i-1]=(char)(next+'0');
			}
		}	
		pw.print(ans);
	}
}