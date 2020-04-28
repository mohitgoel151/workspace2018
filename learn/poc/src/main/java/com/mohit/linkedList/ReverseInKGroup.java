package com.mohit.linkedList;

/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. 
 * k is a positive integer and is less than or equal to the length of the linked list.
 * 
 * Spl Case : 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 */
public class ReverseInKGroup {

	public static void main(String[] args) {
		ReverseInKGroupSol sol = new ReverseInKGroupSol();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		sol.reverseKGroup(head, 3);

	}

}

class ReverseInKGroupSol {

	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode current = head, next = null, prev = null;
		int remaining = k;

		while (current != null && remaining > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			remaining--;
		}

		/*
		 * Special Case that if remaining elements are less than k .. don't reverse them.
		 * For for that case this if condition is added.
		 * 
		 * Reverse the reversed portion of list
		 */
		if (remaining > 0) {
			current = prev;
			next = null;
			prev = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
		}

		/*
		 * If there is any remaining list then recursively call it and assign prev node to head.next
		 */
		if (next != null) {
			head.next = reverseKGroup(next, k);
		}
		return prev;

	}

}