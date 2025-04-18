//for iterable i, takes the sum of the first i values of the array
//then subtracts the current value from the list of previous values to find answer
import java.io.*;
import java.util.*;
public class SubarraySums {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    long x=(long)Integer.parseInt(st.nextToken());
    st = new StringTokenizer(r.readLine());
    int[] arr=new int[n];
    for (int i=0; i<n; i++) {
       arr[i]=Integer.parseInt(st.nextToken()); 
    }
    long ans=0, prefix=0;
    HashMap<Long, Integer> m=new HashMap<>();
    m.put(0L,1);
    for (int i=0; i<n; i++) {
        prefix+=arr[i];
        if (m.containsKey(prefix-x)) {
            ans+=m.get(prefix-x);
        }
        if (m.containsKey(prefix)) {
            m.put(prefix, m.get(prefix)+1);
        } else {
            m.put(prefix,1);
        }
    }
    pw.print(ans);
    r.close();
    pw.close();
  }
}