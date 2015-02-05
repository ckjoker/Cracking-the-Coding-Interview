
//本题所做的优化操作是，首先判断两个字符串的长度是否一致，然后再进行比较
import java.util.Arrays;

public class Solution{
    //1.因为如果两个字符串是anagrams，那么他们只是字符排列顺序不同，包含的字符是一样的，所以排序后会是顺序一样，
    //所以只比较排序后的字符串即可，这个办法虽然效率不是最高，最大的好处就是简单易读，也是实际中最常用的。
    public static String sort(String str){
    	char [] sort_arr=str.toCharArray();
    	Arrays.sort(sort_arr);
    	return new String(sort_arr);     
    }
    public static boolean isPermutated(String s,String t){
        if(s.length()!=t.length())
        	return false;
        return sort(s).equals(sort(t));
    }
    //2.两个序列不同的字符串每个字符的个数是一样的，因此在保证<两个字符串长度相等>的前提下，计数第一个字符串的字符
    //在第二个字符串中出现的个数是否相同来判断
    public static boolean isPermutated2(String s,String t){
        if(s.length()!=t.length())
            return false;
        int[] letters=new int[256];
        char [] s_arr=s.toCharArray();
        for(char c:s_arr){
            letters[c]++;
        }
        for(int i=0;i<t.length();i++){
            int val=t.charAt(i);
            if(--letters[val]<0)      //这个判断不会出现letters[val]最后还>0的情况，因为如果地一个str比
              return false;            //第二个str多一个某字符，那么肯定会在另某个字符上少一个，因为已经确保长度是一样的   
        }
        return true;
    }

    public static void main(String[] args) {
    	String [][] test={{"abcd","dbca"},{"","a "},{"abc","bcd"}};
        for(String[] s:test){
            System.out.println("isPermutated:\n"+s[0]+"  "+s[1]+"  "+isPermutated(s[0],s[1]));
            System.out.println("isPermutated2:\n"+s[0]+"  "+s[1]+"  "+isPermutated2(s[0],s[1]));
        }

    }

}