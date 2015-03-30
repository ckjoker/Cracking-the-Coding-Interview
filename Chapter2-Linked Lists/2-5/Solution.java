/*两个链表代表的数字相加，每一个节点代表一个位上的数字，数字是逆向存储的，即头节点存储的是个位数，尾节点存储最高位上的数
  6 1 7         ex:list a:7->1->6
+ 2 9 5            list b:5->9->2     result:912
拓展：如果是数字是正向存储的呢？
*/
import CtCILibrary.*;
public class Solution{
	//Time:O(n),Space:O(n)
	public static ListNode addList(ListNode l1,ListNode l2,int carry){
		if(l1==null&&l2==null&&carry==0)
			return null;
		ListNode result=new ListNode(carry);
		int value=carry;
		if(l1!=null)
			value+=l1.val;
		if(l2!=null)
			value+=l2.val;
		result.val=value%10;
        if(l1!=null||l2!=null){
        	ListNode next=addList(l1==null?null:l1.next,l2==null?null:l2.next,value>=10?1:0);
        	ListNode.insertAtEnd(result,next);
        }
        return result;
	}
	public static ListNode addList2(){
		
	}
	public static void main(String[] args) {
		int []a={1,2,3,4};
        int []b={4,5,6};
        ListNode l1=ListNode.generateList(a);
        ListNode l2=ListNode.generateList(b);
        ListNode.printList(addList(l1,l2,0));
	}
}	