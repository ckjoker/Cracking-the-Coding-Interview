/*
Write a program to swap odd and even bits in an integer with as few instructions as possible 
(e.g., bit 0 and bit 1 are swapped,bit 2 and bit 3 are swapped, etc).
*/
/*
解答是按照32位算的，64位同理。
这个简洁的方法只对无符号整形（unsigned int）适用，负数就不适用
*/
public class Solution{
	public static int swapOddEvevBits( int x){
		return ((x&0xaaaaaaaa)>>1)|((x&0x55555555)<<1);
	}
	public static String convertBinary(int a){
		String binary="";
		for(int i=0;i<32;++i){
			Integer bit=new Integer(a&1);
			binary=bit.toString()+binary;
			a>>=1;
		}
		return binary;
	}
	public static void main(String[] args) {
	/*	int a=-2;
		System.out.println(convertBinary(a));
		System.out.println(convertBinary(0xaaaaaaaa));
		System.out.println(convertBinary(a&0xaaaaaaaa));
		System.out.println(convertBinary((a&0xaaaaaaaa)>>1));*/
	/*	System.out.println(convertBinary(a>>1));
		int b=-8;
		System.out.println(convertBinary(b));
        System.out.println(convertBinary(a&b));
        System.out.println(convertBinary((a&b)>>1));
        int a=9;
        System.out.println(convertBinary(a));
        System.out.println(convertBinary(swapOddEvevBits(a)));*/
        int c=1223545354;
        int d=-1223545354;//得不到预期结果
        System.out.println(Integer.toBinaryString(c));
        System.out.println(convertBinary(c));
        System.out.println(Integer.toBinaryString(swapOddEvevBits(c)));
	}
}