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
/*
Method 2:类似于Brute Force从头节点开始，每处理一个节点就遍历剩下所有的节点，并把重复的删除，然后处理下一个节点
Time:O(n^2)  Space:O(1)
*/
public static ListNode removeDuplicates2(ListNode head){
    ListNode curr=head;
    while(curr!=null){
       ListNode runner=curr;
       while(runner.next!=null){
          if(curr.val==runner.next.val){
          	runner.next=runner.next.next;
          }else{
          	runner=runner.next;
          }
       }
       curr=curr.next;
    }
    return head;  
}	
public static void main(String[] args) {
	int []a={1,2,3,3,3,2,4,5,1,6};
	int []b={1,2,3,3,3,2,4,5,1,6};
	int []c={};
	ListNode l1=ListNode.generateList(a);
	ListNode l2=ListNode.generateList(b);
	ListNode l3=ListNode.generateList(c);
	ListNode.printList(l1);
	removeDuplicates(l1);
	removeDuplicates(l3);
	ListNode.printList(l1);
	ListNode.printList(l3);

	ListNode.printList(l2);
	removeDuplicates2(l2);
	removeDuplicates2(l3);
	ListNode.printList(l2);
	ListNode.printList(l3);
}
}