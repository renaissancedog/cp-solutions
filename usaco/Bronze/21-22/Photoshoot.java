import java.io.*;
import java.util.*;
public class Photoshoot {
  static int[] status;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st=new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    st=new StringTokenizer(r.readLine());
    String a=st.nextToken();
    status = new int[n];
    //represent G's as 0 or 1 and H's as -1
    //0 is G in odd, 1 is G in even
    for (int i = 0; i < n; i++) {
      if (a.charAt(i)=='G') {
        if (i%2==0) {
          status[i]=0;
        } else {
          status[i]=1;
        }
      } else {
        status[i]=-1;
      }
    } 
    ArrayList<Boolean> flip=new ArrayList<>();
    int ans=0;
    int trailingF=0;//number of trailing falses, will get cut off the end
    for (int i=0; i<n; i+=2) {
      int one=Math.min(status[i], status[i+1]);
      int two=Math.max(status[i], status[i+1]);
      //cases
      if (one==-1 && two==0) {
        flip.add(true);
        trailingF=0;
      }
      if (one==-1 && two==1) {
        flip.add(false);
        trailingF++;
      }
    }
    List<Boolean> needFlip=flip.subList(0, flip.size()-trailingF);//cut off trailing falses
    if (needFlip.size()!=0) {
      boolean last=needFlip.get(0);
      //count number of differences
      for (int i=1; i<needFlip.size(); i++) {
        boolean curr=needFlip.get(i);
        if (curr!=last) {
          ans++;
        }
        last=curr;
      }
    }
    if (needFlip.size()>0) {//edge case
      pw.print(ans+1);
    } else {
      pw.print(0);
    }
    pw.close();
    r.close();
  }
}