package com.yhh.practice.exam.hw0515;

/**
 * @author hyh
 * @date 2024/5/15
 */
import java.util.*;

public class LRUCache {
  private final int capacity;
  private final LinkedHashMap<Integer, Integer> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
      }
    };
  }

  public void query(int key) {
    if (cache.containsKey(key)) {
      int value = cache.get(key); // This operation makes the key recently used
    }
  }

  public void add(int key) {
    cache.put(key, key); // Using key as value for simplicity
  }

  public void delete(int key) {
    cache.remove(key);
  }

  public List<Integer> getCacheContents() {
    List<Integer> result = new ArrayList<>(cache.keySet());
    Collections.sort(result);
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt(); // Cache size
    int k = scanner.nextInt(); // Number of operations
    LRUCache lruCache = new LRUCache(N);

    for (int i = 0; i < k; i++) {
      String operation = scanner.next();
      int element = scanner.nextInt();

      switch (operation) {
        case "Q":
          lruCache.query(element);
          break;
        case "A":
          lruCache.add(element);
          break;
        case "D":
          lruCache.delete(element);
          break;
        default:
          System.out.println("Invalid operation");
      }
    }

    List<Integer> cacheContents = lruCache.getCacheContents();
    for (int value : cacheContents) {
      System.out.print(value + " ");
    }
  }
}

