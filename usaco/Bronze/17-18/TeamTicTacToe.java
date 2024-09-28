import java.io.*;
import java.util.*;
public class TeamTicTacToe {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("tttt.in"));
    PrintWriter pw = new PrintWriter("tttt.out");
    //represented as 1D array
    char[] board=new char[9];
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(r.readLine());
      String a=st.nextToken();
      for (int j = 0; j < 3; j++) {
        board[3*i+j]=a.charAt(j); 
      } 
    }
    //all possible wins
    int[][] check = {{0,1,2}, {3,4,5}, {6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    HashSet<Character> oneCow=new HashSet<>();
    HashSet<String> twoCow=new HashSet<>();
    for (int[] c:check) {
      //keeps track of how many cows are on given line
      HashSet<Character> hs=new HashSet<>();
      for (int i:c) {
        hs.add(board[i]);
      }
      if (hs.size()==1) {
        oneCow.add(board[c[0]]);
      }
      if (hs.size()==2) {
        String two="";
        for (char h:hs) {
          two+=h;
        }
        twoCow.add(two);
      }
    }
    pw.println(oneCow.size());
    pw.println(twoCow.size());
    pw.close();
    r.close();
  }
}