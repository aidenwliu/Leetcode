/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);  //deep copy vs. shallow copy
        Node head1 = head;
        map.put(head1,copyHead);
        Node returnHead = copyHead;
       
        while (head1.next != null) {
            copyHead.next = new Node(head1.next.val);
            map.put(head1.next, copyHead.next);
            copyHead = copyHead.next;
            head1 = head1.next;
        }
        
        head1 = head;
        copyHead = returnHead;
        while (copyHead != null) {
            copyHead.random = map.get(head1.random);
            copyHead = copyHead.next;
            head1 = head1.next;
        }
        
        return returnHead;
        
    }
}
