import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {
 /*Time Complexity: O(m x n) { Since all the elements are being traversed once and there are total n x m elements ( m elements in each row and total n rows) so the time complexity will be O(n x m)}.

Space Complexity: O(n) { Extra Space used for storing traversal in the ans array }. */
    class solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> a=new ArrayList<>();
        int left=0;
        int n=matrix[0].length;
        int top=0;
        int m=matrix.length;
        int right=n-1;
        int bottom=m-1;
        while(left<=right && top<=bottom){
        for(int i=top;i<=right;i++){
            a.add(matrix[top][i]);
        }
        top++;
        for(int i=top;i<=bottom;i++){
            a.add(matrix[i][right]);
        }
    right--;
    if(top<=bottom){
        for(int i=right;i>=left;i--){
            a.add(matrix[bottom][i]);
                                    }
                    } 
        bottom--;
        if(left<=right){
        for(int i=bottom;i>=top;i--){
            a.add(matrix[i][left]);
        }
        }
        left++;

        }
        return a;
    }
}
}
