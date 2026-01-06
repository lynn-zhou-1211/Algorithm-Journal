// 排序：O(N·KlogK)
// 计数：O(N·K))
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String str: strs){
            // char[] list = str.toCharArray();
            // Arrays.sort(list);
            // String key = new String(list);

            // 构建数组-> 计数-> 构建Key
            int[] arr = new int[26];
            for(char c: str.toCharArray()){
                arr[c-'a']++;
            }
            String key = Arrays.toString(arr);

            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(str);
        }
        return new ArrayList<>(mp.values());
    }
}