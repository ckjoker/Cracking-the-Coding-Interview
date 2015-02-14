
public class Solution{
	//1.依照题目要求（in place）使用字符数组作参数表示字符串，扫描2次，第一次统计原字符串中空格的个数，第二次从最后开始，遇到空格就替换
	//为20%，否则复制原字符串.因为在java中string是不可改变的，直接用string处理的话会返回一个新的copy。
	public static void replaceSpace(char[]str,int length){
		int spaceCount=0;
		for (int i=0;i<length ;++i ) {
			if(str[i]==' ')
				++spaceCount;
		}
		int newLength=length+spaceCount*2;
		str[newLength]='\0';
		for (int i=length-1;i>=0 ;--i ) {
            if(str[i]==' '){
            	str[newLength-1]='0';
            	str[newLength-2]='2';
            	str[newLength-3]='%';
            	newLength=newLength-3;
            }else{
            	str[newLength-1]=str[i];
            	newLength=newLength-1;
            }			
		}
		
	}
	public static void main(String[] args) {
		String str="ab c d ";
		int length=str.length()+3*2+1;
		char []arr=new char[length];
		for(int i=0;i<str.length();++i){
            arr[i]=str.charAt(i);
		}
		replaceSpace(arr,str.length());
		System.out.println(arr);
	}
}