class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int curr = 0;
        // curr 遇到0动，遇到2不动
        while(curr<=r){
            if(nums[curr]==0){
                swap(nums,l,curr);
                l++;
                curr++;
            }else if(nums[curr]==2){
                swap(nums,r,curr);
                r--;
            }else{
                curr++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}