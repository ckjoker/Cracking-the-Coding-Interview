/*
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/
import CtCILibrary.*;
import java.util.HashMap;
public class Solution{
/*
Method 1:用HashMap存储节点，遇到重复就删除
Time:O(n) Space:O(n)
*/
public static ListNode removeDuplicates(ListNode head){
	HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
	ListNode previous=null;
	ListNode curr=head;
	while(curr!=null){
		if(map.containsKey(curr.val)){
            previous.next=curr.next;
		}else{
			map.put(curr.val,true);
			previous=curr;
		}
		curr=curr.next;
	}
	return curr;
}
	
public static void main(String[] args) {
	int []a={1,2,3,2,4,5,1,6};
	ListNode head=ListNode.generateList(a);
	ListNode.printList(head);
	removeDuplicates(head);
	ListNode.printList(head);
}
}