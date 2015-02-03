import java.util.Arrays;

public class UniqueChapter{
   //0.假设字符集是ASCII字符，那么我们可以开一个大小为256的boolean数组来表征每个字符的出现。数组初始化为false，遍历一遍字符串中的字符，当bool数组对应位置的值为真， 表明该字符在之前已经出现过，即可得出该字符串中有重复字符。否则将该位置的bool数组 值置为true。
   //Time:O(n) Space:O(1) (256是常量)
 public static boolean isUnique(String str){  
	  boolean []char_set=new boolean[256];  
   for(int i=0;i<str.length();i++){
    int val=str.charAt(i);
    if(char_set[val])
      return false;
    char_set[val]=true; 
  }
  return true;
}
//只有a-z（or A-Z）,位运算
//Time:O(n) Space:O(1)
   public static boolean isUnique1(String str){ 
     int checker=0;   //相当于之前的boolean
     for(int i=0;i<str.length();i++){
      int val=str.charAt(i)-'a';
      if((checker & (1<<val))>0)  //如果等于0就说明2者32位中没有一位是相同的，所以是unique，反之不是。
        return false;
      checker |=(1<<val);    //通过checker|（1<<val）把目前是unique的字符在checker上做一个位标记
    }
    return true;
  }
//ASCII-位运算
//Time:O(n) Space:O(1)
  public static boolean isUnique2(String str){
   int[] checker=new int[8];      //1个int=32bit（位），32*8=256
   for(int i=0;i<str.length();i++){
    int arr_index=str.charAt(i)/32;  //这个字符的ASCII码在数组中的索引（第几个int）
    int bit_index=str.charAt(i)%32;  //定位在该int中的索引
    if((checker[arr_index]&(1<<bit_index))>0)
     return false;
   checker[arr_index]|=(1<<bit_index);
 }
 return true;
} 
//每一个字符与剩下未与其比较的字符比较
//Time:O(n*n) Space:O(1)
public static boolean isUnique3(String str){
 for (int cur_i=0; cur_i<str.length()-1; cur_i++) {
   for (int rest_i=cur_i+1;rest_i<str.length() ;rest_i++ ) {
     if(str.charAt(cur_i)==str.charAt(rest_i))
      return false;
  }
}
return true;
} 
//先排序后比较相邻字符
//Time:O(nlogn) Space:O(logn)或O(n)
public static boolean isUnique4(String str){
  char [] sort_arr=str.toCharArray();
  Arrays.sort(sort_arr);
  for(int i=0;i<str.length()-1;i++){
    if(sort_arr[i]==sort_arr[i+1])
      return false;
  }
  return true;
}

public static void main(String [] args){
  String[] testwords={"aPple","pear","aaa","","123321","abcABC%$"};
  String str="test";
  for(String test:testwords)
    System.out.println(isUnique(test)+"   "+isUnique1(test)+"   "+isUnique2(test)+"   "+isUnique3(test)+"   "+isUnique4(test));
}
}
