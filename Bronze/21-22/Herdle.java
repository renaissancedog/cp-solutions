//very unoptimized brute force
//i was tired when coding this
import java.io.*;
import java.util.*;
public class Herdle {
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    char[] ans=new char[9];
    char[] guess=new char[9];
    int[] ansCount=new int[26];
    int[] guessCount=new int[26];
    int green=0;
    int yellow=0;
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(r.readLine());
      String a=st.nextToken();
      ansCount[a.charAt(0)-65]++;
      ansCount[a.charAt(1)-65]++;
      ansCount[a.charAt(2)-65]++;
      ans[3*i]=a.charAt(0);
      ans[1+3*i]=a.charAt(1);
      ans[2+3*i]=a.charAt(2);
    }
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(r.readLine());
      String a=st.nextToken();
      guessCount[a.charAt(0)-65]++;
      guessCount[a.charAt(1)-65]++;
      guessCount[a.charAt(2)-65]++;
      guess[3*i]=a.charAt(0);
      guess[1+3*i]=a.charAt(1);
      guess[2+3*i]=a.charAt(2);
    }
    for (int i=0;i<9;i++) {
      if (ans[i]==guess[i]) {
        green++;
        ansCount[ans[i]-65]--;
        guessCount[ans[i]-65]--;
      }
    }
    for (int i=0; i<26; i++) {
      if (ansCount[i]>0) {
        yellow+=Math.min(ansCount[i],guessCount[i]);
      }
    }
    pw.println(green);
    pw.print(yellow);
    r.close();
    pw.close();
  }
}