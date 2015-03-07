/*A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] =
i. Given a sorted array of distinct integers, write a method to find a magic index, if
one exists, in array A.
FOLLOW UP
What if the values are not distinct?
*/

public class Solution{
	/*
Brute Force
Time:O(n) Space:O(1)
*/
public static int  magicSlow(int []array){
	for(int i=0;i<array.length;++i){
		if(array[i]==i)
			return i;
	}
	return -1;
}
/*
二分查找
注意理清mid与array[mid]关系
Time：O(lgn) Space:O(lgn)
*/
public static int magicFast(int []array){
	return magicFast(array,0,array.length-1);
}
public static int magicFast(int []array,int start,int end){
	if(start<0||end>=array.length||end<start)
		return -1;
	int mid=(start+end)/2;
	if(mid==array[mid])
		return mid;
	if(mid>array[mid])
		return magicFast(array,mid+1,end);
	else
		return magicFast(array,start,mid-1);
}
/*
Follow Up:
解释详见书
*/
public static int magicNotDistinct(int []array){
	return magicNotDistinct(array,0,array.length-1);
}
public static int magicNotDistinct(int []array,int start,int end){
   if(start<0||end>=array.length||end<start){
   	  return -1;
   }
   int mid=(start+end)/2;
   if(mid==array[mid])
   	  return mid;
   //search left
   int leftBound=Math.min(mid-1,array[mid]);  //min(mid-1,array[mid])确保了无论mid和array[mid]大小关系如何，都能找到下一个准确的查找范围
   int leftMidValue=magicNotDistinct(array,start,leftBound);
   if(leftMidValue>=0)  //!=-1
   	  return leftMidValue;
   //search right
   int rightBound=Math.max(mid+1,array[mid]);//max同理
   int rightMidValue=magicNotDistinct(array,rightBound,end);
   return rightMidValue;  
}
   public static void main(String[] args) {
   	 int []array={-3,-2,-1,0,2,4,6,7,10,12};
   	 System.out.println(magicSlow(array)+"  "+magicFast(array));//如果一个数组中magic index不止一个，那么两种方法找的结果可能不一样
     int []array2={-3,-2,2,2,3,4,5,6,7,8,11};
     System.out.println(magicNotDistinct(array2));
   }
}