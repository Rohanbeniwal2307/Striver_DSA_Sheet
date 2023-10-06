import java.util.Arrays;
import java.util.HashMap;

public class contains_Duplicate_2 {
    class Brute {
        // brute force solution with time complexity n^2
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            
                for(int i=0;i<nums.length;i++){
                    for(int j=i+1;j<nums.length;j++){
                        if(j-i<=k){
                            if(nums[i]==nums[j]) return true;
                        }
                    }
                }
                return false;
                }
    }

class better {
     // Define a custom Pair class to represent element value and original index
    class Pair implements Comparable<Pair> {
        int first; // Element value
        int second; // Original index

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        // Implement compareTo method for sorting based on element values
        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // better problem time nlogn and space n
        int n=nums.length;
        Pair arr[]= new Pair[n];
        for(int i=0;i<nums.length;i++){
            arr[i]= new Pair(nums[i],i);
        }
        Arrays.sort(arr);
        for(int i=1;i<nums.length;i++){
            if((arr[i].first==arr[i-1].first) && (Math.abs(arr[i].second-arr[i-1].second) <=k)) return true;
        }
        return false;

    }
}
class optimal {
    // optimal approch with linear time and space commplexity 
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int val=map.get(nums[i]);
                if((i-val)<=k) return true;

            }
                map.put(nums[i],i);

        }
        return false;
    }
}
}
