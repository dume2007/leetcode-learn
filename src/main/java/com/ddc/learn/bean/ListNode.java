package com.ddc.learn.bean;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public String dump() {
        StringBuilder out = new StringBuilder();
        out.append(val);

        ListNode nextNode = this.next;
        while(nextNode != null) {
            out.append(" -> ").append(nextNode.val);
            nextNode = nextNode.next;
        }

        return out.toString();
    }

    public static ListNode buildFromArray(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int a : arr) {
            curr.next = new ListNode(a);
            curr = curr.next;
        }

        return head.next;
    }

    public static ListNode buildFromNumber(long num) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int sumIndex = 1;
        while(true) {
            Double d = Math.pow(10, sumIndex);
            long bitVal = num % d.longValue();
            long val = bitVal / (d.longValue() / 10);

            curr.next = new ListNode((int)val);
            curr = curr.next;

            sumIndex++;
            num -= bitVal;
            if (num <= 0) {
                break;
            }
        }

        return head.next;
    }
}
