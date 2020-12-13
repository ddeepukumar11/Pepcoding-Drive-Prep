import java.io.*;
import java.util.*;

public class CSMinJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        // int[] dp = new int[n];
        // //base case
        // dp[n - 1] = 0;  //?
        
        // for(int i = n - 2; i >= 0; i--){
        //     int maxjump = arr[i];
        //     int min = Integer.MAX_VALUE;
        //     for(int jump = 1; jump <= maxjump; jump++){
        //         if(i + jump < n){
        //             min = Math.min(min,dp[i + jump]);
        //         }
        //     }
        //     if(min == Integer.MAX_VALUE){
        //         dp[i] = Integer.MAX_VALUE;
        //     }else{
        //         dp[i] = min + 1;
        //     }
        // }
        
        // System.out.println(dp[0]);
        System.out.println(csmm(arr));
    }
    
    public static int csmm(int[] arr){
        int moves = 0;
        for(int i = 0 ; i < arr.length;){
            
            int maxjump = arr[i];
            int max = 0;
            int idx = i;
            for(int j = 1; j <= maxjump; j++){
                if(i + j >= arr.length - 1){
                    moves++;
                    return moves;
                }
                if(i + j < arr.length){
                    if(max  < i + j + arr[i + j]){
                        max = i + j + arr[i + j];
                        idx = i + j;
                    }
                }
            }
            i = idx;
            moves++;
            
        }
        return moves;
    }

}