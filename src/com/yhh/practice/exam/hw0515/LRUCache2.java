package com.yhh.practice.exam.hw0515;

import java.util.*;

/**
 * @author hyh
 * @date 2024/5/15
 */
public class LRUCache2 {
    private Integer capacity;
    private HashMap<Integer, Integer> cache;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        // true 表示让 LinkedHashMap 按照访问顺序来进行排序,最近访问的放在头，最老访问的放在尾
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                // 当 map 中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
                return size() > capacity;
            }
        };
    }

    public void add(int key) {
        cache.put(key,key);
    }

    public void delete(int key) {
        cache.remove(key);
    }

    public void query(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
        }
    }

    public List<Integer> getCacheContents() {
        List<Integer> result = new ArrayList<>(cache.keySet());
        Collections.sort(result);
        return result;
    }

}
