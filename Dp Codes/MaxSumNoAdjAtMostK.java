import java.io.*;
import java.util.*;

public class MaxSumNoAdjAtMostK {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        
        int[][] inc = new int[n][k + 1];
        int[][] exc = new int[n][k + 1];
        
        for(int j = 1 ; j <= k; j++){
            for(int i = 0 ; i < n; i++){
                if(i == 0){
                    inc[i][j] = arr[i];
                    exc[i][j] = 0;
                }else{
                    inc[i][j] = arr[i] + exc[i - 1][j - 1];
                    exc[i][j] = Math.max(inc[i - 1][j], exc[i - 1][j]);
                }
            }
        }
        
        System.out.println(Math.max(inc[n - 1][k], exc[n - 1][k]));
    }
}