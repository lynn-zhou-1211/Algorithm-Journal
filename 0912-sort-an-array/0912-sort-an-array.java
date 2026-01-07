class Solution {
    // mergesort: 找中点-> 左右孩子排序-> 合并
    // merge: 拷贝-> 指针定位 ->数组归位
    int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(0,nums.length-1,nums);
        return nums;
    }

    private void mergeSort(int left, int right, int[] nums){
        // base case: 只有一个元素
        if(left>=right){
            return;
        }
        int mid = left+(right-left)/2;
        mergeSort(left,mid,nums);
        mergeSort(mid+1,right,nums);
        merge(left,mid,right,nums);
    }

    private void merge(int left,int mid, int right, int[] nums){
        for(int k = left;k<=right;k++){
            temp[k]=nums[k];
        }
        int i = left;
        int j = mid+1;
        for(int k = left;k<=right;k++){
            if(i==mid+1){
                nums[k]=temp[j];
                j++;
            }else if(j==right+1){
                nums[k]=temp[i];
                i++;
            }else if(temp[i]<=temp[j]){
                nums[k]=temp[i];
                i++;
            }else{
                nums[k]=temp[j];
                j++;
            }
        }
    }
}