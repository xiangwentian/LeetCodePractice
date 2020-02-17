package workman;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Subject3_shotStr {
	// 这个方法和Subject3解的是同一道题，只不过如果字符串是在12位以内的，那下面的方法效率还是比Subject3的解法高效的
	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		char[] chars = s.toCharArray();
		int leftIndex = 0;
		for (int j = 0; j < chars.length; j++) {
			for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {
				if (chars[innerIndex] == chars[j]) {
					maxLength = Math.max(maxLength, j - leftIndex);
					leftIndex = innerIndex + 1;
					break;
				}
			}
		}
		return Math.max(chars.length - leftIndex, maxLength);
	}

	public static void main(String[] args) {
		Subject3_shotStr shotStr = new Subject3_shotStr();
		String s = "pwwkew";
		System.out.println(shotStr.lengthOfLongestSubstring(s));
	}

}
