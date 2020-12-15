import java.io.*;
import java.util.*;

public class MaxSum2NonOverlapping {

	public static int solution(int[] arr, int x, int y){
	    int n = arr.length;
		int[] a1 = new int[n];
		int[] a2 = new int[n];
		
		int ssf = 0;
		int j =0 ;
		int prefixSum = 0;
		for(int i = 0 ; i < n; i++){
		    ssf += arr[i];
		    if(i == x - 1){
		        a1[i] = ssf;
		    }else if(i > x - 1){
		        prefixSum += arr[j];
		        j++;
		        a1[i] = Math.max(a1[i - 1], ssf - prefixSum);
		    }
		}
		
		ssf =0;
		prefixSum = 0;
		 j = n - 1;
		for(int i = n - 1; i >= 0; i--){
		    ssf += arr[i];
		    if(i == n - y){
		        a2[i] = ssf;
		    }else if(i < n - y){
		        prefixSum += arr[j];
		        j--;
		        a2[i] = Math.max(a2[i + 1], ssf - prefixSum);
		    }
		}
		
		int f1 = 0;
		for(int z = x - 1; z <= n - y - 1; z++){
		    f1 = Math.max(f1,a1[z] + a2[z + 1]);
		}

		return f1;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(arr,x,y));
	}

}