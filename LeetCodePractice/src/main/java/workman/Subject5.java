package workman;
/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

/*执行用时 :2 ms, 在所有 Java 提交中击败了99.98%的用户
内存消耗 :37.8 MB, 在所有 Java 提交中击败了27.89%的用户*/
public class Subject5 {

	public String longestPalindrome(String s) {
		char[] ch = s.toCharArray();
		// 定义一个回文子串长度长度记录数组
		int[] limit = { 0, 0 };
		int i = 0;
		while (i < ch.length) {
			i = indexOf(ch, i, limit);
		}
		return s.substring(limit[0], limit[1]);
	}

	public int indexOf(char[] ch, int low, int[] limit) {
		int high = low + 1;
		// 当相邻两个字符相同时，如：cbbd
		while (high < ch.length && ch[low] == ch[high]) {
			high++;
		}
		int result = high;
		// 当隔位相同时，如：aba
		while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
			low--;
			high++;
		}
		// 判断当前high位置取得的子串长度是否比limit长，长就替换
		if (high - low > limit[1] - limit[0]) {
			limit[0] = low;
			limit[1] = high;
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "babad";
		Subject5 s5 = new Subject5();
		String subStr = s5.longestPalindrome(s);
		System.out.println("最大子串长度为:" + subStr);
	}

}
