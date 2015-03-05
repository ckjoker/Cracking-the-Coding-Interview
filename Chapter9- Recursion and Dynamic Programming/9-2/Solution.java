/*
 Imagine a robot sitting on the upper left comer of an X by Y grid. The robot can only
move in two directions: right and down. How many possible paths are there for the
robot to go from (0, 0) to (X, Y) ?
FOLLOW UP
Imagine certain spots are "off limits," such that the robot cannot step on them.
Design an algorithm to find a path for the robot from the top left to the bottom right.
*/
/*
(1)9How many possible paths are there for the robot to go from (0, 0) to (X, Y) ?
method 1:不论怎么走，都要向右走X步，向下走Y步，一共要走X+Y步，从中选出X步用来向右走，剩下的都是向下走，排列组合问题
C(X,X+Y)=((X+Y)!)/((X!)*(Y!))
method 2:递归： 对于矩阵中的格子(i, j)，假设从(0, 0)到它的路径数量为path(i, j)， 那么，有：
path(i, j) = path(i-1, j) + path(i, j-1)
因为机器人只能向右或向下运动，因此它只能是从(i-1, j)或(i, j-1) 运动到(i, j)的，所以路径数量也就是到达这两个格子的路径数量之和。
然后， 我们需要一个初始条件，也就是递归终止条件，可以发现， 当机器人在第一行时，不论它在第一行哪个位置，从(0, 0)到达那个位置都只有
一条路径， 那就是一路向右；同理，当机器人在第一列时，也只有一条路径到达它所在位置。
(2)FOLLOW UP
 书上思路对，但是方法不正确--！
*/
import java.util.ArrayList;
import java.awt.Point;
import java.util.Hashtable;
import CtCILibrary.AssortedMethods;
public class Solution{
	//(1)
	//求n的阶乘
	public static int fact(int n){
		if(n==0)
			return 1;
		else
			return n*fact(n-1);
	}
	//利用排列组合的方法求中总方法数
	public static int countWays(int X,int Y){
		return fact(X+Y)/(fact(X)*fact(Y));
	}
	//递归方法判断
	public static int countWays2(int X,int Y){
		if(X==0||Y==0)
			return 1;
		return countWays2(X-1,Y)+countWays2(X,Y-1);
	}
    //Follow Up:
	public static int maze[][]=new int[10][10];
	public static int size = 4;
	public static boolean isFree(int X,int Y){
		if(maze[X][Y]==0)
			return false;
		else
			return true;
	}
    /*普通递归
    Time:O(2^n) Space:O(X+Y)*/
	public static boolean getPath(int X,int Y,ArrayList<Point> path){
		Point point=new Point(X,Y);
		if(X==0&&Y==0){
			path.add(point);
			return true;
		}
		boolean success=false;
		if(X>=1&&isFree(X-1,Y)){
			success=getPath(X-1,Y,path);
		}
		if(!success&&Y>=1&&isFree(X,Y-1)){
			success=getPath(X,Y-1,path);
		}
		if(success)
			path.add(point);
		return success;
	}
    /*动态规划
    Time:O(n) Space:O(X+Y)*/
	public static boolean getPath2(int X,int Y,ArrayList<Point> path,Hashtable<Point,Boolean> cache){
		Point point=new Point(X,Y);
		if(cache.containsKey(point))
			return cache.get(point);
		if(X==0&&Y==0){
			path.add(point);
			return true;
		}
		boolean success=false;
		if(X>=1&&isFree(X-1,Y)){
			success=getPath2(X-1,Y,path,cache);
		}
		if(!success&&Y>=1&&isFree(X,Y-1)){
			success=getPath2(X,Y-1,path,cache);
		}
		if(success){
			path.add(point);
		}
		cache.put(point,success);
		return success;
	}
	public static void main(String[] args) {
/*    	for (int x=0;x<6;++x) {
    		for (int y=0;y<6;++y) {
    			System.out.println("x="+x+"  "+"y="+y+"  "+countWays(x,y)+"  "+countWays2(x,y));
    		}
    	}*/
    	maze = AssortedMethods.randomMatrix(size, size, 0, 5);
    	AssortedMethods.printMatrix(maze);
    	ArrayList<Point> path = new ArrayList<Point>();
    	ArrayList<Point> path2 = new ArrayList<Point>();
    	Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
    	boolean success  =getPath(size-1,size-1,path);
    	boolean success2 = getPath2(size - 1, size - 1, path2, cache);
    	if (success) {
    		String s = AssortedMethods.listOfPointsToString(path2);
    		System.out.println("Path: " + " " + s);			
    	} else {
    		System.out.println("Path:No path exists.");
    	}
    	if (success2) {
    		String s = AssortedMethods.listOfPointsToString(path2);
    		System.out.println("Path2: " + " " + s);			
    	} else {
    		System.out.println("Path2:No path exists.");
    	}
    }
    
}