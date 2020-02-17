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
public class Subject3 {

	public int lengthOfLongestSubstring(String s) {
		// 通过ascii码的下标来判断是否存在重复元素
		int[] arr = new int[128];
		// 执行用时 : 5 ms, 在所有 Java 提交中击败了87.01%的用户
		// Arrays.fill(arr, -1);
		// 数组的批量赋值，注:该赋值方法不如遍历效率高，下面写法执行用时 更快。
		for (int i = 0; i < 128; i++) {
			arr[i] = -1;
		}
		// L为不重复遍历的下标
		// max用来比较最大字符子串的长度
		// curL是当前子串的长度
		int L = 0, max = 0, curL = 0, sLen = s.length();
		for (int i = 0; i < sLen; i++) {
			// 取出s字符串当前遍历的字符的ascii码
			int index = s.charAt(i);
			// 当没有匹配到时直接递增
			if (arr[index] < L) {
				arr[index] = i;
				curL++;
			} else {
				// 当匹配到当前字符已经在arr存在时
				// 判断当前子串中最大串长度和curL哪个长，取最大值
				max = max > curL ? max : curL;
				// 重置子串的长度,当前子串的长度curL减 (前面计算最近未重复的子串位置arr[index]减遍历的下标)
				// 如：pwwkew，当遍历到第2个w时，此时arr[index]为1,L为0，此时curL为2，
				// 要从第2个w遍历开始，此时curL就变成了1
				// 这样就从s串pwwkew的子串wkew继续往下遍历计算
				curL -= arr[index] - L;
				// 重置非重复位置L的下标值，arr[index]存的是前一位遍历的值，L在要 这个基础上增1
				L = arr[index] + 1;
				arr[index] = i;
			}
		}
		return max > curL ? max : curL;
	}

	public static void main(String[] args) {
		Subject3 s3 = new Subject3();
		String s = "pwwkew";
		System.out.println(s3.lengthOfLongestSubstring(s));
	}

}
