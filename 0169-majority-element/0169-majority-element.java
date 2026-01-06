class Solution {
    public int majorityElement(int[] nums) {
        // 摩尔投票法：时间O(N); 空间O(1)
        // 维护一candidate和count, 相同++，不同--，清空换人
        int candidate = nums[0];
        int count = 1;
        for(int i =1;i<nums.length;i++){
            if(count ==0){
                candidate = nums[i];
                count = 1;
            }else if(nums[i]==candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}