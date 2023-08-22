import java.util.HashMap;
import java.util.Map;

public class subaaray_with_xor {
   
/*
 *tc--> O(N^3)
 */
        public static int brute(int []a, int k) {
            int n = a.length; //size of the given array.
            int cnt = 0;
    
            // Step 1: Generating subarrays:
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
    
                    //step 2:calculate XOR of all
                    // elements:
                    int xorr = 0;
                    for (int K = i; K <= j; K++) {
                        xorr = xorr ^ a[K];
                    }
    
                    // step 3:check XOR and count:
                    if (xorr == k) cnt++;
                }
            }
            return cnt;
        }

        public static int better(int []a, int k) {
            /*tc --> O(N^2) */
            int n = a.length; //size of the given array.
            int cnt = 0;
    
            // Step 1: Generating subarrays:
            for (int i = 0; i < n; i++) {
                int xorr = 0;
                for (int j = i; j < n; j++) {
    
                    //step 2:calculate XOR of all
                    // elements:
                    xorr = xorr ^ a[j];
    
                    // step 3:check XOR and count:
                    if (xorr == k) cnt++;
                }
            }
            return cnt;
        }
     public static int optimal(int []a, int k) {
        /*
         *
         * Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array. Point to remember for unordered_map in the worst case, the searching time increases to O(N), and hence the overall time complexity increases to O(N2). 

Space Complexity: O(N) as we are using a map data structure.
         */
        int n = a.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
    }

}
