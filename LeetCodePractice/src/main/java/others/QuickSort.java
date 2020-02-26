package others;

import com.alibaba.fastjson.JSON;

/**
 * 快排
 * 
 * @author liuzhuang
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 6, 4 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(JSON.toJSONString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int index = getIndex(arr, low, high);
			quickSort(arr, 0, index - 1);
			quickSort(arr, index + 1, high);
		}
	}

	private static int getIndex(int[] arr, int low, int high) {
		int tmp = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= tmp) {
				high--;
			}
			arr[low] = arr[high];
			while (low < high && arr[low] <= tmp) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = tmp;
		return low;
	}

}
