/*
Write a Java method that will return the number of bits that will need to be changed in order to convert an integer, X, 
into another integer, Y and vice versa. The method should accept two different integers as input. For example, if your 
method is passed the integers 12(01100) and 16(10000) then your method should return a 3 .
*/
/*
位运算找不同位首先想到异或（XOR）运算，先取两数异或然后计算异或的结果中1的个数
在判断1的个数上就有几种不同方法
*/
public class Solution{
	//method 1：向右位移，每次与1位与直到
	public static int bitSwapRequired(int a,int b){
        int count=0;
        for(int c=a^b;c!=0;c=c>>1)
        	count+=c&1;
        return count; 
	}
	//method 2: 对method 1进行的改进，因为它在c为负数（即c最高位为1）时会陷入无限循环
	public static int bitSwapRequired2(int a,int b){
		int count=0;
		for(int c=a^b;c!=0;c=c>>>1)  //无符号右移左边始终补0
			count+=c&1;
	   return count;
	}
	//method 3:tricky 记住就好...(正负数都可以处理)
    public static int bitSwapRequired3(int a,int b){
    	int count=0;
    	for(int c=a^b;c!=0;c=c&(c-1))
    		++count;
    	return count;
    }	   
    public static void main(String[] args) {
    	int a=12;
    	int b=16;
    	int aa=-12;
    	System.out.println(bitSwapRequired(a,b)+"  "+bitSwapRequired2(a,b)+"  "+bitSwapRequired3(a,b));
        System.out.println(bitSwapRequired2(aa,b)+"  "+bitSwapRequired3(aa,b));
    }
}