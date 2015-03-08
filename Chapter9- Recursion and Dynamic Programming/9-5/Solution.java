/*
Write a method to compute all permutations of a string
*/
import java.util.ArrayList;
public class Solution{
	public static ArrayList<String> getPerms(String str){
		if(str==null)
			return null;
		ArrayList<String> permutations=new ArrayList<String>();
		if(str.length()==0){
           permutations.add("");//
           return permutations;
		}
		char first=str.charAt(0);
		String remainder=str.substring(1);
        ArrayList<String> subPermutations=getPerms(remainder);  //存储现有字符已经能构成的所有子序列，以后的字符继续往这些序列集合里插入进行排列组合
        for(String word:subPermutations){
        	for(int j=0;j<=word.length();++j){
        		String s=insertCharAtWord(word,first,j);
        		permutations.add(s);
        	}
        }
        return permutations;
	}
	public static String insertCharAtWord(String word,char c,int i){
		String start=word.substring(0,i);
		String end=word.substring(i);
		return start+c+end;
	}
	public static void main(String[] args) {
		String str="abcde";
		ArrayList<String> list=getPerms(str);
		System.out.println("The number of permutations is "+list.size());
		for(String s:list){
		    System.out.println(s+" ");
		}
	}
}
