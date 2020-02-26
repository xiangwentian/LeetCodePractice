package others;

/**
 * 二分查找的变体求值
 * @author liuzhuang
 *
 */
public class BinarySearch_variant {

	public static void main(String[] args) {
		BinarySearch_variant bs = new BinarySearch_variant();
		int[] arr = { 1, 2, 3, 4, 6, 6, 7, 8, 9, 10 };
		int bs1 = bs.bsearch1(arr, arr.length, 6);
		int bs2 = bs.bsearch2(arr, arr.length, 6);
		int bs3 = bs.bsearch3(arr, arr.length, 5);
		int bs4 = bs.bsearch4(arr, arr.length, 5);
		System.out.println(bs1 + "," + bs2 + "," + bs3 + "," + bs4);
	}

	/**
	 * 变体一：查找第一个值等于给定值的元素
	 * 
	 * @param arr
	 * @param n
	 *            数组长度
	 * @param value
	 *            匹配值
	 * @return
	 */
	public int bsearch1(int[] arr, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (arr[mid] > value) {
				high = mid - 1;
			} else if (arr[mid] < value) {
				low = mid + 1;
			} else {
				if (mid == 0 || arr[mid - 1] != value) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 变体二：查找最后一个值等于给定值的元素
	 * 
	 * @param arr
	 * @param n
	 * @param value
	 * @return
	 */
	public int bsearch2(int[] arr, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (arr[mid] > value) {
				high = mid - 1;
			} else if (arr[mid] < value) {
				low = mid + 1;
			} else {
				if (mid == n - 1 || arr[mid + 1] != value) {
					return mid;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 变体三：查找第一个大于等于给定值的元素
	 * 
	 * @param arr
	 * @param n
	 * @param value
	 * @return
	 */
	public int bsearch3(int[] arr, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (arr[mid] >= value) {
				if (mid == 0 || arr[mid - 1] < value) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 变体四：查找最后一个小于等于给定值的元素
	 * 
	 * @param arr
	 * @param n
	 * @param value
	 * @return
	 */
	public int bsearch4(int[] arr, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (arr[mid] > value) {
				high = mid - 1;
			} else {
				if (mid == n - 1 || arr[mid + 1] > value) {
					return mid;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
