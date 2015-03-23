package CtCILibrary;
public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val=x;
		next=null;
	}
	ListNode(){

	}
	public static ListNode generateList(int []list){
		ListNode head=new ListNode();
		ListNode cur=head;
        for(int elem:list){
        	cur.next=new ListNode(elem);
        	cur=cur.next;
        }
        return head.next;
	}
	public static void printList(ListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
/*		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(3);
		ListNode n3=new ListNode(5);
		ListNode n4=new ListNode(7);
		ListNode n5=new ListNode(9);
		ListNode n6=new ListNode(2);
		ListNode n7=new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;*/
		int []arr={1,3,5,7,9,2,4,6};
		ListNode list=generateList(arr);
		printList(list);    
	}
}
