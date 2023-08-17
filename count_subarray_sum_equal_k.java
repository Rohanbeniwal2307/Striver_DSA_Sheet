import java.util.HashMap;

public class count_subarray_sum_equal_k {
    class BruteForce {
        /*
         * Time Complexity: O(N3), where N = size of the array.
Reason: We are using three nested loops here. Though all are not running for exactly N times, the time complexity will be approximately O(N3).

Space Complexity: O(1) as we are not using any extra space.
         */
        public int subarraySum(int[] nums, int k) {
            int n=nums.length;
            int count=0;
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                  int sum=0;
                    for(int z=i;z<=j;z++){
                        sum=sum+nums[z];
                        
                    }
                    if(sum==k) count++;
                }
            }
            return count;
        }
    }
    class Better {
        /*
         * Time Complexity: O(N2), where N = size of the array.
Reason: We are using two nested loops here. As each of them is running for exactly N times, the time complexity will be approximately O(N2).

Space Complexity: O(1) as we are not using any extra space.
         */
        public int subarraySum(int[] nums, int k) {
            int n=nums.length;
            int count=0;
            for(int i=0;i<n;i++){ 
                int sum=0;
                for(int j=i;j<n;j++){
                 sum=sum+nums[j];
                 if(sum==k) count++;
                    
                }
            }
            return count;
        }
    }
    class optimal {
        /*
         * Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array.
Space Complexity: O(N) as we are using a map data structure.
         */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remove=sum-k;
            if(map.containsKey(remove)){
                count+=map.get(remove);
            }
           map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
}
