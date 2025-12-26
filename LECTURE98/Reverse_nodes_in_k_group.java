package JAVA.SHASHCODE.LECTURE98;

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

public class Reverse_nodes_in_k_group {
    public int len(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int N = len(head);
        int groups = N / k;
        ListNode prevHead = null;
        ListNode currHead = head;
        ListNode ansNode = null;
        for (int i = 0; i < groups; i++) {
            ListNode prev = null;
            ListNode cur = currHead;
            ListNode nextNode = null;

            // reverse k Groups
            for (int j = 0; j < k; j++) {
                nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
            }
            if (prevHead == null) {
                ansNode = prev;
            } else {
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = cur;
        }

        // link the last incomplete group and if last was complete currHead would be
        // null
        prevHead.next = currHead;
        return ansNode;
    }
}


// class Node
// {
//     int data;
//     Node next;
//     Node(int key)
//     {
//         data = key;
//         next = null;
//     }
// }
// */
        

// class Solution {
//     public Node reverseKGroup(Node head, int k) {
//         // code here
//         Node prevHead=null;
//         Node currHead=head;
//         Node ansNode=null;
//         while(currHead!=null){
//             Node prev=null;
//             Node cur=currHead;
//             Node nextNode =null;

//             // reverse k Groups
//             int j=0;
//             while(j<k && cur!=null){
//                 nextNode=cur.next;
//                 cur.next=prev;
//                 prev=cur;
//                 cur=nextNode;
//                 j++;
//             }
//             if(prevHead==null){
//                 ansNode=prev;
//             }
//             else{
//                 prevHead.next=prev;
//             }
//             prevHead=currHead;
//             currHead = cur;
//         }
       
//         return ansNode;
//     }
// }
