// Better 1 
// Tc--> O(n)+O(n)
    class sort_Zero_OnesAndTwos {
        public void sortColors(int[] nums) {
            int index=0;
        int zero=0,one=0,two=0;
        for(int i=0;i<nums.length;i++)
        { if(nums[i]==0)zero++;
          if(nums[i]==1)one++;
          if(nums[i]==2)two++;
            }
            while(zero!=0)
            {
              nums[index++]=0;
              zero--;
            }
            while(one!=0)
            {
              nums[index++]=1;
              one--;
            }
            while(two!=0)
            {
              nums[index++]=2;
              two--;
            }
        }
        // optimal approch by using dutch algo 
        // Tc-->O(n)
        class Solution {
    public static void swap(int nums[],int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
            swap(nums,mid,low);
            mid++;
            low++;}
            else if(nums[mid]==1){mid++;}
            else{
                swap(nums,mid,high);
                high--;}
        }
    }
}
    }
    

