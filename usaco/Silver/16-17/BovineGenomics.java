//easy simulation

import java.io.*;
import java.util.*;
public class BovineGenomics {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter("cownomics.out");
		StringTokenizer st=new StringTokenizer(r.readLine());
		int n=Integer.parseInt(st.nextToken());	
		int m=Integer.parseInt(st.nextToken());	
		String[] g=new String[2*n];
		for (int i=0; i<2*n; i++) {
			st=new StringTokenizer(r.readLine());
			g[i]=st.nextToken();
		}
		int ans=0;
		for (int i=0; i<m; i++) {
			for (int j = i+1; j < m; j++) {
				loop:
				for (int k =j+1; k<m; k++) {
					HashSet<String> vals=new HashSet<>();
					for (int c=0; c<n; c++) {
						vals.add(String.valueOf(g[c].charAt(i))+g[c].charAt(j)+g[c].charAt(k));
					}	
					for (int c=n; c<2*n; c++) {
						if (vals.contains(String.valueOf(g[c].charAt(i))+g[c].charAt(j)+g[c].charAt(k))) {
							continue loop;
						}
					}
					ans++;
				}	
			}
		}
		pw.println(ans);
		pw.close();
		r.close();
	}	
}
