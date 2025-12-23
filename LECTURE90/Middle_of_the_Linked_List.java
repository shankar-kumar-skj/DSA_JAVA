package JAVA.SHASHCODE.LECTURE90;

// fast & slow point
// floyd's cyclic algorithm

public class Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
