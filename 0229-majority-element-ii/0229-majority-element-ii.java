class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 1.选出两个候选人；2.判断是否真的超过1/3
        int n = nums.length;
        int cand1 = 0, count1 = 0;
        int cand2 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 > 0 && num == cand1) {
                count1++;
            } else if (count2 > 0 && num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1++;
            } else if (count2 == 0) {
                cand2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num:nums){
            if(num==cand1){
                count1++;
            }else if(num==cand2){
                count2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(count1>n/3){
            ans.add(cand1);
        }
        if(count2>n/3){
            ans.add(cand2);
        }
        return ans;

    }
}