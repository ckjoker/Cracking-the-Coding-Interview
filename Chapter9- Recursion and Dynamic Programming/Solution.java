/*
A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
3 steps at a time. Implement a method to count how many possible ways the child
can run up the stairs.
*/
/*
原书竟然n=0时ways=1处理，卧槽这什么鬼，这里n=0，ways=0;

*/
public class Solution{
	/*基本递归方法，用于验证其他方法的正确性
    Time:O(3^n) Space O(1)?*/
	public static int climbStairs0(int n){
		if(n<1)
			return 0;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		return climbStairs0(n-1)+climbStairs0(n-2)+climbStairs0(n-3);
	}
	/*recursion+dp
	Time:O(n) Space:O(n) */
	public static int climbStairs(int n,int []map){
		if(n<1)
			return 0;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		if(map[n]!=0)
			return map[n];
	    map[n]=climbStairs0(n-1)+climbStairs0(n-2)+climbStairs0(n-3);
	    return map[n];
	}
    /*iteration+dp
    Time:O(n) Space:O(n) */
	public static int climbStairsIterative(int n){
       int []map=new int[37];
       map[0]=0;
       map[1]=1;
       map[2]=2;
       map[3]=4;
       for(int i=4;i<n+1;++i){
       	  map[i]=map[i-1]+map[i-2]+map[i-3];
       }
       return map[n];
	}
	public static void main(String[] args) {
		int []map=new int[37];
		for (int i=0;i<15;++i) {
			System.out.println(climbStairs0(i)+"  "+climbStairs(i,map)+"  "+climbStairsIterative(i));
		}
	}
}