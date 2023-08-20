import java.util.ArrayList;
import java.util.List;
// this problem has 3 variety ... 
// variety 1
// variety 2
// variety -3
public class pascal {
    /*Time Complexity: O(n*n*r) ~ O(n3), where n = number of rows, and r = column index.
Reason: The row loop will run for approximately n times. And generating a row using the naive approach of variation 2 takes O(n*r) time complexity.

Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can be still considered as O(1). */
    class BruteForcevariety3 {
    public static int nCr(int n,int r){
        long res=1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return (int) res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            ArrayList<Integer> templist= new ArrayList<>();
            for(int col=1;col<=row;col++){
                templist.add(nCr(row-1,col-1));
            }
            ans.add(templist);
        }
        return ans;
    }
}
/*Time Complexity: O(n2), where n = number of rows(given).
Reason: We are generating a row for each single row. The number of rows is n. And generating an entire row takes O(n) time complexity.

Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can still be considered as O(1). */
class Optimalvariety3 {
    public static List<Integer> genraterow(int row){
        long ans=1;
        ArrayList<Integer> ansRow=new ArrayList<>();
        ansRow.add(1);
        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans=ans/col;
            ansRow.add((int)ans);

        }
        return ansRow;
    
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer=new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            answer.add(genraterow(row));
        }
        return answer;
    }
}
}
