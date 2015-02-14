
public class Solution{
	//计算压缩后字符串长度函数，思路与生成压缩字符的原理一样
	public static int countCompression(String str){    
        if(str==null||str.isEmpty())
        	return 0;
        int size=0;
        int count=1;
        char last=str.charAt(0);
        for(int i=1;i<str.length();++i)
        {
        	if (last==str.charAt(i)) {
        		++count;
        	}else{
        		last=str.charAt(i);
        		size+=1+String.valueOf(count).length();
        		count=1;
        	}
        }
        size+=1+String.valueOf(count).length();  //注意这句是确保如果上一步循环最终是从if结束的时size的计算要加上最后的count
        return size;
    }
    //1.允许使用StringBuffer
    //Time:O(n) Space:O(n)
    public static String compress(String str){
    	 int size=countCompression(str);           
    	 if(size>=str.length()){
    	 	return str;
    	 }
    	 char last=str.charAt(0);
    	 int count=1;
    	 StringBuffer comStr=new StringBuffer(); //使用StringBuffer降低时间复杂度
    	 for(int i=1;i<str.length();++i){
              if(last==str.charAt(i)){
              	  ++count;
              }else{
              	comStr.append(last);
              	comStr.append(count);
              	last=str.charAt(i);
                count=1;
              }
    	 }
         comStr.append(last);
         comStr.append(count);              //原理同上
         return comStr.toString();
    }
    //2.不允许使用StringBuffer
    //Time:O(n) Space:O(n)
    public static String compress2(String str){
         int size=countCompression(str);
         if(size>=str.length())
            return str;
         char last=str.charAt(0);
         int count=1;
         int index=0;                    //压缩后字符数组当前插入位置
         char[] arr=new char[size];      //字符数组大小可以确定
         for(int i=1;i<str.length();++i){
         	if(last==str.charAt(i)){
               ++count;
         	}else{
         		index=addCharToArray(arr,last,count,index);
                last=str.charAt(i);
                count=1;
         	}
         }
         index=addCharToArray(arr,last,count,index);
         return String.valueOf(arr);        
    }
    public static int addCharToArray(char[] array,char c,int count,int index){
        array[index]=c;
        ++index;
        char[] arr=String.valueOf(count).toCharArray();  //将count转换为字符数组，然后分别赋值，因为count可能不止一位.
        for(char ch:arr){
        	array[index]=ch;
            ++index;
        }
        return index;
    }

    public static void main(String[] args) {
    	String[] testStr={"aaabbcddeeaayyyy","abcdeeff"};
    	for(String test:testStr){
    		System.out.println("compress:"+compress(test));
    		System.out.println("compress2"+compress2(test));
    	}
    }
}



