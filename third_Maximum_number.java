 import java.util.Arrays;
public class third_Maximum_number {
   

class brute {
    // time complexity nlogn with constant space
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        if (n < 3) {
            return nums[n - 1]; 
        }
        int count = 1; 
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }
            
            if (count == 3) {
                return nums[i]; 
            }
        }
        
        return nums[n - 1];
    }
}
class optimal {
    // with linear time and constant space
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) {
                continue; // Skip duplicates
            }

            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }

        return max3 != null ? max3 : max1;
    }
}
}
