package com.leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数
 * 它们每位数字都是按照 逆序 的方式存储的
 * 并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @author clown
 * @version 1.0
 * @date 2021/4/19 11:38
 */
public class Two {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode la = new ListNode(2);
        ListNode lb = new ListNode(4);
        la.next = lb;
        ListNode lc = new ListNode(3);
        lb.next = lc;
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("*****************");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * [2,4,3]
     * [5,6,4]
     * [7,0,8]
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode index = head;
        int count = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + count;
            count = sum / 10;
            sum = sum % 10;
            index.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            index = index.next;
        }
        if (count > 0) {
            index.next = new ListNode(count);
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
