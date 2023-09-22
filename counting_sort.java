public class counting_sort {
    
        public static void countingSort(int[] arr) {
            int max = arr[0];
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            
          
            int range = max - min + 1;
            int[] countArray = new int[range];
            
            
            for (int i = 0; i < arr.length; i++) {
                countArray[arr[i] - min]++;
            }
            
            
            int index = 0;
            for (int i = 0; i < range; i++) {
                while (countArray[i] > 0) {
                    arr[index] = i + min;
                    index++;
                    countArray[i]--;
                }
            }
        }
    
        public static void main(String[] args) {
            int[] arr = {4, 2, 2, 8, 3, 3, 1};
            countingSort(arr);
            
           
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }
    

