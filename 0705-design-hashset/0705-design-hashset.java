class MyHashSet {
    // NOTE: 初始化dummy节点不能用增强for，因为增强for拿到的是节点的引用，不会直接改变buckets数组
    private static final int BASE = 769;
    private Node[] buckets;

    private class Node{
        int key;
        Node next;
        Node(int key){
            this.key=key;
        }
    }

    private int hash(int key){
        return key % BASE;
    }

    public MyHashSet() {
        buckets = new Node[BASE];
        for(int i = 0; i < BASE; i++){
            buckets[i] = new Node(-1); 
        }
    }
    
    public void add(int key) {
        // 计算index，检查是否有重复，挂在最后面
        int idx = hash(key);
        Node cur = buckets[idx];
        while(cur.next!=null){
            cur=cur.next;
            if(cur.key==key){
                return;
            }
        }
        cur.next = new Node(key);
    }
    
    public void remove(int key) {
        // 查找key的前一个节点，移除
        int idx = hash(key);
        Node cur = buckets[idx];
        while(cur.next!=null){
            if(cur.next.key == key){
                cur.next = cur.next.next;                
                return;
            }
            cur=cur.next;
        }
    }
    
    public boolean contains(int key) {
        int idx = hash(key);
        Node cur = buckets[idx];
        while(cur.next!=null){
            cur=cur.next;
            if(cur.key==key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */