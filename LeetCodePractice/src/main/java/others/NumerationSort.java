package others;

import com.alibaba.fastjson.JSON;

/**
 * 统计算法
 * 
 * @author liuzhuang
 *
 */
public class NumerationSort {
	/*
	 * 计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n
	 * 大很多，就不适合用计数排序了。而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的， 要将其在不改变相对大小的情况下，转化为非负整数
	 */
	public static void main(String[] args) {
		int[] a = { 2, 5, 3, 0, 2, 3, 0, 3 };
		int n = a.length;
		countingSort(a, n);
		System.out.println("result:" + JSON.toJSONString(a));
	}

	// 计数排序，a是数组，n是数组大小，假设数组中存的都是非负整数
	public static void countingSort(int[] a, int n) {
		if (n <= 1) {
			return;
		}
		// 计算值的范围
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		// 创建一个值数组c
		int[] c = new int[max + 1];
		// 统计a数组中值出现的次数
		for (int i = 0; i < n; i++) {
			c[a[i]]++;
		}
		// 统计c数组中值
		for (int i = 1; i <= max; i++) {
			c[i] += c[i - 1];
		}
		// 创建一个临时数组r，把a数组中的值按大小放到r中
		int[] r = new int[n];
		for (int i = n - 1; i >= 0; --i) {
			// 求出要赋值r的下标
			int index = c[a[i]] - 1;// c[a[i]]是a下标为i的值在c数组中现出的位置，下标需要减1
			r[index] = a[i];
			c[a[i]]--;// 因为已经赋值了，那小于这个位置的数就少了1个
		}
		// 把临时数组r赋值给a
		for (int i = 0; i < n; i++) {
			a[i] = r[i];
		}
	}

}
