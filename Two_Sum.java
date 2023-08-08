  // brute
  // Tc-->=N*2
 import java.util.*;
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

//optimal..by using hashmap 
/*  Time Complexity: O(N), where N = size of the array.
Reason: The loop runs N times in the worst case and searching in a hashmap takes O(1) generally. So the time complexity is O(N).

Note: In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. 
In that case, the time complexity will be O(N2). If we use map instead of unordered_map, 
the time complexity will be O(N* logN) as the map data structure takes logN time to find an element.

Space Complexity: O(N) as we use the map data structure.

Note: We have optimized this problem enough. But if in the interview, we are not allowed to use
 the map data structure, then we should move on to the following approach i.e. two pointer approach.
  This approach will have the same time complexity as the better approach.*/


class Solution2 {
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

