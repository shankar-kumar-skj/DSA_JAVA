package JAVA.SHASHCODE.LECTURE100;


class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

public class Sort_a_linked_list_of_0s_1s_2s {
    public Node segregate(Node head) {
        // code here
        Node zeroHead=new Node(-1);
        Node zeroTail=zeroHead;
        Node oneHead=new Node(-1);
        Node oneTail=oneHead;
        Node twoHead=new Node(-1);
        Node twoTail=oneHead;
        Node temp=head;
        while(temp!=null){
            Node nextNode=temp.next;
            if(temp.data == 0){
                temp.next = null;
                zeroTail.next=temp;
                zeroTail = zeroTail.next;
            }
            else if(temp.data==1){
                temp.next = null;
                oneTail.next=temp;
                oneTail = oneTail.next;
            }
            else{
                temp.next = null;
                twoTail.next=temp;
                twoTail = twoTail.next;
            }
            temp=nextNode;
        }
        if(oneHead.next==null){
            zeroTail.next=twoHead.next;
        }
        else{
            zeroTail.next=oneHead.next;
            oneTail.next=twoHead.next;
        }
        
        // deleting dummies
        oneHead.next=null;
        twoHead.next=null;
        Node t1=zeroHead;
        zeroHead=zeroHead.next;
        t1.next= null;
        return zeroHead;
    }
}
