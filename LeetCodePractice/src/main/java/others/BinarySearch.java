package others;

/**
 * @author liuzhuang
 * 二分查找的时间复杂度是O(logn)
 * 二分查找依赖顺序表结构，简单点说就是数组。链表不适合，因为该算法要按照下标随机访问
 * 数组按下标访问数据的时间复杂度是O(1)，链表是O(n)
 * 二分查找针对的是有序数据
 * 二分查找只能用在插入、删除不频繁，一次排序多次查询的场景，不适合动态变化的数据集合
 * 数据量太小也不适合使用二分查找，只有大数据量时才会体现优势
 * 如果数据之间的比较操作非常耗时时，推荐使用二分，比如数组中存储的字符串超过300
 * 数据量太大也不适合，对内存要求比较高，要求有连续的内存空间，太大没足够空间处理是不行的
 * 
 * 二分查找底层依赖的是数组，除了数据本身之外，不需要额外存储其他信息，是最省内存的存储方式，对空间有要求的可以使用
 * 用二分查找能解决的，用散列表、二叉树都可以解决，但后两个都需要较多的额外内存空间
 */
public class BinarySearch {
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(bs.bsearch(a, a.length, 5));
		System.out.println(bs.bsearchByRecursion(a, a.length, 5));
	}

	/**
	 * 方法一
	 * @param a 数组对象
	 * @param n 数组长度
	 * @param value 要匹配的对象
	 * @return
	 */
	public int bsearch(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			// int mid = (high-low)/2;//大数量量下可能会内存溢出
			// int mid = low + (high-low)/2;//优化版本
			int mid = low + ((high - low) >> 1);// 最终优化版本
			if (a[mid] == value) {
				return mid;
			} else if (a[mid] < value) {
				// 当中值小于匹配值时，向后移位
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 使用递归实现二分
	 * @return
	 */
	public int bsearchByRecursion(int[] a, int n, int value) {
		return bsearchInternally(a, 0, n, value);
	}

	private int bsearchInternally(int[] a, int low, int high, int value) {
		if (low > high) {
			return -1;
		}
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] == value) {
				return mid;
			} else if (a[mid] < value) {
				return bsearchInternally(a, mid + 1, high, value);
			} else {
				return bsearchInternally(a, low, mid - 1, value);
			}
		}
		return -1;
	}
}
