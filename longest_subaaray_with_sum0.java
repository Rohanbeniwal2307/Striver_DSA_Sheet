import java.util.*;
/*
 *  Tc=O(N^3)
 * Sc=O(1)
 */
public class longest_subaaray_with_sum0 {
    public class BruteForce {
        public static int getLongestZeroSumSubarrayLength(int []arr){
            int n=arr.length;
            int longest=0;
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    int sum=0;
                    for(int k=i;k<=j;k++){
                        sum+=arr[k];
                        if(sum==0){
                            longest=Math.max(longest,k-i+1);
                        }
                    }
                }
            }
            return longest;
        }
    }
    public class Better {
        /*
         * Time Complexity: O(N^2) as we have two loops for traversal

Space Complexity: O(1) as we aren’t using any extra space.
         */
        public static int getLongestZeroSumSubarrayLength(int []arr){
            int n=arr.length;
            int longest=0;
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=i;j<n;j++){
                     sum+=arr[j];
                        if(sum==0){
                            longest=Math.max(longest,j-i+1);
                        }
                    
                }
            }
            return longest;
        }
    }
    
public class optimal {
    /*
     * Time Complexity: O(N), as we are traversing the array only once

Space Complexity: O(N), in the worst case we would insert all array elements prefix sum into our hashmap
     */
    public static int getLongestZeroSumSubarrayLength(int []arr){
        HashMap<Integer,Integer> mpp= new HashMap<Integer,Integer>();
        int n=arr.length;
        int sum=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
              maxi=i+1;
            }
            else if(mpp.get(sum)!=null){
                maxi=Math.max(maxi,i-mpp.get(sum));
            }
            else{
                mpp.put(sum,i);
            }
        }
        return maxi;
    }
}
}
