import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {
    /*
     * Complexity Analysis
Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are just using a single loop that runs for N times. So, the time complexity will be O(N).

Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.
     */
    class optimal {
    public int[][] merge(int[][] nums) {
        List<int[]> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < n; i++) {
            
            if (ans.isEmpty() || nums[i][0] > ans.get(ans.size() - 1)[1]) {
    ans.add(new int[]{nums[i][0], nums[i][1]});
} else {
    ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], nums[i][1]);
}

        }
        int[][] mergedIntervals = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            mergedIntervals[i] = ans.get(i);}
        return mergedIntervals;
        
    }
}
class brute {
    /*
     * Time Complexity: O(N*logN) + O(2*N), where N = the size of the given array.
Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are using 2 loops i and j. But while using loop i, we skip all the intervals that are merged with loop j. So, we can conclude that every interval is roughly visited twice(roughly, once for checking or skipping and once for merging). So, the time complexity will be 2*N instead of N2.

Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervalsList = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (!mergedIntervalsList.isEmpty() && end <= mergedIntervalsList.get(mergedIntervalsList.size() - 1)[1]) {
                continue;
            }
            
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            
            mergedIntervalsList.add(new int[]{start, end});
        }

        int[][] mergedIntervals = new int[mergedIntervalsList.size()][2];
        for (int i = 0; i < mergedIntervalsList.size(); i++) {
            mergedIntervals[i] = mergedIntervalsList.get(i);
        }

        return mergedIntervals;
    }
}
}
