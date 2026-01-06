class Solution {
    public int removeElement(int[] nums, int val) {
        // 快慢指针：nums[i]!=val, move
        int n = nums.length;
        int s = 0;
        int f = 0;
        while(f<n){
            if(nums[f]!=val){
                nums[s]=nums[f];
                s++;
            }
            f++;
        }
        return s;
    }
}