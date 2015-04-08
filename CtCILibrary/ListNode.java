 package CtCILibrary;
 public class ListNode{
 	public  int val;
 	public ListNode next;
 	public ListNode(int x){
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
 	public static ListNode deleteNode(ListNode head,int x){
 		if(head==null)
 			return head;
 		ListNode curr=head;
 		if(curr.val==x){
 			return head.next;
 		}
 		while(curr.next!=null){
 			if(curr.next.val==x){
 				curr.next=curr.next.next;
 				return head;
 			}
 			curr=curr.next;
 		}
 		return head;
 	}
 	public static ListNode insertAtEnd(ListNode head,ListNode node){
 		if(node==null)
 			return head;
 		if(head==null){
 			return node;
 		}
 		ListNode curr=head;
 		while(curr.next!=null){
 			curr=curr.next;
 		}
 		curr.next=node;
 		return head;
 	}
 	public static void main(String[] args) {
/*		ListNode n1=new ListNode(1);
		ListNodestNode n2=new ListNode(3);
		ListNode n3=new ListNode(5);
		ListNode n4=new ListNode(7);
		ListNode n5=new ListNode(9);`
		ListNode n6=new ListNode(2);
		ListNode n7=new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;*/

		int []arr={0};
		ListNode list=generateList(arr);
		printList(list);
		ListNode test1=new ListNode(1);
		ListNode test2=new ListNode(2);
		ListNode newList= insertAtEnd(list,test1);
		insertAtEnd(newList,test2);
		printList(newList); 
		
/*		list=deleteNode(list,7);
		printList(list);
		list=deleteNode(list,5);
		printList(list);
		list=deleteNode(list,6);
		printList(list);
		list=deleteNode(list,6);
		printList(list);*/

	}
}
