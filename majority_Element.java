// brute force Tc--> O(n*2)
import java.util.*;
    class majority_Element {
        public int majorityElement(int[] nums) {
            int n=nums.length;
            for(int i=0;i<n;i++){
                int count=0;
                for(int j=0;j<n;j++){
                    if(nums[i]==nums[j])count++;
                }
                if(count>n/2) return nums[i];
            }
            return 0;
        }
    }
    // Better 1--> using hashmap
    // Tc-->O(nlogn)+O(n)
    // Sc-->O(n)
    class Solution2 {
    public int majorityElement(int[] nums) {
        int n=nums.length;
       HashMap<Integer,Integer> map= new HashMap<>();
       for(int i=0;i<n;i++){
           if(!map.containsKey(nums[i])){map.put(nums[i],1);}
          else{
              map.put(nums[i],map.get(nums[i])+1);
          }
       }
       for(Map.Entry<Integer,Integer> entry: map.entrySet()){
           if(entry.getValue()>n/2) return entry.getKey();
       }
       return 0;
    }
}
// optimal approch by using moore's algorithm
//Tc--> O(N) + O(N)
class Solution3 {
    public int majorityElement(int[] nums) {
          int n=nums.length;
          int el=0;
           int count=0;
           
           int ans=0;;
          for(int i=0;i<n;i++){
              if(count==0){
                  count=1;
                  el=nums[i];
              }
              else if(nums[i] == el) count++;
              else count--;
          }
          for(int i=0;i<n;i++){
              if(nums[i]==el){ans++;}
          }
          if(ans>n/2) return el;
        return -1;
    }
}

