//binary search grazings by time to find closest before/after alibi
import java.io.*;
import java.util.*;
public class Cowlibi {
	static BufferedReader r;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		r = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
		solve();
		pw.close();
		r.close();
	}
	static void solve() throws IOException {
		long ans=0;
		StringTokenizer st=new StringTokenizer(r.readLine());
		int g=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		long[][] grazings=new long[g][3];
		long[] grazingTimes=new long[g];
		for (int i=0; i<g; i++) {
			st=new StringTokenizer(r.readLine());
			grazings[i][0]=Long.parseLong(st.nextToken());
			grazings[i][1]=Long.parseLong(st.nextToken());
			grazings[i][2]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(grazings, (a, b) -> Long.compare(a[2], b[2]));
		for (int i=0; i<g; i++) {
			grazingTimes[i]=grazings[i][2];
		}
		for (int i=0; i<n; i++) {
			st=new StringTokenizer(r.readLine());
			long x=Long.parseLong(st.nextToken());
			long y=Long.parseLong(st.nextToken());
			long t=Long.parseLong(st.nextToken());
			//grazing closest in time before (or at) alibi
			int leftGrazing=Arrays.binarySearch(grazingTimes, t);
			if (leftGrazing < 0) leftGrazing = Math.abs(leftGrazing+2);
			int rightGrazing=leftGrazing+1;//grazing closest in time after alibi
			if (rightGrazing>g-1) rightGrazing=g-1;
			ans++;
			if (inRange(x,y,t, leftGrazing, grazings)&&inRange(x, y, t, rightGrazing, grazings)) {
				ans--;
			}
		} 
		pw.print(ans);
	}
	static boolean inRange(long x, long y, long t, int index, long[][] grazings) {
		long dx=x-grazings[index][0];
		long dy=y-grazings[index][1];
		long dt=t-grazings[index][2];
		long distance2= dx*dx+dy*dy;
		long time2=dt*dt;
		
		return distance2 <= time2;
	}
	
}
