/*  // brute
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}
        //optimal
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] twoSum(int[] nums, int target)
     {
        Map<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<nums.length;j++)
        {
        if(map.containsKey(target-nums[j]) )
             {
            return new int [] {map.get(target-nums[j]),j};  
              }
        map.put(nums[j],j);
        }
        return new int[] {};
    }
}
*/
