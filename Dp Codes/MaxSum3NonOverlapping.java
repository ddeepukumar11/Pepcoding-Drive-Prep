class Solution {
    public int[] maxSumOfThreeSubarrays(int[] arr, int k) {
        if(arr == null || arr.length < 3 * k){
            return null;
        }
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] prefix = new int[n];
        
        for(int i = 0 ; i < n; i++){
            if(i == 0){
                prefix[i] = arr[i];
            }else{
                prefix[i] = prefix[i - 1] + arr[i];
            }
        }
        
        int ssf = 0;
        int i = 0;
        for(; i< n; i++){
            ssf += arr[i];
            if(i == k - 1){
                left[i] = ssf;
            }else if(i > k - 1){
                left[i] = Math.max(left[i - 1], ssf - prefix[i - k]);
            }
        }
        
        
        
        i = n - 1;
        ssf = 0;
        int psum = 0;
        for(; i >= 0; i--){
            ssf += arr[i];
            if(i == n - k){
                right[i] = ssf;
            }else if(i < n- k){
                psum += arr[i + k];
                right[i] = Math.max(right[i + 1], ssf - psum);
            }
        }
        
       
        
        int[] ans = new int[3];
        int max = 0;
        for(i = k; i <= n - (2 * k); i++){
            if(left[i - 1] + right[i + k] + (prefix[i + k - 1] - prefix[i - 1]) > max){
                max = left[i - 1] + right[i + k] + (prefix[i + k - 1] - prefix[i - 1]);
                ans[0] = i - k;
                ans[1] = i; 
                ans[2] = i + k;
            }
        }
        
       
         int lsum = 0;
        for(int j = 0 ; j <= ans[0]; j++){
           
            if(j == 0){
                lsum = prefix[k - 1];
            }else{
                lsum = prefix[j + k - 1] - prefix[j - 1];
            }
            if(lsum == left[ans[0] + k - 1]){
                ans[0] = j;
                break;
            }
        }
        
        for(int j = ans[2]; j <= n - k; j++){
            // System.out.println("hello");
            if((prefix[j + k - 1] - prefix[j - 1]) == right[ans[2]]){
                ans[2] = j;
                break;
            }
        }
        
        return ans;
    }
}