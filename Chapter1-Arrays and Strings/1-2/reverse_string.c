

//本题难度不大，关键是不要忘记C风格字符串是以'\0'结尾以及输入的字符串可能是空串

#include <stdio.h>

void reverse(char *str){
	char *end=str;      
	char tmp;
	if(str){
		while(*end){
			++end;
		}
		--end;
		while(str<end){
			tmp=*str;
			*str++=*end;
			*end--=tmp;
		}
	}
}

int main()
{
	char str[][5]={"abcd","","ab","a"};
	int i;
	for(i=0;i<4;i++)
	{
		printf("%s   ",str[i]);
		reverse(str[i]);
		printf("%s\n",str[i]);
	}
	//char *str2="abcd";
	//reverse(str2);       错误的传参方式，详见http://stackoverflow.com/questions/1704407/what-is-the-difference-between-char-s-and-char-s-in-c
	//printf("%s\n",str2);
	return 0;
}