
    
// Brute force --> tc=O(N*2)

import java.util.*;

public class findingThe_NumberThat_appear_once {
    public static int getSingleElement(int []arr) {
  
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int num = arr[i]; 
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == num)
                    cnt++;
            }

            if (cnt == 1) return num;
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);

    }




// Better 1 approch 
// Tc-->Time Complexity: O(N)+O(N)+O(N), where N = size of the array
// Sc-->Space Complexity: O(maxElement+1) where maxElement = the maximum element of the array.

//Using Hasing array
public class tUf {
    public static int getSingleElement(int []arr) {
 
        int n = arr.length;

        int maxi = arr[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        int[] hash = new int[maxi + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);

    }
}




// Better approch 2
// TC-->Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
// SC-->Space Complexity: O(M) as we are using a map data structure. Here M = size of the map i.e. M = (N/2)+1.

// using by hashmap
public class tUfd {
    public static int getSingleElement(int []arr) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);

    }
}
// Better 3 
// TC= NlogN+N due to sorting 

// using by logical approch 
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(i%2==0 && nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
// optimal approch 
// TC--> O(N)
class Solution2 {
    public int singleNumber(int[] nums) {
       int res=nums[0];
        for(int i=1;i<nums.length;i++){
            res=res^nums[i];
        }
        return res;
    }
}
}