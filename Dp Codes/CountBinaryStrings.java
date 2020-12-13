import java.io.*;
import java.util.*;

public class CountBinaryStrings{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    
    int eat0 = 1;
    int eat1 = 1;
    
    for(int i = 2; i <= n; i++){
        int temp = eat0;
        eat0 = eat1;
        eat1 = temp + eat1;
    }
    
    System.out.println(eat0 + eat1);
 }

}