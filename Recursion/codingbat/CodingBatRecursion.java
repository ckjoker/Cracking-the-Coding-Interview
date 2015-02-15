/**
CodingBat上一些培养递归思维的小题目
*/
/**
Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12). 

count8(8) → 1
count8(818) → 2
count8(8818) → 4
*/
public int count8(int n) {
  if(n==0)
    return 0;
  else if(n%100==88)
    return 2+count8(n/10);
  else if(n%10==8)
    return 1+count8(n/10);
  else
    return count8(n/10);
}
/**

Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars. 

changeXY("codex") → "codey"
changeXY("xxhixx") → "yyhiyy"
changeXY("xhixhix") → "yhiyhiy"
*/
public String changeXY(String str) {
  if(str.length()==0)
    return str;
  if(str.substring(0,1).equals("x"))
    return "y"+changeXY(str.substring(1));
  else 
    return str.substring(0,1)+changeXY(str.substring(1));
}


/**
Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 

array220({1, 2, 20}, 0) → true
array220({3, 30}, 0) → true
array220({3}, 0) → false
array220({},0)→false
*/
public boolean array220(int[] nums, int index) {
  if(index+1>=nums.length)  //index+1>=是防止空数组若是==则碰到空数组会判断下个if
    return false;
  if(10*nums[index]==nums[index+1]) //10*是防止除数为0
    return true;
  else 
    return array220(nums,index+1);
}
/**

Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string. 

endX("xxre") → "rexx"
endX("xxhixx") → "hixxxx"
endX("xhixhix") → "hihixxx"
*/
public String endX(String str) {
  if(str.length()==0)
    return str;
  if(str.substring(0,1).equals("x"))
    return endX(str.substring(1))+"x";
  else 
    return str.substring(0,1)+endX(str.substring(1));
}
/**

We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string. 

countPairs("axa") → 1
countPairs("axax") → 2
countPairs("axbx") → 1
*/
public int countPairs(String str) {
   if(str.length()<3)
     return 0;
   if(str.substring(0,1).equals(str.substring(2,3)))
     return 1+countPairs(str.substring(1));
   else 
     return countPairs(str.substring(1));
}
/**

Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza". 

stringClean("yyzzza") → "yza"   
stringClean("abbbcdd") → "abcd"
stringClean("Hello") → "Helo"
*/	
public String stringClean(String str) {
   if(str.length()<2)
     return str;
   if(str.substring(0,1).equals(str.substring(1,2)))
     return stringClean(str.substring(1));         //注意连续字符达3个或3个以上的情况
   else 
     return str.substring(0,1)+stringClean(str.substring(1));
}
/**

Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them. 

countHi2("ahixhi") → 1
countHi2("ahibhi") → 2
countHi2("xhixhi") → 0
注意测试用例： "xxhi"
*/
public int countHi2(String str) {
   if(str.length()<2)
     return 0;
   if(str.length()>2&&str.substring(0,3).equals("xhi"))
     return countHi2(str.substring(3));
   if(str.substring(0,2).equals("hi"))
     return 1+countHi2(str.substring(2));
   else
     return countHi2(str.substring(1));
}
/**

Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)". 

parenBit("xyz(abc)123") → "(abc)"
parenBit("x(hello)") → "(hello)"
parenBit("(xy)1") → "(xy)"
*/
public String parenBit(String str) {
    if(str.substring(0,1).equals("(")&&str.substring(str.length()-1).equals(")"))
       return str;
    if(str.substring(0,1).equals("("))
      return  parenBit(str.substring(0,str.length()-1));
    return parenBit(str.substring(1));
}
/**

Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them. 

nestParen("(())") → true
nestParen("((()))") → true
nestParen("(((x))") → false
*/
public boolean nestParen(String str) {
  if(str.length()==0)
    return true;
  if(str.substring(0,1).equals("(")&&str.substring(str.length()-1).equals(")"))
    return nestParen(str.substring(1,str.length()-1));
  return false;
}
/**
Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping. 

strCount("catcowcat", "cat") → 2
strCount("catcowcat", "cow") → 1
strCount("catcowcat", "dog") → 0	
*/
public int strCount(String str, String sub) {
   if(str.length()<sub.length())      //注意此处是<sub.length()不是0
     return 0;
   if(str.substring(0,sub.length()).equals(sub))
     return 1+strCount(str.substring(sub.length()),sub);
   return strCount(str.substring(1),sub);
}
/**

Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative. 

strCopies("catcowcat", "cat", 2) → true
strCopies("catcowcat", "cow", 2) → false
strCopies("catcowcat", "cow", 1) → true
strCopies("iiijjj","ii",2)→tr()ue;
*/
public boolean strCopies(String str, String sub, int n) {
  if(str.length()<sub.length())
    return n==0;
  if(str.substring(0,sub.length()).equals(sub))
    return strCopies(str.substring(1),sub,n-1);//注意不要写成str.substring(sub.length())因为会有上述example最后一例特殊情况(题目说可以overlap)
  return strCopies(str.substring(1),sub,n);
}
/**

Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target, with this additional constraint: if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group. (one loop can be used to find the extent of the identical values). 

groupSumClump(0, {2, 4, 8}, 10) → true
groupSumClump(0, {1, 2, 4, 8, 1}, 14) → true
groupSumClump(0, {2, 4, 4, 8}, 14) → false
*/
public boolean groupSumClump(int start, int[] nums, int target) {
    if(start>=nums.length)
      return target==0;
    int count=1;
    int val=nums[start];
    for(int i=start;i<nums.length-1;++i){
      if(nums[i]!=nums[i+1]){
         val=count*val;
         break;
      }
      ++count;
    }
    if(groupSumClump(start+count,nums,target-val))
      return true;
    if(groupSumClump(start+count,nums,target))
      return true;
    return false;
}
/**

Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.) 

splitArray({2, 2}) → true
splitArray({2, 3}) → false
splitArray({5, 2, 3}) → true
*/
public boolean splitArray(int[] nums) {
  return helper(0,nums,0);
}
public boolean helper(int start,int[]nums,int sum)
{
   if(start>=nums.length)
     return sum==0;
   if(helper(start+1,nums,sum+nums[start]))
     return true;
   if(helper(start+1,nums,sum-nums[start]))
     return true;
   return false;
}
/**

Given an array of ints, is it possible to divide the ints into two groups, so that the sum of the two groups is the same, with these constraints: all the values that are multiple of 5 must be in one group, and all the values that are a multiple of 3 (and not a multiple of 5) must be in the other. (No loops needed.) 

split53({1,1}) → true
split53({1, 1, 1}) → false
split53({2, 4, 2}) → true
*/
public boolean split53(int[] nums) {
    return helper(0,nums,0);
}
public boolean helper(int start,int []nums,int sum){
   if(start>=nums.length)
     return sum==0;
   if(nums[start]%5==0)
     return helper(start+1,nums,sum+nums[start]);
   if(nums[start]%3==0)
     return helper(start+1,nums,sum-nums[start]);
   if(helper(start+1,nums,sum+nums[start]))
     return true;
   if(helper(start+1,nums,sum-nums[start]))
     return true;
   return false;
}