//created a string to store what i wanted to print
import java.io.*;
import java.util.*;
public class Word {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("word.in"));
    PrintWriter pw = new PrintWriter("word.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int a=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());
    int counter=0;
    String out="";
    st = new StringTokenizer(r.readLine());
    for (int i = 0; i < a; i++) {
      String word = st.nextToken(); 
      if (counter+word.length()>b) {
        out=out.substring(0, out.length()-1);
        pw.println(out);
        out=(word+" ");
        counter=word.length();
      } else {
        out+=(word+" ");
        counter+=word.length();
      }
    } 
    if (out.length()>0) {
      pw.print(out.substring(0,out.length()-1));
    }
    r.close();
    pw.close();
  }
}