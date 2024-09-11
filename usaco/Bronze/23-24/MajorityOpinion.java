//Code was written in January 24, at the beginning of my CP career!!! which explains why it sucks
import java.io.*;
import java.util.*;
public class MajorityOpinion {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());
		int t=Integer.parseInt(st.nextToken());
		for (int i=0; i<t; i++) {
			TreeSet<Integer> a=new TreeSet<>();
			st = new StringTokenizer(r.readLine());
			int n=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(r.readLine());
			int[] ans=new int[n];
			int prev, prev2;
			for (int j=0; j<n; j++) {
				int l=Integer.parseInt(st.nextToken());
				ans[j]=l;
				if (j>0) {
					prev=ans[j-1];
					if (l==prev) {
						a.add(l);
						//System.out.println(l+" prev "+j);
					}
					
				}
				if (j>1) {
					prev2=ans[j-2];
					if (l==prev2) {
						a.add(l);
						//System.out.println(l+" prev2 "+j);
					}
					
				}
			}
			if (!a.isEmpty()) {
				int k=0;
				for (int q:a) {
					if (k<a.size()-1) {
						pw.print(q+" ");
					} else {
						pw.println(q);
					}
					k++;
				}
			} else {
				pw.println(-1);
			}
		}
		r.close();
		pw.close();
	}
}
