package workman;

import com.alibaba.fastjson.JSON;

/*给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0

示例 2:
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Subject4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] temp = new int[nums1.length + nums2.length];
		int i = 0, j = 0, index = 0;
		while (i < nums1.length && j < nums2.length) {
			// 执行用时 :4 ms, 在所有 Java 提交中击败了36.44%的用户
			// 内存消耗 :52.5 MB, 在所有 Java 提交中击败了5.01%的用户
			// temp[index] = Math.min(nums1[i], nums2[j]);

			// 使用简单粗暴的方便反而效率更好一些，上下可以做对比

			// 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
			// 内存消耗 :42.5 MB , 在所有 Java 提交中击败了96.23%的用户
			temp[index] = nums1[i] > nums2[j] ? nums2[j] : nums1[i];
			if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
			index++;
		}
		while (i < nums1.length) {
			temp[index++] = nums1[i++];
		}
		while (j < nums2.length) {
			temp[index++] = nums2[j++];
		}
		// return temp;
		System.out.println(JSON.toJSONString(temp));
		// 判断数组的长度是积是偶，积的话取
		// 积数
		int midNum = temp.length / 2;
		if (temp.length % 2 == 0) {
			return ((double) temp[midNum] + (double) temp[midNum - 1]) / 2;
		} else {
			// 积数
			return (double) temp[midNum];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2 };// { 1, 3 };
		int[] nums2 = { 3, 4 };// { 2 };
		Subject4 s4 = new Subject4();
		System.out.println(s4.findMedianSortedArrays(nums1, nums2));
	}

}
