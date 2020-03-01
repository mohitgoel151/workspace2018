package com.mohit.linkedin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class RetainBestCache<K, V extends Rankable> {

    // Add any fields you need here

    // TODO :
    // Add failure scenarios while fetching value from datasource (timeout, network related issue ... )
    // Not considering multi threading issue

//    private Queue<V> minPq;
//    private Map<K, V> cacheMap;
//    private DataSource<K, V> ds;
//    private int entriesToRetain;
//
//    private Executor executor;
//
//    /* Constructor with a data source (assumed to be slow) and a cache size */
//    public RetainBestCache(DataSource<K, V> ds, int entriesToRetain) {
//
//        if (ds == null || entriesToRetain < 1) {
//            throw new IllegalArgumentException(".....");
//        }
//
//        //executor = new ExecutorService(threadfactory, queueSize, maxThreadCount, corePoolSize);
//        this.ds = ds;
//        this.entriesToRetain = entriesToRetain;
////        minPq = (Queue<V>) new PriorityQueue<QueueObject>(entriesToRetain, new CacheValueComparator());
//        cacheMap = new HashMap<>(entriesToRetain);
//
//    }

    /*
     * Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached, retrieves
     * it from the data source. If the cache is full, attempt to cache the returned data, evicting the V with
     * lowest rank among the ones that it has available If there is a tie, the cache may choose any T with
     * lowest rank to evict.
     */
  public Future<V> get(K key) {
    
    if(key == null) {
       throw new IllegalArgumentException(".....");
    }
    return null;
      
//      V value = cacheMap.get(key);
//      if (value != null) 
//        return new Future(value);
    
//    Future<V> future = ((Object) executor).submit(new Callable<V>() {
//      
//    
//
//    @Override
//    public V call() throws Exception {
//        V dsValue = ds.get(k);
//        
//        put(key, dsValue);
//        return dsValue;
//    }});
//      
//    return future;
    
  }

    // will not be saving null values in cache
    private void put(K key, V value) {

//        if (value == null || key == null) {
//            throw new IllegalArgumentException(".....");
//        }
//
//        if (cacheMap.size() < entriesToRetain) {
//            cacheMap.put(key, value);
//            minPq.add((V) new QueueObject(key, value));
//        } else {
//            QueueObject lowestRankObject = (QueueObject) minPq.peek();
//
//            if (value.getRank() > ((Rankable) lowestRankObject).getRank()) {
//                minPq.poll();
//                cacheMap.remove(((Object) lowestRankObject).getKey());
//
//                minPq.add(new QueueObject(key, value));
//                cacheMap.put(key, value);
//
//            }
//
//        }
//
    }
}

class CacheValueComparator implements Comparator<QueueObject> {

    public int compare(QueueObject obj1, QueueObject obj2) {
        return (int) (obj1.getValue().getRank() - obj2.getValue().getRank());
    }
}

class QueueObject<K, V extends Rankable> {
    // getter and setters
    private K key;
    private V value;
    
    public QueueObject(K key, V val) {
        this.key = key;
        this.value = value;
    }
    
    V getValue() {
        return value;
    }

}

/*
 * For reference, here are the Rankable and DataSource interfaces. You do not need to implement them, and
 * should not make assumptions about their implementations.
 */

interface Rankable {
    /**
     * Returns the Rank of this object, using some algorithm and potentially the internal state of the
     * Rankable.
     */
    long getRank();
}

interface DataSource<K, V extends Rankable> {
    V get(K key);
}
