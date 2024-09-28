import java.io.*;
import java.util.*;
public class SleepingInClass {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st=new StringTokenizer(r.readLine());
    int t=Integer.parseInt(st.nextToken());
    for (int i = 0; i < t; i++) {
      st=new StringTokenizer(r.readLine());
      int n=Integer.parseInt(st.nextToken());
      int[] nums=new int[n];
      st=new StringTokenizer(r.readLine());
      for (int j = 0; j < nums.length; j++) {
        nums[j]=Integer.parseInt(st.nextToken());
      }
      int sum=0;
      for (int k:nums) {
        sum+=k;
      }
      if (sum==0) { //edge case
        pw.println(0);
      }
      loop:
      for (int a=sum; a>0; a--) { 
        //a is the target number of "blocks"
        //in test case 1, when a=3, blocks are (1 2) (3) (1 1 1) 
        if (sum%a!=0) {
          continue;
        }
        int target=sum/a; //target sum - on first testcase, it is 3
        int runningSum=0; //count of current sum
        for (int num:nums) {
          if (runningSum+num>target) {
            continue loop; //if it is impossible to make a valid block
          } else if (runningSum+num==target) {
            runningSum=0;
          } else {
            runningSum+=num;
          } 
        }
        pw.println(n-a); //number of combinations
        break;
      }
    } 
    pw.close();
    r.close();
  }
}