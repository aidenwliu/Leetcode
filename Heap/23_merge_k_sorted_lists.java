/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Comparator<ListNode> comparator = new Comparator<ListNode> () {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        };
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, comparator);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) minHeap.add(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            cur = cur.next;
            if (cur.next != null) minHeap.add(cur.next);
        }
        return dummy.next;
    }
}
