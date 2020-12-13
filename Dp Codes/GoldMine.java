import java.io.*;
import java.util.*;

public class GoldMine {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int[][] dp = new int[n][m];
        for(int j = m - 1; j >= 0; j--){
            for(int i = 0 ; i < n; i++){
                if(j == m - 1){ //last column -> Base case
                    dp[i][j] = arr[i][j];
                }else if(i == 0){ //first row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                }else if(i == n - 1){ //last row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                }else{ //middle row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1],Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]) );
                }
            }
        }
        
        int ans = 0;
        
        for(int row = 0; row < n; row++){
            ans = Math.max(ans,dp[row][0]);
        }
        System.out.println(ans);
    }

}