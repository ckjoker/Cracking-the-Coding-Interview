//本题关键是s1+s1其实就是把s1的所有字符旋转了一遍，得到了s1旋转后的所有可能，所以如果s2是s1+s1的子串
//就一定是s1的旋转字符串
public class Solution{
	public boolean isRotation(String s1,String s2){
		if(s1.length()==s2.length()&&s1.length()!=0){
           String s1s1=s1+s1;
           return isSubtring(s1s1,s2);
		}
		return false;
	}
}