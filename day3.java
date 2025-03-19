class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addLists(l1, l2, 0);
    }

    private ListNode addLists(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        ListNode node = new ListNode(sum % 10);
        node.next = addLists(l1, l2, sum / 10);
        return node;
    }
}
