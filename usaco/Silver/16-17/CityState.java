//brute force thru all possible combos of 4-letter segments
import java.io.*;
import java.util.*;
public class CityState {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("citystate.in"));
    PrintWriter pw = new PrintWriter("citystate.out");
    StringTokenizer st = new StringTokenizer(r.readLine());
    int n=Integer.parseInt(st.nextToken());
    HashMap<String, Integer> initials=new HashMap<>(); 
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(r.readLine());
      String a=st.nextToken();
      String b=st.nextToken();
      String ini=a.substring(0,2)+b;//first 2 letters of 1st string plus 2nd string
      if (initials.containsKey(ini)) {
        initials.put(ini, initials.get(ini)+1);
      } else {
        initials.put(ini,1);
      }
    }
    long ans=0;
    for(Map.Entry<String, Integer> entry : initials.entrySet()) { //for-each a HashMap
      String key = entry.getKey();
      int value = entry.getValue(), revVal=0;
      String reverse = key.substring(2)+key.substring(0,2);  
      if (reverse.substring(0, 2).equals(reverse.substring(2))) { //if in same state
        continue;
      }
      if (initials.containsKey(reverse)) {
        revVal=initials.get(reverse);
      }
      ans+=(value*revVal);//account for all pairs of cities with same initials
    } 
    pw.println(ans/2);//divide by 2 for overcounting
    r.close();
    pw.close();
  }
}