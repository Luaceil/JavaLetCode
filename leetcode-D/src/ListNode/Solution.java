package ListNode;

public class Solution {
    //203移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null&&head.val==val)
        {
            head=head.next;
        }
        if(head==null)
            return null;
             while(head.val==val)
             {
                 head=head.next;
             }
             ListNode cur=head;
             while(cur.next!=null)
             {
                 if(cur.next.val==val)
                 {
                     cur.next=cur.next.next;
                 }
                 else {
                     cur=cur.next;
                 }
             }
             return head;
    }
  //206 反转链表
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre=null;
        ListNode cur=head;

        while(cur!=null)
        {
            ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }


    //class
}
