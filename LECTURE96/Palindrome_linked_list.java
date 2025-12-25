package JAVA.SHASHCODE.LECTURE96;

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

public class Palindrome_linked_list {
    // public boolean isPalindrome(ListNode head) {
    // ListNode prev=null;
    // ListNode slow=head;
    // ListNode fast=head;
    // ListNode newListHead=null;

    // // creating while finding the middle => O(N/2)
    // while(fast!=null && fast.next!=null){
    // prev=slow;
    // slow=slow.next;
    // fast=fast.next.next;
    // if(newListHead == null){
    // newListHead=new ListNode(prev.val);
    // }
    // else{
    // ListNode node=new ListNode(prev.val);
    // node.next=newListHead;
    // newListHead=node;

    // }
    // }

    // // if list is odd length, skip the middle
    // if(fast!=null){
    // slow=slow.next;
    // }

    // // O(N/2)
    // while(slow!=null && newListHead!=null){
    // if(slow.val!=newListHead.val){
    // return false;
    // }
    // slow=slow.next;
    // newListHead=newListHead.next;
    // }
    // return true;
    // }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode tail = reverseList(middle);
        ListNode temp = head;
        while (tail != null) {
            if (tail.val != temp.val) {
                return false;
            }
            tail = tail.next;
            temp = temp.next;
        }
        return true;
    }
}