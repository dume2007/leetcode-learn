package com.ddc.learn;

import com.ddc.learn.bean.ListNode;

/**
 * 两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    /**
     * 思路：实现链表与long数值的互转
     * 失败：链表结构太长超过long值无法转换
     * @param l1 ListNode
     * @param l2 ListNode
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long m = 0, mIndex = 0;
        long n = 0, nIndex = 0;

        while(true) {
            Double d = Math.pow(10, mIndex);
            m += l1.val * d.longValue();
            if(l1.next != null) {
                l1 = l1.next;
                mIndex++;
            } else {
                break;
            }
        }

        while(true) {
            Double d = Math.pow(10, nIndex);
            n += l2.val * d.longValue();
            if(l2.next != null) {
                l2 = l2.next;
                nIndex++;
            } else {
                break;
            }
        }

        return ListNode.buildFromNumber(m + n);
    }

    /**
     * 思路：每一个节点进行相加，如果有进位，则给下一节点额外加1
     * @param l1 ListNode
     * @param l2 ListNode
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int bit = 0;
        while(p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = x + y + bit;
            if (sum >= 10) {
                sum = sum % 10;
                bit = 1;
            } else {
                bit = 0;
            }

            curr.next = new ListNode(sum);
            curr = curr.next;

            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }

        if(bit > 0) {
            curr.next = new ListNode(bit);
        }

        return head.next;
    }

    public static void main(String[] args) {
        int[] n1 = {9};
        int[] n2 = {1,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};

        ListNode l1 = ListNode.buildFromArray(n1);
        ListNode l2 = ListNode.buildFromArray(n2);

        System.out.println(l1.dump());
        System.out.println(l2.dump());

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l3 = addTwoNumbers.addTwoNumbers2(l1, l2);

        System.out.println(l3.dump());
    }

    public static void main2(String[] args) {
        long n1 = 9L;
        long n2 = 999999999999999991L;

        ListNode l1 = ListNode.buildFromNumber(n1);
        ListNode l2 = ListNode.buildFromNumber(n2);

        System.out.println(l1.dump());
        System.out.println(l2.dump());

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);

        System.out.println(l3.dump());
    }
}
