//原书第四版1-3题目，第五版被删去估计是解法有争议吧，毕竟代码风格就很像C，而且优化方案也被人各种吐槽
//这道题目其实是要你就地(in place)将字符串中重复字符移除。你可以向面试官问清楚， 不能使用额外的一份
//数组拷贝是指根本就不允许开一个数组，还是说可以开一个固定大小， 与问题规模(即字符串长度)无关的数组。
//算法关键是保持[0,tail)是unique string
public class RemoveDuplicates{
	//1.不允许开数组
	public static void removeDup(char []str){
        if(str==null)
        	return ;
        if(str.length<2)
        	return ;
        int tail=1;
        for(int i=1;i<str.length;++i){
        	int j;
        	for(j=0;j<tail;++j){
                 if(str[i]==str[j])     //如果找到与前面已经排查过的字符有重复的，就停止这个loop
                 	break;                
        	}
        	if(j==tail){               //如果j=tail则说明str[i]不是重复的，则把其加入unique string末尾
        		str[tail]=str[i];
        		++tail;
        	}
        }
        if(tail<str.length)
         str[tail]=0;
	}
  //允许开固定大小的数组
	public static void removeDup2(char []str){
		if(str==null)
			return ;
		if(str.length<2)
			return ;
		int tail=1;
		boolean[] char_set=new boolean[256];
		char_set[str[0]]=true;             //如果该数组中字符对应的ASCII值索引为true表示已经存在该字符（即与之前的字符重复），否则不存在
		for(int i=1;i<str.length;i++){
			if(!char_set[str[i]]){                   //若该字符不重复则将tail处替换为该字符
				str[tail]=str[i];
				char_set[str[i]]=true;
				++tail;
			}

		}
		if(tail<str.length)
				str[tail]=0;
	}
	
}