package com.mohit.linkedList;

/**
 * 
 * https://leetcode.com/problems/reorder-list
 * In   :1->2->3->4->5
 * out  :1->5->2->4->3
 * 
 * 
 * Sample 2
 * In   :1->2->3->4->5->6 
 * out  :1->6->2->5->3->4
 */
public class ReorderLinkedList {

	public static void main(String[] args) {
		ReorderLinkedListSol sol = new ReorderLinkedListSol();
		sol.execute();
		System.out.println("All test cases passed: " + sol.getClass().getSimpleName());
	}

}

class ReorderLinkedListSol {

	public void execute() {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		//input  1->2->3->4->5
		//output 1->5->2->4->3
		reorderList(head); 
		
	}

	public void reorderList(ListNode head) {

		if (head == null || head.next == null) {
			return;
		}

		ListNode slow = head, fast = head;

		//Move till half of list and break it into 2 parts
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode remaining = slow.next;
		slow.next = null;
		//reverse 2nd half of list 
		ListNode reverseHead = reverse(remaining);

		//Merge both linked list
		merge(head, reverseHead);
	}

	private ListNode reverse(ListNode node) {

		ListNode previous = null, current = node;

		while (node != null) {
			current = node.next;
			node.next = previous;
			previous = node;
			node = current;
		}
		return previous;
	}

	private void merge(ListNode node, ListNode reversed) {
		while (reversed != null) {
			ListNode rNext = reversed.next;
			ListNode nNext = node.next;

			node.next = reversed;
			reversed.next = nNext;

			reversed = rNext;
			node = nNext;
		}
	}

}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}