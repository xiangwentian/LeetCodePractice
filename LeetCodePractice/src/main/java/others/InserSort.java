package others;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序, 时间复杂度O(n^2)
 * 
 * @author liuzhuang
 *
 */
public class InserSort {

	public void insertionSort(int[] a, int n) {
		if (n < 1) {
			return;
		}
		for (int i = 1; i < n; i++) {
			int value = a[i];
			int j = i - 1;
			for (; j >= 0; --j) {
				if (a[j] > value) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			a[j + 1] = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InserSort is = new InserSort();
		int[] a = { 4, 5, 6, 1, 2, 3 };
		is.insertionSort(a, a.length);
		System.out.println(JSON.toJSONString(a));
	}

}
