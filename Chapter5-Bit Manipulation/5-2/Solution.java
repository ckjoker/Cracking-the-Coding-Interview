/*
Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
the binary representation. If the number cannot be represented accurately in binary
with at most 32 characters, print "ERROR."
*/
/*
原理：0.101(二进制) = 1 * 0.5+ 0 * 0.25 + 1 * 0.125(十进制).
给定的数是小数所以只考虑小数部分：
方法1：当前数乘2与1比较大小，若>1则二进制小数点第一位为1,当前数-1继续运算，反之则为第一位为0，保留当前数，下一轮计算结果为二进制第二位...
方法2：当前数先与n=0.5比较大小，若>n则二进制小数点第一位为1,当前数减n继续运算，反之则第一位为0,保留当前数，下一轮计算与n/2比较...
两者都会遇到无限循环的情况，所以要在二进制位数超过32时停止。
*/
public class Solution{
	public static String convertToBinary(double num){
		if(num>=1||num<=0)
           return "ERROR";
        StringBuilder binary=new StringBuilder();
        binary.append(".");
        while(num>0){
        	if(binary.length()>=32)
        		return "ERROR";
        	num*=2;
        	if(num>=1){
        		binary.append(1);
        		num-=1;
        	}else{
        		binary.append(0);
        	}
        }
        return binary.toString();
	}
	public static String convertToBinary2(double num){
		if(num>=1||num<=0)
			return "ERROR";
		StringBuilder binary=new StringBuilder();
		binary.append(".");
		double frac=0.5;
		while(num>0){
			if(binary.length()>=32)
				return "ERROR";
			if(num>=frac){
				binary.append(1);
		        num-=frac;
			}else{
				binary.append(0);
			}
			frac/=2;
		}
		return binary.toString();
	}
	public static void main(String[] args) {
		String s=convertToBinary(0.625);
		String s2=convertToBinary2(0.625);
		System.out.println(s);
		System.out.println(s2);
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = convertToBinary(num);
			String binary2 = convertToBinary2(num);
			//if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
				System.out.println(num + " : " + binary + " " + binary2);  //1000以内也没有几个数能转换成有限的二进制数
			//}
		}
	}
}