import java.io.*;
import java.util.*;

public class ArrangeBuildings{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    
    long eat0 = 1;
    long eat1 = 1;
    
    for(int i = 2; i <= n; i++){
        long temp = eat0;
        eat0 = eat1;
        eat1 = temp + eat1;
    }
    
    long x = eat0 + eat1;
    System.out.println(x * x);
 }

}