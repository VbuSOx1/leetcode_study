package other.No0067_AddBinary;
/**
 * 看了别人的解答
 * 优化第一版
 * 
 * String 对象不可改变，对其进行操作，会重新生成新的字符串然后在赋值，所以速度上就会慢很多，
 * 换成StringBuffer或StringBuilder更好。
 * 
 * 计算尾数和进位可以不用那么多判断
 * 
 * 还有就是insert方法插入时会需要频繁移动数组，用append，最后倒置过来
 * 
 * 最后用while死循环了。。。。淦
 * 
 * 还是错的， 不能只计算短的那一部分，应该把短的补0在计算
 * 
 * @author vB_Gg
 *
 */
public class Solution2 {
	public String addBinary(String a, String b) {
		char f = '0';//进位
		StringBuffer c = new StringBuffer();;
		int la = a.length();
		int lb = b.length();
		la--;lb--;
		while(la>=0 && lb>=0)
		{
			int sum = 0;
			if(f == '1') sum++;
			if(a.charAt(la--) == '1') sum++;
			if(b.charAt(lb--) == '1') sum++;
			c.append(sum%2+"");
			f = sum>1?'1':'0';
		}
		if(la<0 && lb<0 && f=='1') c.append("1") ;
		if(la>=0) c.append(a.substring(0, la+1));
		if(lb>=0) c.append(b.substring(0, lb+1));
        return c.reverse().toString();
    }
	public void Test() {
		String s1 = "11";
		String s2 = "1";
//		StringBuffer b = new StringBuffer();
//		b.append(s1);
//		b.append(s2);
//		System.out.println(b);
		System.out.println(addBinary(s1,s2));
	}
}
