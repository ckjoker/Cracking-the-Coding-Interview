// 给定一个x值把链表划分成两部分，前一部分的值比x小，后一部分的值比x大
//维护两个链表，一个用来存比x小的节点，另一部分存大的，遍历链表然后把两个链表合并
import CtCILibrary.*;
public class Solution{
	//Method 1:为前后两个链表都设立两个标志的头节点和尾节点，每次在尾节点之后插入，然后合并
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
	//Method 2:两个链表只设立头节点，每次在头节点之前插入再重新设置头节点，合并的时候要遍历一下前一段链表
	public static ListNode partition2(ListNode head,int x){
		ListNode beforeStart=null;
		ListNode afterStart=null;
		ListNode curr=head;
		while(curr!=null){
			ListNode next=curr.next;
			if(curr.val<x){
				curr.next=beforeStart;
				beforeStart=curr;
			}else{
				curr.next=afterStart;
				afterStart=curr;
			}
			curr=next;
		}
		if(beforeStart==null){
			return afterStart;
		}
		ListNode linkNode=beforeStart;
		while(linkNode.next!=null){
			linkNode=linkNode.next;
		}
		linkNode.next=afterStart;
		return beforeStart;
	}
	public static void main(String[] args) {
		int []a={2,4,1,5,6,3,7,0,9};
		ListNode l=ListNode.generateList(a);
		ListNode.printList(l);
		ListNode.printList(partition(l,0));
		ListNode.printList(partition(l,10));
		ListNode.printList(partition(l,4));
		int []b={2,4,1,5,6,3,7,0,9};
		ListNode l2=ListNode.generateList(b);
		ListNode.printList(l2);
		ListNode.printList(partition(l2,0));
		ListNode.printList(partition(l2,10));
		ListNode.printList(partition(l2,4));

	}












}