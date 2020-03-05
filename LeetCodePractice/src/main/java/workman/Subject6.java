package workman;

/**
 * @author liuzhuang
 */
public class Subject6 {
	/*
	 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 比如输入字符串为 "LEETCODEISHIRING" 行数为 3
	 * 时，排列如下：
	 * 
	 * L C I R E T O E S I I G E D H N
	 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
	 * 
	 * 请你实现这个将字符串进行指定行数变换的函数：
	 * 
	 * string convert(string s, int numRows); 示例 1:
	 * 
	 * 输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN" 示例 2:
	 * 
	 * 输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 解释:
	 * 
	 * L D R E O E I I E C I H N T S G
	 */
	/* 观察可以得到 递增系数 k = 2*(numRows-1); */

	public static void main(String[] args) {
		Subject6 s6 = new Subject6();
		int numRows = 3;
		String s = "LEETCODEISHIRING";
		s = s6.convert(s, numRows);
		System.out.println("numRows=" + numRows + ",result:" + s);
	}

	public String convert(String s, int numRows) {
		if (numRows <= 1) {
			return s;
		}
		// new char array
		char[] result = new char[s.length()];
		// Increasing coefficient递增系数
		int k = 2 * (numRows - 1);
		// new step
		int step = 0;
		for (int i = 0; i < numRows; i++) {
			int index = i;
			// check current i is not head or tail
			boolean notHeadOrTail = i != 0 && i != (numRows - 1);
			// index can not over s length
			while (index < s.length()) {
				result[step++] = s.charAt(index);
				// next index:index+k
				index += k;
				// another rule
				if (notHeadOrTail) {
					// new step index rule
					int newIndex = index - 2 * i;
					if (newIndex < s.length()) {
						result[step++] = s.charAt(newIndex);
					}
				}
			}
		}
		return String.valueOf(result);
	}
}
