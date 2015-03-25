/*删除单链表的一个中间节点，只能访问那个节点（不能访问头节点）。*/
/* 把要删除节点的下一个节点的数据赋值给要删除的节点，然后把要删除节点的下一个节点删掉
  此方法无法删除尾节点,这点需要跟面试官指出来，为了处理尾节点，可以把尾节点赋值为特殊值，本题不做处理 */
import CtCILibrary.*;
public class Solution{
	public static boolean deleteNode(ListNode n){
		if(n==null||n.next==null)
			return false;
		ListNode next=n.next;
		n.val=next.val;
		n.next=next.next;
		return true;
	}
	public static void main(String[] args) {
		int []a={1,2,3,4,5};
		ListNode l=ListNode.generateList(a);
		ListNode.printList(l);
		deleteNode(l.next.next);
		ListNode.printList(l);
	}
}