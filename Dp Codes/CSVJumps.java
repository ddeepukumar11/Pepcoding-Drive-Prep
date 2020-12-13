import java.io.*;
import java.util.*;

public class CSVJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--){
            int maxjump = arr[i];
            for(int jump = 1; jump <= maxjump; jump++){
                if(i + jump <= n){
                    dp[i] += dp[i + jump];
                }
            }
            
        }
        System.out.println(dp[0]);
    }

}