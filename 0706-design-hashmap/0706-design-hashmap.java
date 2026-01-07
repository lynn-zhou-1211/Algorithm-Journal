class MyHashMap {
    private static final int BASE = 769;
    private Node[] buckets;

    private class Node {
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int hash(int key){
        return key % BASE;
    }

    public MyHashMap() {
        buckets = new Node[BASE];
        for(int i = 0; i<BASE;i++){
            buckets[i]=new Node(-1,-1);
        }
    }
    
    public void put(int key, int value) {
        // 计算hash -> 遍历后找到插入位置
        int idx = hash(key);
        Node cur = buckets[idx];
        while(cur.next!=null){
            cur=cur.next;
            if(cur.key==key){
                cur.val = value;
                return;
            }
        }
        cur.next = new Node(key,value);
    }
    
    public int get(int key) {
        // 计算hash -> 遍历查找
        int idx = hash(key);
        Node cur = buckets[idx];
        while(cur.next!=null){
            cur=cur.next;
            if(cur.key==key){
                return cur.val;
            }
        }
        return -1;
        
    }
    
    public void remove(int key) {
        // 计算hash -> 遍历查找上一个节点
        int idx = hash(key);
        Node cur = buckets[idx];
        while(cur.next!=null){
            if(cur.next.key==key){
                cur.next = cur.next.next;
                return;
            }
            cur=cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */