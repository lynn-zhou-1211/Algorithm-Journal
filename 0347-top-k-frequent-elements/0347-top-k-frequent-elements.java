class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计频率 -> 建立小顶堆 -> 输出结果
        // top k: minHeap
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        Queue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(
            (a,b)-> a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            q.offer(entry);
            if(q.size()>k){
                q.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i]=q.poll().getKey();
        }
        return ans;
    }
}