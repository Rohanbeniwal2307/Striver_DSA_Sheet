import java.util.HashSet;
//brute force tc=O(n*log(n))+O(n),sc=O(n) 
public class removeDulpicate {
      static int BruteForce(int[] arr) {// using set
        HashSet < Integer > set = new HashSet < > ();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x: set) {
            arr[j++] = x;
        }
        return k;
    }
    // optimal approch tc=O(O(n),sc=O(1) 
    static int optimal(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) { // using 2 pointer
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
