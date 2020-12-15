import java.io.*;
import java.util.*;

public class Tiling2 {

	public static int solution(int n) {
	    if(n == 1){
	        return 1;
	    }else if(n == 2){
	        return 2;
	    }else if(n == 3){
	        return 5;
	    }
	    
	    int mod = 1000000007;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 5;
		
		for(int i = 4; i <= n; i++){
		    dp[i] = (((2 * dp[i - 1]) % mod) + (dp[i - 3] % mod)) % mod;
		}
		

		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}