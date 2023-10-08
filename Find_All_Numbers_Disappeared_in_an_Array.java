import java.util.*;


public class Find_All_Numbers_Disappeared_in_an_Array {
    class brute {
    // brute force with time n^2 and space constant
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> a= new ArrayList<>();
       
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        // finding what is max
        for(int i=0;i<n;i++){
            if(max<nums[i]) max=nums[i];
        }
        if(max<n) max=n;  // if n or last element is missing in the array 
        for(int i=1;i<=max;i++){
            boolean check=false;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    check=true;
                }
            }
            if(!check) a.add(i);
        }
        return a;
    }
}
class better {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> a= new ArrayList<>();
        HashSet<Integer>set= new HashSet<>();
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(max<nums[i]) max=nums[i];
        }
        if(max<n) max=n;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int i=1;i<=max;i++){
            if(!set.contains(i)) a.add(i);
        }
         return a;
        
    }
}
class optimal {
    // better solution with linear time and space complexity 
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> a= new ArrayList<>();
        HashSet<Integer>set= new HashSet<>();
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        // finding what is max
        for(int i=0;i<n;i++){
            if(max<nums[i]) max=nums[i];
        }
        if(max<n) max=n;  // if n or last element is missing in the array 
       for(int i=0;i<n;i++){
           int idx=Math.abs(nums[i])-1;
           if(nums[idx]<0) continue;
           nums[idx]*=-1;
          
       }
       for(int i=0;i<n;i++){
           if(nums[i]>0) a.add(i+1);
       }
       return a;
    }
}
}
