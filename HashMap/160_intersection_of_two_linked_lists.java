/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Sol 1. Hash Table
//Time Complexity: T(M+N)
//Space Complexity: T(M)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headB != null) {
            set.add(headB);
            headB = headB.next;
        }
        
        while (headA != null) {
            if (set.contains(headA))
                return headA;
            headA = headA.next;
        }
        return null;
    }
}

//Sol 2. Two Pointers
//Time Complexity: T(M+N)
//Space Complexity: T(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        
        while (pA != pB) {
            pA = pA == null? headB:pA.next;
            pB = pB == null? headA:pB.next;
        }
        return pA;
    }
}
