
    

// brute force 
// Tc--> N*3


public class longest_subarray_ofSumk_Pos {
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { 
            for (int j = i; j < n; j++) { 
                
                long s = 0;
                for (int K = i; K <= j; K++) {
                    s += a[K];
                }

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
    


// Better 1
// Tc --> n*2

public class Better1 {
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; 

        int len = 0;
        for (int i = 0; i < n; i++) { 
            long s = 0; 
            for (int j = i; j < n; j++) {
            
                s += a[j];

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}

// solution 3 using hashmap 







// soln 4 
// Time Complexity: O(2*N), where N = size of the given array.
//Reason: The outer while loop i.e. the right pointer can move up to index n-1(the last index). Now, the inner while loop i.e. the left pointer can move up to the right pointer at most. So, every time the inner loop does not run for n times rather it can run for n times in total. So, the time complexity will be O(2*N) instead of O(N2).


//optimal approch using 2 pointer
public class Better3 {
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; 

        int left = 0, right = 0; 
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
          
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}

}



