//本题关键是s1+s1其实就是把s1的所有字符旋转了一遍，得到了s1旋转后的所有可能，所以如果s2是s1+s1的子串
//就一定是s1的旋转字符串
public class Solution{
	public static boolean isRotation(String s1,String s2){
		if(s1.length()==s2.length()&&s1.length()!=0){
           String s1s1=s1+s1;
           return isSubtring(s1s1,s2);
		}
		return false;
	}
	//测试：
	public static boolean isSubtring(String big,String small){
		if(big.indexOf(small)>=0)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String[][] pairs={{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for(String []test:pairs){
			System.out.println(test[0]+"  "+test[1]+"  "+isRotation(test[0],test[1]));
		}
	}
}