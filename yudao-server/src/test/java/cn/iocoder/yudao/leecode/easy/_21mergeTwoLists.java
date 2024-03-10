package cn.iocoder.yudao.leecode.easy;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

public class _21mergeTwoLists {
    public static class ListNode {
        @Getter
        @Setter
        int val;
        @Getter
        @Setter
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

    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * @param l1 l1 = [1,2,4],
     * @param l2 l2 = [1,3,4]
     * @return [1, 1, 2, 3, 4, 4]
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = new _21mergeTwoLists().mergeTwoLists(l1, l2);
        System.out.println(JSON.toJSONString(listNode));
    }
}
