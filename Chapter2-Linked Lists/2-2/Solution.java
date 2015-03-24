/*
找到一个单链表的倒数第k个元素
这里假设k=1时表示链表最后一个元素  
*/
import CtCILibrary.*;
public class Solution{
/*	Solution 1:如果已知链表的长度length，那么倒数第k个就是正数第（length-k）个，那么只要从头遍历链表，输出第（length-k）个即可，
不过这个太简单直白，一般不会是面试官想要考的点*/
/*	Solution 2：递归*/
	/*Method 1：如果只要求输出元素的值(跟面试官沟通)，那么只要不断返回一个int值即可
	Time:O(n) Space:O(n)*/
	public static int findKth(ListNode head,int k){
		if(head==null)
			return 0;
		int count=findKth(head.next,k)+1;
		if(count==k){
			System.out.println(head.val);
		}
		return count;
	}
    /* Method 2:如果是C++可以使用引用解决回传值的问题（即把上一层递归计算的值拿到下一层去做运算而不用使用return）
       Time:O(n) Space:O(n)
    */
   /*  ListNode *findKth(ListNode *head,int k,int &i){  //i相当于计数器count
    	if(head==null)
    		return head;
        ListNode *node=findKth(head->next,k,i);
        i=i+1;
        if(i==k)
        	return head;
        return node;
    } */
    /*
      Method 3:使用一个类去包括计数器的值，相当于模仿了传引用的思想

    */
    public static ListNode findKth3(ListNode head,int k,IntWrapper count){
         if(head==null)
         	return head;
         ListNode node=findKth3(head.next,k,count);
         ++count.value;
         if(count.value==k)
         	return head;
         return node;
    }
    /*Solution 3:迭代 */
    /*
     Method 4:双指针问题，
    */
    public static void main(String[] args) {
    	int a[]={3,5,1,2,7,6};
    	ListNode l=ListNode.generateList(a);
        IntWrapper wr=new IntWrapper();
    	System.out.println(findKth3(l,4,wr).val);
    }
}









