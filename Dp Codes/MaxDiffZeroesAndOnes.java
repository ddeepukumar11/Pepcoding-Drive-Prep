import java.io.*;
import java.util.*;

public class MaxDiffZeroesAndOnes {

	public static int solution(String str) {
		int ssf = -1;
		int max = -1;
		
		for(int i = 0 ; i < str.length(); i++){
		    char ch = str.charAt(i);
		    int val = ch == '0' ? 1 : -1;
		    if(ssf >= 0){
		        ssf += val;
		    }else{
		        ssf = val;
		    }
		    max = Math.max(max,ssf);
		}

		return max;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}