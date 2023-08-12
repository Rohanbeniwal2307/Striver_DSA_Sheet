import java.util.ArrayList;
import java.util.Arrays;

public class rearrange_posAndNeg_inArray {
/*Brute force
Time Complexity:O(N+N/2)     { O(N) for traversing the array once for segregating positives and negatives 
and another O(N/2) for adding those elements alternatively to the array, where N = size of the array A}.

Space Complexity:O(N/2 + N/2) = O(N)    { N/2 space required for each of the positive and negative element
 arrays, where N = size of the array A}.*/ 
 class bruteForce {
    public int[] rearrangeArray(int[] nums) {
         ArrayList<Integer> apos= new ArrayList<>();
         ArrayList<Integer> aneg= new ArrayList<>();
         int n=nums.length;
         for(int i=0;i<n;i++){
             if(nums[i]>0) apos.add(nums[i]);
             else aneg.add(nums[i]);
             
             }
             for(int i=0;i<n/2;i++){
                 nums[2*i]=apos.get(i);
                 nums[(2*i)+1]=aneg.get(i);
             }
             return nums;
    }
}
/*
 optimal approch 
 Time Complexity: O(N) { O(N) for traversing the array once and substituting positives and negatives 
simultaneously using pointers, where N = size of the array A}.

Space Complexity:  O(N) { Extra Space used to store the rearranged elements separately in an array, 
where N = size of array A}.
 */
class optimal{
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int arr[]= new int[n];
        int posindex=0;
        int negindex=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr[posindex]=nums[i];
                posindex+=2;
            } 
            else {
                arr[negindex]=nums[i];
                negindex+=2;
            }
        }    
        return arr;
    }
}
/* 
 * variety 2 
 * Time Complexity: O(2*N) { The worst case complexity is O(2*N) which is a combination of O(N) of traversing the array to segregate into neg and pos array and O(N) for adding the elements alternatively to the main array}.

Explanation: The second O(N) is a combination of O(min(pos, neg)) + O(leftover elements). There can be two cases: when only positive or only negative elements are present, O(min(pos, neg)) + O(leftover) = O(0) + O(N), and when equal no. of positive and negative elements are present, O(min(pos, neg)) + O(leftover) = O(N/2) + O(0). So, from these two cases, we can say the worst-case time complexity is O(N) for the second part, and by adding the first part we get the total complexity of O(2*N).

Space Complexity:  O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays, where N = size of the array A}.
 */
public class Main {
    public static void main(String[] args) {
        // Array Initialization
        int n = 6;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

        ArrayList<Integer> ans = RearrangebySign(A, n);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
        // Define 2 ArrayLists, one for storing positive 
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }
}
}
