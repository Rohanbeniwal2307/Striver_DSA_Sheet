import java.util.ArrayList;

public class rearrange_posAndNeg_inArray {
/*Brute force
Time Complexity:O(N+N/2)     { O(N) for traversing the array once for segregating positives and negatives 
and another O(N/2) for adding those elements alternatively to the array, where N = size of the array A}.

Space Complexity:O(N/2 + N/2) = O(N)    { N/2 space required for each of the positive and negative element
 arrays, where N = size of the array A}.*/ 
 class bruteForce {
    public int[] rearrangeArray(int[] nums) {
         ArrayList<Integer> apos= new ArrayList<>();
         ArrayList<Integer> aneg= new ArrayList<>();
         int n=nums.length;
         for(int i=0;i<n;i++){
             if(nums[i]>0) apos.add(nums[i]);
             else aneg.add(nums[i]);
             
             }
             for(int i=0;i<n/2;i++){
                 nums[2*i]=apos.get(i);
                 nums[(2*i)+1]=aneg.get(i);
             }
             return nums;
    }
}
/*
 optimal approch 
 Time Complexity: O(N) { O(N) for traversing the array once and substituting positives and negatives 
simultaneously using pointers, where N = size of the array A}.

Space Complexity:  O(N) { Extra Space used to store the rearranged elements separately in an array, 
where N = size of array A}.
 */
class optimal{
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int arr[]= new int[n];
        int posindex=0;
        int negindex=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr[posindex]=nums[i];
                posindex+=2;
            } 
            else {
                arr[negindex]=nums[i];
                negindex+=2;
            }
        }    
        return arr;
    }
}
}
