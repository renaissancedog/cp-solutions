//this one was annoying
//took me way too long - over an hour

import java.io.*;
import java.util.StringTokenizer;
public class CowCross2 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter pw = new PrintWriter("maxcross.out");
		StringTokenizer st=new StringTokenizer(r.readLine());
		int n=Integer.parseInt(st.nextToken());	
		int k=Integer.parseInt(st.nextToken());	
		int b=Integer.parseInt(st.nextToken());	
		boolean[] broke=new boolean[n];
		for (int i = 0; i < b; i++) {
			st=new StringTokenizer(r.readLine());
			int a=Integer.parseInt(st.nextToken());	
			broke[a-1]=true;
		}
		int[] prefix=new int[n+1];
		prefix[0]=0;
		for (int i = 0; i < n; i++) {
			prefix[i+1]=prefix[i];
			if (!broke[i]) {
				prefix[i+1]++;
			}	
		}
		int ans=1000000;
		for (int i = 1; i < n-k+2; i++) {
			int pre=k-(prefix[i+k-1]-prefix[i-1]);
			//pw.println(i+" "+pre);
			ans=Math.min(ans,pre);
		}
		pw.print(ans);
		pw.close();
		r.close();
	}	
}
