class DigitMult {
    static String getSmallest(Long N) {
        // code here
        if(N == 1){
            return "1";
        }
        
        long[] arr = new long[10];
        for(int i = 9; i >= 2; i--){
            while(N % (long)i == 0){
                N /= i;
                arr[i]++;
            }
        }
        
        if(N != 1){
            return "-1";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= 9; i++){
            while(arr[i]-- > 0){
                sb.append(i);
            }
        }
        
        return sb.toString();
        
    }
};