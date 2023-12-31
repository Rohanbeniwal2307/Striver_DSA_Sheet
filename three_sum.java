import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class three_sum {
    /*
     * Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.
Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
     */
    class bruteforce {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> st= new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp= Arrays.asList(nums[i],nums[j],nums[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans= new ArrayList<>(st);
        return ans;

    }
}
class better {
    /*
     * Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array.
Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st= new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            HashSet<Integer> hashset= new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third=-(nums[i]+nums[j]);
                if(hashset.contains(third))
                {
                    List<Integer> temp= Arrays.asList(nums[i],nums[j],third);
                    temp.sort(null);
                    st.add(temp);

                }
                hashset.add(nums[j]);
            }
        }
        List<List<Integer>> ans= new ArrayList<>(st);
        return ans;
    }
}
class optimal {
    /*
     * Complexity Analysis
Time Complexity: O(NlogN)+O(N2), where N = size of the array.
Reason: The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 

Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).
     */
    public List<List<Integer>> threeSum(int[] nums) {
       ArrayList<List<Integer>> ans=new ArrayList<>();
       Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i] ==nums[i-1] ) continue;
            int j=i+1;
            int k= n-1;
            while(j<k){
                int sum= nums[i]+nums[j]+nums[k];
                if(sum<0){ j++; }
                else if(sum>0){k--;}
                else{
                    List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                } 

            }
        }
        return ans;
    }
}
}
