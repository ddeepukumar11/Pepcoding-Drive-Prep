import java.io.*;
import java.util.*;

public class CountEncodings {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            int cv = str.charAt(i - 1) - '0';
            int pv = str.charAt(i - 2) - '0';
            
            if(pv == 0){
                if(cv == 0){
                    dp[i] = 0;
                }else{
                    dp[i] = dp[i - 1];
                }
            }else if(cv == 0){
                if(Integer.parseInt(str.substring(i - 2, i)) <= 26){
                    dp[i] = dp[i - 2];
                }
            }else{
                dp[i] = dp[i - 1];
                if(Integer.parseInt(str.substring(i - 2, i)) <= 26){
                    dp[i] += dp[i - 2];
                }
            }
            
        }
        
        System.out.println(dp[n]);
        
    }
}