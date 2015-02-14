//遍历一次矩阵，当遇到元素等于0时，记录下这个元素对应的行和列。 可以开一个行数组row和列数组col，当元素matrix[i][j]等于0时， 
//就把row[i]和col[j]置为true。第二次遍历矩阵时，当某个元素对应的行row[i] 或列col[j]被设置为true，将它置0。
import CtCILibrary.*;
public class Solution{
	public static void setZeros(int[][] matrix){
		boolean[] row=new boolean[matrix.length];
		boolean[] column=new boolean[matrix[0].length];
		for(int i=0;i<matrix.length;++i){              
			for (int j=0;j<matrix[0].length;++j) {
				if(matrix[i][j]==0){
					row[i]=true;
					column[j]=true;
				}
			}
		}
        for(int i=0;i<matrix.length;++i){
        	for (int j=0;j<matrix[0].length;++j) {
        		if(row[i]||column[j]){
        			matrix[i][j]=0;
        		}
        	}
        }

	}
	 public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 9);
        AssortedMethods.printMatrix(matrix);
        setZeros(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
}