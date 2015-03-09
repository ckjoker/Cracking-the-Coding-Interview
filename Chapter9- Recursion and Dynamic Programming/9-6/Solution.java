/*
 Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n-pairs of parentheses.
*/
 import java.util.*;
 public class Solution{
 	//method 1：n从0开始生成存储到prev中，生成方法是每找到一个‘（’就在他的后面插入一个（）。
 	public static Set<String> generateParens(int n){
 		Set<String> set=new HashSet<String>();
 		if(n==0){
			set.add("");  //这行代码是保证当n=0时str是空字符串而不是null
			return set;
		}else{
			Set<String> prev=generateParens(n-1);
			for(String str:prev){
				for(int i=0;i<str.length();++i){
					if(str.charAt(i)=='('){
						String s=insertInside(str,i);
						set.add(s);                  //set集合可以自动判别重复元素
					}
				}
				if(!set.contains("()"+str))
					set.add("()"+str);
			}
		}
		return set;
	}
	public static String insertInside(String str,int i){
		String left=str.substring(0,i+1);
		String right=str.substring(i+1);
		return left+"()"+right;
	}
	//method 2：计数已插入的左括号和右括号的数量，若左还有剩余，就插入左，若已插入的左的数量大于已插入右的数量则插入右,好处是不用判断重复字符了
	//参数left/rightCount表示剩下的为插入的左/右括号的数量,index表示要插入的位置
	public static  void addParens(List<String> list,char[] str,int leftCount,int rightCount,int index){  
		if(leftCount<0||rightCount<leftCount)
			return ;
		if(leftCount==0&&rightCount==0){
			String s=new String(str);
			list.add(s);
			return ;
		}
		if(leftCount>0){
			str[index]='(';
				addParens(list,str,leftCount-1,rightCount,index+1);
			}
			if(rightCount>leftCount){
				str[index]=')';
addParens(list,str,leftCount,rightCount-1,index+1);
}

}
public static List<String> generateParens2(int n){
	List<String> list=new ArrayList<String>();
	char[]str=new char[n*2];
	addParens(list,str,n,n,0);
	return list;
}
public static void main(String[] args) {
	for(int i=0;i<6;++i){
		Set<String> set=generateParens(i);
		System.out.println("n="+i+":"+set.size());
		for(String s:set){
			System.out.print(s+"  "+"\n");  
		}
	}
	for (int j=0; j<6;++j) {
		List<String> list=generateParens2(j);
		System.out.println("n="+j+":"+list.size());
		for(String s:list){
			System.out.print(s+"  "+"\n");  
		}
	}
}
}