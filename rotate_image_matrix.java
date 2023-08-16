public class rotate_image_matrix {
    
        /*Time Complexity: O(N*N) to linearly iterate and put it into some other matrix.
    
    Space Complexity: O(N*N) to copy it into some other matrix. */
        class bruteforce {
            public void rotate(int[][] matrix) {
                 int n=matrix.length;
                int rotated[][] =new int[n][n];
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        rotated[j][n-i-1]=matrix[i][j];
                    }
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        matrix[i][j]=rotated[i][j];
                    }
                }
                
            }
        }
        class optimal {
            /*Time Complexity: O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other is for reversing the matrix.
    
    Space Complexity: O(1). */
            public void rotate(int[][] matrix) {
                int n=matrix.length;
               
                for(int i=0;i<=n-2;i++){
                    for(int j=i+1;j<=n-1;j++){
                        int temp=matrix[i][j];
                        matrix[i][j]=matrix[j][i];
                        matrix[j][i]=temp;
                    }
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<n/2;j++){
                        int temp=matrix[i][j];
                        matrix[i][j]=matrix[i][n-j-1];
                        matrix[i][n-j-1]=temp;
                    }
                }
            }
        }
    }

