package com.mohit.linkedList;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

	public static void main(String[] args) {
		LRUCacheSol cache = new LRUCacheSol(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals(cache.get(1), 1);
		
		cache.put(3, 3);                      // evicts key 2
		assertEquals(cache.get(2), -1);       // returns -1 (not found)
		
		cache.put(4, 4);                      // evicts key 1
		assertEquals(cache.get(1), -1);       // returns -1 (not found)
		assertEquals(cache.get(3), 3);        // returns 3
		assertEquals(cache.get(4), 4);        // returns 4
		
		System.out.println("All casses passed " + cache.getClass().getSimpleName());
	}

}

class LRUCacheSol {
	
	int capacity;
	
	Map<Integer, LRUCacheNode> cacheMap = new HashMap<>();
	
	LRUCacheNode head; //insert here
	LRUCacheNode tail; //remove here
	
	
	public LRUCacheSol(int cap) {
		capacity = cap;
	}
	
	public int get(int key) {
		
		LRUCacheNode val = cacheMap.get(key);
		
		if(val == null) {
			return -1;
		}
		moveToHead(val);
		return val.value;
	}
	
	/*
	 * Scenarios :
	 * 1. Value key is already present. 
	 * 		update 
	 * 		move node to head
	 * 2. cache is not full
	 * 		cache is empty (create node and assign head and tail)
	 * 		cache is partially empty (add node to head and update head pointer)
	 * 3. cache is full
	 * 		remove node at tail, update head, tail pointers
	 * 		Recursively call put 
	 * 		
	 * 
	 * move node to head Scenarios
	 * 1. node is at head
	 * 2. node is at tail
	 * 3. node is in middle
	 * 
	 */
	public void put(int key, int value) {
		
		LRUCacheNode valNode = cacheMap.get(key);
		
		if(valNode != null) {
			valNode.value = value;
			moveToHead(valNode);
			return;
		} else {
			
			if(cacheMap.size() < capacity) {
				if(cacheMap.size() == 0) {
					LRUCacheNode node = new LRUCacheNode(key, value);
					cacheMap.put(key, node);
					head = node; 
					tail = node;
					return;
				} else {
					LRUCacheNode node = new LRUCacheNode(key, value);
					cacheMap.put(key, node);
					
					node.next = head;
					head.prev = node;
					head = node;
				}
			} else {
				
				//remove from tail
				LRUCacheNode last = tail;
				tail = last.prev;
				if(tail != null) {
					tail.next = null;
				}
				
				cacheMap.remove(last.key);
				if(cacheMap.size() == 0) {
					head = null;
				}
				
				//Call recursively
				put(key, value);
			}
			
		}
		
	}
	
	/*
	 * check for 3 conditions
	 * 1. node is already at head
	 * 2. Node is tail node
	 * 3. Node in middle node
	 */
	private void moveToHead(LRUCacheNode node) {
		
		if(node == head) {
			return;
		}
		
		if(node == tail) {
			tail = node.prev;
		}
		
		//node is not head, it should have some valid prev node
		LRUCacheNode prev = node.prev;
		LRUCacheNode next = node.next;
		
		prev.next = next;
		
		if(next != null) {
			next.prev = prev;
		}
		
		node.prev = null;
		node.next = head;
		head.prev = node;
		head = node;
		
	}
}

class LRUCacheNode {
	
	int key;
	int value;
	
	LRUCacheNode prev;
	LRUCacheNode next;
	
	public LRUCacheNode(int k, int v) {
		key = k;
		value = v;
	}
	
}