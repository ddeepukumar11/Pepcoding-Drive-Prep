import java.io.*;
import java.util.*;

public class countABCSubseq {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        int c1 = 0, c2 = 0, c3 = 0;
        
        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a'){
                c1 = (2 * c1) + 1;
            }else if(ch == 'b'){
                c2 = (2 * c2) + c1;
            }else{
                c3 = (2 * c3) + c2;
            }
        }
        System.out.println(c3);
    }
}