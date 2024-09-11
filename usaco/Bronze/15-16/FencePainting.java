//check all possible cases

import java.io.*;
import java.util.*;
public class FencePainting {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("paint.in"));
    PrintWriter pw = new PrintWriter("paint.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int a=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());
    st = new StringTokenizer(r.readLine());
    int c=Integer.parseInt(st.nextToken());
    int d=Integer.parseInt(st.nextToken());
    
    int total=b-a+d-c;int overlap;
    if (c<=a&&d>=a) {
      overlap=Math.min(d-a,b-a);
    } else if (c<=b&&d>=b) {
      overlap=Math.min(b-c,b-a);
    } else if (a>=c&&d>=b){
      overlap=b-a;
    } else if (c>=a&&b>=d) { 
      overlap=d-c;
    } else {
      overlap=0;
    }
    pw.print(total-overlap);
    pw.close();
    r.close();
  }
}
