/*
You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
 method to set all bits between i and j in N equal to M (e.g., M becomes a substring 
 of N located at i and starting at j). You can assume that the bits j through i have 
 enough space to fit all of M. That is, if M= 10011,you can assume that there are at 
 least 5 bits between j and i. You would not, for example, have j-3 and i=2, because 
 M could not fully fit between bit 3 and bit 2.
EXAMPLE:
Input: N = 10000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100
*/
/*
解法：
1.清除N的j～i位(tricky)
2.将m左移i位与N相应位置“对齐”
3.合并MN;
*/
import CtCILibrary.*;
public class Solution{
	public int insertBit(int n,int m,int i,int j){
		if(i>32||j<i)
			return 0;
		int allones=~0;
        int nLeft=allones<<(j+1);
        int nRight=((1<<i)-1);
        int mask=nLeft|nRight;
        int nUpdated=n&mask;
        int mUpdated=m<<i;
        return nUpdated|mUpdated;
	}
	public static void main(String[] args) {
		Solution solve=new Solution();
	    int a = 103217;
		System.out.println(AssortedMethods.toFullBinaryString(a));
		int b = 13;
		System.out.println(AssortedMethods.toFullBinaryString(b));		
		int c = solve.insertBit(a, b, 4, 12);
		System.out.println(AssortedMethods.toFullBinaryString(c));
	}
}