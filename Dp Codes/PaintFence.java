import java.io.*;
import java.util.*;

public class PaintFence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long same = k;
        long diff = k * (k - 1);
        if(n == 0){
            System.out.println("0");
            return;
        }else if(n == 1){
            System.out.println(k);
            return;
        }
        
        for(int i = 3; i <= n; i++){
            long ns = diff;
            long nd = (same + diff) * (k - 1);
            same = ns;
            diff = nd;
        }
        long ans = same + diff;
        System.out.println(ans);
    }
}