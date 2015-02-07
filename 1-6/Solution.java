//本题是顺时针旋转，没有更优化的解法了，因为所符号有方法都必须访问所有元素（NXN）
//Time：O(n*n) Space:O(1)
public class Solution{
	public static void rotate(int[][]matrix,int n){
		for(int layer=0;layer<n/2;++layer){      //layer表示当前所处理的层数，layer=0表示从外层向内层做旋转处理，一共有n/2层
			int first=layer;
			int last=n-1-layer;            //first/last分别表示要做处理的当前层的top/left/bottom/right的第一个/最后一个位置
			for (int i=first;i<last;++i) {   
            	int offset=i-first;            //设置offset变量是为了方便接下来进行位置处理
            	int top=matrix[first][i];
            	matrix[first][i]=matrix[last-offset][first];         //规律：当前位置距离top/left/bottom/right的first更近用i表示
            	matrix[last-offset][first]=matrix[last][last-offset];//距离last更近时用last-offset表示
            	matrix[last][last-offset]=matrix[i][last];
            	matrix[i][last]=top;
            }
        }
    }
    
}