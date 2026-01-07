class Solution {
    public int longestConsecutive(int[] nums) {
        // set 剪枝
        // 找到链条中最小的元素，找到一个后立刻直接开始计数
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxLen = 0;
        for(int num:set ){
            if(!set.contains(num-1)){
                int currNum = num;
                int currLen = 1;
                while(set.contains(currNum+1)){
                    currLen++;
                    currNum++;
                }
                maxLen = Math.max(maxLen,currLen);
            }
        }
        return maxLen;
    }
}