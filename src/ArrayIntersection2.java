import java.util.ArrayList;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */

public class ArrayIntersection2 {

    public static void main(String args[]) {
        ArrayIntersection2 arrayIntersection = new ArrayIntersection2();
        int[] res = arrayIntersection.intersect(new int[]{1, 2, 2, 1},
                new int[]{2, 2});
        System.out.print("Without any error again!!!");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        return getCommonByMergeSort(nums1, nums2);
    }

    //region merge sort method
    public int[] getCommonByMergeSort(int[] nums1, int[] nums2) {
        sort(0, nums1.length - 1, nums1);
        sort(0, nums2.length - 1, nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] res = new int[list.size()];
        int idx = 0;
        for (int num : list) {
            res[idx] = num;
            idx++;
        }
        return res;
    }
    //endregion

    //region utility methods
    private void sort(int l, int r, int[] arr) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(l, m, arr);
            sort(m + 1, r, arr);
            merge(l, m, r, arr);
        }
    }

    private void merge(int l, int m, int r, int[] arr) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[l + i];
        for (int i = 0; i < n2; i++)
            rightArr[i] = arr[i + m + 1];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    //endregion
}
