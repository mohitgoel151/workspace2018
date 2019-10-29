package com.mohit.linkedList;

import com.mohit.poc.pojo.LinkedListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 *
 * 
 * 
 */
public class SumOfLinkedListNodes {

    public void execute() {
        LinkedListNode l1 = new LinkedListNode(2);
        l1.next = new LinkedListNode(4);
        l1.next.next = new LinkedListNode(3);

        LinkedListNode l2 = new LinkedListNode(5);
        l2.next = new LinkedListNode(6);
        l2.next.next = new LinkedListNode(4);

        printResult(addTwoNumbers(l1, l2));
        printResult(addTwoNumbersRecursive(l1, l2, 0));
        
        l2.next.next.next = new LinkedListNode(2);
        printResult(addTwoNumbers(l1, l2));
        printResult(addTwoNumbersRecursive(l1, l2, 0));
        
    }

    public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {

        int sum = 0;
        int carry = 0;
        LinkedListNode head = null;
        LinkedListNode prev = null;

        while (l1 != null || l2 != null) {

            int n1 = 0;
            int n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }

            sum = (n1 + n2 + carry);
            carry = sum / 10;

            LinkedListNode node = new LinkedListNode(sum % 10);

            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }

        }
        if (carry > 0) {
            LinkedListNode node = new LinkedListNode(carry);
            prev.next = node;
        }

        return head;

    }

    
    public LinkedListNode addTwoNumbersRecursive(LinkedListNode l1, LinkedListNode l2, int carry) {
        
        if(l1 == null && l2 == null) {
            if(carry > 0) {
                return new LinkedListNode(carry);
            }
            return null;
        }
        
        int v1 = l1 != null ? l1.val : 0;
        int v2 = l2 != null ? l2.val : 0;
        
        int sum = v1 + v2 + carry;
        carry = sum / 10;
        
        LinkedListNode aNode = new LinkedListNode(sum % 10);
        
        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
        
        aNode.next = addTwoNumbersRecursive(l1, l2, carry);
        
        return aNode;
    }
    
    private void printResult(LinkedListNode result) {
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }
}
