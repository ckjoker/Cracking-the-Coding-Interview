// 给定一个x值把链表划分成两部分，前一部分的值比x小，后一部分的值比x大
//维护两个链表，一个用来存比x小的节点，另一部分存大的，遍历链表然后把两个链表合并
import CtCILibrary.*;
public class Solution{
	public static ListNode partition(ListNode head,int x){
		ListNode beforeStart=null;
		ListNode beforeEnd=null;
		ListNode afterStart=null;
		ListNode afterEnd=null;
		ListNode curr=head;
		while(curr!=null){
			ListNode next=curr.next;    //存储下一个节点
		    curr.next=null;             //如果不置为null，链表的尾节点可能不会是afterEnd
		    if(curr.val<x){
		    	if(beforeStart==null){
		    		beforeStart=curr;
		    		beforeEnd=beforeStart;
		    	}else{
		    		beforeEnd.next=curr;
		    		beforeEnd=curr;
		    	}
		    }else{
		    	if(afterStart==null){
		    		afterStart=curr;
		    		afterEnd=afterStart;
		    	}else{
		    		afterEnd.next=curr;
					afterEnd=curr;     //curr.next为null保证了afterEnd是尾节点
				}
			}
			curr=next;
		}
		if(beforeStart==null)
			return afterStart;
		beforeEnd.next=afterStart;
		return beforeStart;
	}
	public static void main(String[] args) {
		int []a={2,4,1,5,6,3,7,0,9};
		ListNode l=ListNode.generateList(a);
		ListNode.printList(l);
		ListNode.printList(partition(l,0));
		ListNode.printList(partition(l,10));
		ListNode.printList(partition(l,4));
		
	}












}