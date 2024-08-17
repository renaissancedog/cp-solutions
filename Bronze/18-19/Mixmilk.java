//simulated 100 pours
import java.io.*;
import java.util.*;
public class Mixmilk {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("mixmilk.in"));
    PrintWriter pw = new PrintWriter("mixmilk.out");
    long[] bucketCap=new long[3];
    long[] bucketAmt=new long[3];
    for (int i=0; i<3; i++) {
      st = new StringTokenizer(r.readLine());
      long n=Integer.parseInt(st.nextToken());
      long p=Integer.parseInt(st.nextToken());
      bucketCap[i]=n;
      bucketAmt[i]=p;
    }
    for (int i=0; i<33; i++) {
      long amtPour=Math.min(bucketCap[1]-bucketAmt[1], bucketAmt[0]);
      bucketAmt[0]-=amtPour;
      bucketAmt[1]+=amtPour;
      amtPour=Math.min(bucketCap[2]-bucketAmt[2], bucketAmt[1]);
      bucketAmt[1]-=amtPour;
      bucketAmt[2]+=amtPour;
      amtPour=Math.min(bucketCap[0]-bucketAmt[0], bucketAmt[2]);
      bucketAmt[2]-=amtPour;
      bucketAmt[0]+=amtPour;
    }
    long amtPour=Math.min(bucketCap[1]-bucketAmt[1], bucketAmt[0]);
    bucketAmt[0]-=amtPour;
    bucketAmt[1]+=amtPour;
    pw.println(bucketAmt[0]);
    pw.println(bucketAmt[1]);
    pw.println(bucketAmt[2]);
    r.close();
    pw.close();
  }
}