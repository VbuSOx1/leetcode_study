package other.No0067_AddBinary;

/**
 * https://leetcode-cn.com/problems/add-binary/
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 该代码执行超时(原因是那个while应该改成if)
 * 中间的判断太多了，很多步骤是多余的
 * @author vB_Gg
 */
public class Solution {
	
	public String addBinary(String a, String b) {
		char f = '0';//进位
		String c ="";
		int la = a.length();
		int lb = b.length();
		la--;lb--;
		while(la>=0 && lb>=0)
		{
			c = add(a.charAt(la), b.charAt(lb), f) + c;
			f = getF(a.charAt(la--), b.charAt(lb--));
		}
		if(la<0 && lb<0 && f=='1') c = "1" + c;
		while(la>=0) c = a.substring(0, la) + c;
		while(lb>=0) c = b.substring(0, lb) + c;
        return c;
    }
	public String add(char a, char b, char f)
	{
		int flag = 0;
		if(a=='1') flag++;
		if(b=='1') flag++;
		if(f=='1') flag++;
		if(flag%2==0)
			return "0";
		return "1";
	}
	public char getF(char a, char b)
	{
		if(a=='1' && b=='1')
			return '1';
		return '0';
	}

	public void Test() {
		String s1 = "1010101001";
		String s2 = "1010101001";
		System.out.println(addBinary(s1,s2));
	}
}
