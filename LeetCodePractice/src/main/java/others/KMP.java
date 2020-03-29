package others;

/**
 * @author liuzhuang
 *
 *         KMP算法
 *
 *         最难理解的地方是 k = next[k]
 *         因为前一个的最长串的下一个字符不与最后一个相等，需要找前一个的次长串，
 *         问题就变成了求0到next(k)的最长串，如果下个字符与最后一个不等
 *         ，继续求次长串，也就是下一个next(k)，直到找到，或者完全没有
 */
public class KMP {
	// a, b分别是主串和模式串；n, m分别是主串和模式串的长度。
	public static int kmp(char[] a, int n, char[] b, int m) {
		int[] next = getNexts(b, m);
		int j = 0;
		for (int i = 0; i < n; ++i) {
			while (j > 0 && a[i] != b[j]) { // 一直找到a[i]和b[j]
				j = next[j - 1] + 1;
			}
			if (a[i] == b[j]) {
				++j;
			}
			if (j == m) { // 找到匹配模式串的了
				return i - m + 1;
			}
		}
		return -1;
	}

	// b表示模式串，m表示模式串的长度
	private static int[] getNexts(char[] b, int m) {
		int[] next = new int[m];
		next[0] = -1;
		int k = -1;
		for (int i = 1; i < m; ++i) {
			while (k != -1 && b[k + 1] != b[i]) {
				k = next[k];
			}
			if (b[k + 1] == b[i]) {
				++k;
			}
			next[i] = k;
		}
		return next;
	}

	public static void main(String[] args) {
		char[] a = new char[10];
		char[] b = new char[7];
		a = new char[] { 'a', 'b', 'a', 'b', 'a', 'e', 'a', 'b', 'a', 'c' };
		b = new char[] { 'a', 'b', 'a', 'b', 'a', 'c', 'd' };
		int result = kmp(a, a.length, b, b.length);
		System.out.println(result);
	}
}
