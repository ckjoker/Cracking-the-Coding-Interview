/*
Given an integer, print the next smallest and next largest number that have the same number of 1 bits 
in their binary representation.
*/
/*
brute force方法:每次加1（减1）判断1的个数是否相同
简单的方法暂时没想明白囧...
*/
public class Solution{
	public static int countOnes(int num){
		int count=0;
		while(num!=0){
            count+=num&1;
            num>>>=1;
		}
		return count;
	}
	public static int getNext(int x){
		int count=countOnes(x);
        for(++x;x<=Integer.MAX_VALUE&&(count!=countOnes(x));++x);
        if(x<=Integer.MAX_VALUE)
        	return x;
        return -1;
	}
	public static int getPrev(int x){
		int count=countOnes(x);
		for(--x;x>=Integer.MIN_VALUE&&(count!=countOnes(x));--x);
	    if(x>=Integer.MIN_VALUE)
	    	return x;
	    return -1;
	}
	public static void main(String[] args) {
		int a=1;
		System.out.println(Integer.toBinaryString(getNext(a))+"  "+Integer.toBinaryString(getPrev(a)));
	}
}