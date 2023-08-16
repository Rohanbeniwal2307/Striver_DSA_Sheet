import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longest_consecutive_sequence {
    /*Time Complexity: O(N2), N = size of the given array.
Reason: We are using nested loops each running for approximately N times.

Space Complexity: O(1), as we are not using any extra space to solve this problem. */
    class bruteforce {
        public static boolean linearsearch(int [] num,int z){
                for(int j=0;j<num.length;j++){
                    if(num[j]==z) return true;
                    
                }
                 return false;
            }
        public int longestConsecutive(int[] nums) {
            int x;
            
            int n=nums.length;
            int longest=0;
            for(int i=0;i<n;i++){
                x=nums[i];
               int count=1;
                while(linearsearch(nums,x+1)){
                    x++;
                    count++;
                }
                longest=Math.max(longest,count);
            }
            return longest;
        }
    }
    /*Time Complexity: O(NlogN) + O(N), N = size of the given array.
Reason: O(NlogN) for sorting the array. To find the longest sequence, we are using a loop that results in O(N).

Space Complexity: O(1), as we are not using any extra space to solve this problem. */
    class optimal1 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int longest=0;
        int nextsmaller=Integer.MIN_VALUE;
        int count=1;
        for(int i=0;i<n;i++){
            if(nums[i]-1==nextsmaller){
                nextsmaller=nums[i];
                count++;
                
            }
            else if(nums[i]!=nextsmaller){
                nextsmaller=nums[i];
                count=1;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
}
/*Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
Reason: O(N) for putting all the elements into the set data structure. After that for every starting element, we are finding the consecutive elements. Though we are using nested loops, the set will be traversed at most twice in the worst case. So, the time complexity is O(2*N) instead of O(N2).

Space Complexity: O(N), as we are using the set data structure to solve this problem.

Note: The time complexity is computed under the assumption that we are using unordered_set and it is taking O(1) for the set operations. 

If we consider the worst case the set operations will take O(N) in that case and the total time complexity will be approximately O(N2). 
And if we use the set instead of unordered_set, the time complexity for the set operations will be O(logN) and the total time complexity will be O(NlogN). */
class optimal2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        int count=1;
        int longest=0;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int it: set){
            if(!set.contains(it-1)){
                count=1;
                int x=it;
                while(set.contains(x+1)){
                    x++;
                    count++;
                }
                longest=Math.max(longest,count);
            }
            
        }
        return longest;
    }
}
}
