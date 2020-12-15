import java.io.*;
import java.util.*;

public class Kadane {

  public static int solution(int[] arr) {
    int ssf = 0;
    int maxsum = Integer.MIN_VALUE;
    
    for(int i = 0 ; i < arr.length; i++){
        if(ssf >= 0){
            ssf += arr[i];
        }else{
            ssf = arr[i];
        }
        maxsum = Math.max(maxsum,ssf);
    }

    return maxsum;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}