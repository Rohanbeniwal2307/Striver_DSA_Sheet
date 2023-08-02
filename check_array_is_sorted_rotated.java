//brute force 

class Btute_force {
  static boolean isSorted(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[i])
          return false;
      }
    }

    return true;
  }
}

//optimal 
class Solution {
    public boolean check(int[] A) {
       int k = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (A[i] > A[(i + 1) % n]) {//  "%n" is making a array simple to rotated
                k++;
            }
            if (k > 1) { //greater than 1 isliye h kyunki hum 1 tak  bear kr sakte h kyunki jb wo
                // rotated array jb khni khtm ho rhi hogi to element wo usse smaller rhega  isliye bs 1 hoga 
                return false;
            }
        }
        return true;
    }
}