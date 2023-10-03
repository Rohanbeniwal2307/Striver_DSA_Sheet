import java.util.Arrays;

public class merge_sorted_array {
    class BruteForce {
    // brute force solution of time complexity (m+n)log m+n and space complexity is constant
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}
class Better {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // better approch taking space (m+n) and time (m+n)
        int left=0;
        int right=0;
        int index=0;
        int nums3[]= new int[m+n];
        while(left<m && right<n){
            if(nums1[left]<=nums2[right]){
                nums3[index++]=nums1[left++];
            }
            else{
                nums3[index++]=nums2[right++];
            }
        }
        while(left<m){  nums3[index++]=nums1[left++];
                     }
        while(right<n){
            nums3[index++]=nums2[right++];
                      }
        for(int j=0;j<m+n;j++){
            nums1[j]=nums3[j];
        }
    }
}
class NearlyOptimal {// this is not the optimal solution but nearly about the optimal solution of time complexity m+n*(log m+n)
    public static void swap(int left, int right, int [] nums1){
        int temp=nums1[left];
        nums1[left]=nums1[right];
        nums1[right]=temp;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
         int gap = ((m+n)/ 2) + ((m+n) % 2);
        while(gap>0){
            int left=0;
            int right=left+gap;
            while(right<n+m){
                if(nums1[left]>nums1[right]){
                    swap(left,right,nums1);
                    
                }
               left++;
               right++;

            }
            if(gap==1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }
}
class optimal {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // optimal approch of time complexity m+n and space constant
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }
            else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }
}
}
