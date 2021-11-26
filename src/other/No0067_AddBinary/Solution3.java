package other.No0067_AddBinary;

/**
 * 短的补0在计算
 * @author vB_Gg
 *
 */
public class Solution3 {
	public String addBinary(String a, String b) {
		char f = '0';//进位
		StringBuffer c = new StringBuffer();;
		int la = a.length();
		int lb = b.length();
		la--;lb--;
		while(la>=0 || lb>=0)
		{
			int sum = 0;
			if(f == '1') sum++;
			if(la>=0 && a.charAt(la--) == '1') sum++;
			if(lb>=0 && b.charAt(lb--) == '1') sum++;
			c.append(sum%2+"");
			f = sum>1?'1':'0';
		}
		if( f=='1') c.append("1") ;
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
