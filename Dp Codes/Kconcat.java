import java.io.*;
import java.util.*;

public class Kconcat {

  public static long solution(int[] arr, int k, long sum) {
    if(k == 1){
        return solution(arr);
    }
    
    int[] na = new int[2 * arr.length];
    for(int i = 0 ; i < na.length; i++){
        na[i] = arr[i % arr.length];
    }
    
    if(sum >= 0){
        return (k - 2) * sum + solution(na);
    }else{
        return solution(na);
    }

  }
  
  public static long solution(int[] arr) {
    long ssf = 0;
    long maxsum = Integer.MIN_VALUE;
    
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
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k, sum));
  }

}