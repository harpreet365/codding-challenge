class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);

            if (head == null) {
                head = newNode;  // First node becomes the head
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;  // Move tail forward
            }
        }

        return head;
    }
}
