class PizzaSlices {
    public int maxSizeSlices(int[] slices) {
        if(slices.length < 3){
            return 0;
        }
        
        if(slices.length == 3){
            return Math.max(slices[0],Math.max(slices[1], slices[2]));
        }
        int[] a = new int[slices.length - 1];
        int[] b = new int[slices.length - 3];
        
        for(int i = 0 ; i < slices.length; i++){
            if(i >= 1){
                a[i - 1] = slices[i];
            }
            
            if(i >= 2 && i <= slices.length - 2){
                b[i - 2] = slices[i];
            }
        }
        int n = slices.length;
        int f1 = maxSum(a,n / 3);
        int f2 = slices[0] + maxSum(b, n / 3 - 1);
        return Math.max(f1,f2);
    }
    
    public int maxSum(int[] arr, int k){
        if(arr.length == 0){
            return 0;
        }
        int n = arr.length;
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
        
        return (Math.max(inc[n - 1][k], exc[n - 1][k]));

    } 
}