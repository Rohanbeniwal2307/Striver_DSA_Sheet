public class set_matrix_zeros {
    /*Time Complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Reason: Firstly, we are traversing the matrix to find the cells with the value 0. It takes O(N*M). Now, whenever we find any such cell we mark that row and column with -1. This process takes O(N+M). So, combining this the whole process, finding and marking, takes O((N*M)*(N + M)).
Another O(N*M) is taken to mark all the cells with -1 as 0 finally.

Space Complexity: O(1) as we are not using any extra space. */
    class bruteforce {
        public static void markrow(int[][] matrix,int i,int m,int n){
            for(int j=0;j<n;j++){
                if(matrix[i][j]!=0) matrix[i][j]=-100001;
                // -100001 is number we set expecting this number is not in the testcases that`s why unique number 
            }
        }
        public static void markcol(int [][] matrix,int j,int m,int n){
            for(int i=0;i<m;i++){
                if(matrix[i][j]!=0) matrix[i][j]=-100001;
            }
        }
        public void setZeroes(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]==0){
                        markrow(matrix,i,m,n);
                        markcol(matrix,j,m,n);
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
    
                    if(matrix[i][j]==-100001) matrix[i][j]=0;
                }
            }
            
        }
    }
    class Better {
        /*Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Reason: We are traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.

Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Reason: O(N) is for using the row array and O(M) is for using the col array. */
        public void setZeroes(int[][] matrix) {
          
            int m=matrix.length;
            int n=matrix[0].length;
              int[] row=new int [m];
            int[] col=new int [n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]==0){
                        row[i]=1;
                        col[j]=1;
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(row[i]==1 || col[j]==1){
                        matrix[i][j]=0;
                    }
                }
            }
        }
    }class optimal{
        /*Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Reason: In this approach, we are also traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.

Space Complexity: O(1) as we are not using any extra space. */
        public void setZeroes(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
    
            int x=1;
            int y=1;
            for(int j=0;j<n;j++){
                if(matrix[0][j]==0) x=0;
            }
            for(int i=0;i<m;i++){
                if(matrix[i][0]==0) y=0;
            }
            
            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    if(matrix[i][j]==0){
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0){
                    for(int i=1;i<m;i++){
                        matrix[i][j]=0;
                    }
                }
            }
            for(int i=1;i<m;i++){
                if(matrix[i][0]==0){
                    for(int j=1;j<n;j++){
                        matrix[i][j]=0;
                    }
                }
            }
            
             if(y==0){
                for( int i=0;i<m;i++){
                    matrix[i][0]=0;
                }
            }
            if(x==0){
                for(int j=0;j<n;j++){
                    matrix[0][j]=0;
                }
            }
        }
    }

}
