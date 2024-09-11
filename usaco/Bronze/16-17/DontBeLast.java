//pretty easy, simulation

import java.io.*;
import java.util.*;
public class DontBeLast {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter pw = new PrintWriter("notlast.out");
		StringTokenizer st=new StringTokenizer(r.readLine());
		HashMap<String,Integer> hm=new HashMap<>();
		int n=Integer.parseInt(st.nextToken());	
		for (int i = 0; i < n; i++) {
			st=new StringTokenizer(r.readLine());
			String name=st.nextToken();
			int a=Integer.parseInt(st.nextToken());
			if (hm.get(name)==null) {
				hm.put(name, a);
			} else {
				hm.put(name, hm.get(name)+a);
			}
		}

		int min=Integer.MAX_VALUE;
		if (hm.size()<7) {
			min=0;
		} else {
			for(Map.Entry<String, Integer> entry : hm.entrySet()) {
				int value = entry.getValue();
				min=Math.min(min,value);
			}
		}
		int min2=Integer.MAX_VALUE;
		for(Map.Entry<String, Integer> entry : hm.entrySet()) {
			int value = entry.getValue();
			if (value==min) {
				continue;
			}
			min2=Math.min(min2, value);
		}
		int amt=0;
		String name="";
		for(Map.Entry<String, Integer> entry : hm.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if (value==min2) {
				amt++;
				name=key;
			}
		}
		if (amt>1||amt==0) {
			pw.println("Tie");
		} else {
			pw.println(name);
		}
		pw.close();
		r.close();
	}	
}
