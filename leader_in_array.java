import java.util.*;
public class leader_in_array {
    /*Time Complexity: O(N^2) { Since there are nested loops being used, at the worst case n^2 time would be consumed }.
Space Complexity: O(N) { There is no extra space being used in this approach. But, a O(N) of space for ans array will be used in the worst case }. */
public class bruteforce {
    public static List< Integer > superiorElements(int []a) {
        ArrayList<Integer> alist=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            boolean leader=true;
            for(int j=i+1;j<a.length;j++){
                if(a[j]>=a[i]){
                     leader=false; 
                     break;
                }
            }
            if(leader) alist.add(a[i]);
        }
        Collections.sort(alist);
        return alist;
    }
/*Time Complexity: O(N) { Since the array is traversed single time back to front, it will consume O(N) of time where N = size of the array }.

Space Complexity: O(N) { There is no extra space being used in this approach. But, a O(N) of space for ans array will be used in the worst case }. */
public class optimal {
    public static List< Integer > superiorElements(int []a) {
       ArrayList<Integer> alist= new ArrayList<>();
        int n=a.length;
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(a[i]>max) {
                max=a[i];
                alist.add(a[i]);
            }
        }
        return alist;
    }
}
}
}
