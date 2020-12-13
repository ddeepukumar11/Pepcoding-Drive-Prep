import java.io.*;
import java.util.*;

public class Climbstairs {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn  = new Scanner(System.in);
        int n = scn.nextInt();
        
        System.out.println(cst(n));
    }
    
    public static int cs(int n, int[] dp){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int f1 = cs(n - 1, dp);
        int f2 = cs(n - 2,dp);
        int f3 = cs(n - 3,dp);
        dp[n] = f1 + f2 + f3;
        
        return f1 + f2 + f3;
    }
    
    public static int cst(int n){
        int[] dp = new int[n + 1];
        
        dp[0] = 1; //? 
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i - 1];
            if(i >= 2){
                dp[i] += dp[i - 2];
            }
            if(i >= 3){
                dp[i] += dp[i - 3];
            }
        }
        
        return dp[n];
    }

}