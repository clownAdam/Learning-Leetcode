package com.leetcode;

/**
 * Given an array of integers nums, sort the array in ascending order.
 *
 * @author clown
 * @version 1.0
 * @date 2021/5/6 17:02
 */
public class SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 5};
        SortAnArray demo = new SortAnArray();
        int[] sort = demo.sortArray(nums);
        for (int i : sort) {
            System.out.print(i + "-");
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序
     * 核心思路：快慢双指针 + 分治
     * <p>
     * partition方法
     * 先随机选择一个中间值pivot作为比较的基准，因此比这个基准小的放到左边，比这个基准大的放到右边
     * 把选择的基准放到最左边，也就是nums[low]和nums[pivot]交换位置
     * 慢指针 i 从low位置开始，指向比基准小的数字；快指针 j 从low + 1位置开始遍历
     * j <= high进入循环
     * 如果nums[j]比基准大，nums[i + 1]和nums[j]交换位置，并且i + 1
     * j每次循环 + 1
     * 循环结束后，当前 i 指针所在位置即为数组中比base小的最后一个位置，将其和最左边的base交换位置，也就是交换nums[low]和nums[i]；交换完后，i位置之前的都是比它小的，i位置之后的都是比它大的
     * 返回i，该位置的元素已排序完成，就是已经在它该在的位置了，接下来要排序i之前的和i之后的元素了
     * quick_sort方法：
     * 走一遍partition方法，获取已经排序好的mid
     * 分别对[low, mid - 1]和[mid + 1, high]两个区间进行排序，也就是mid的左右两边
     *
     * @param nums
     * @return
     */
    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int index = partition(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
            }
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
            }
        }
        nums[low] = pivot;
        return low;
    }

    /**
     * 归并排序
     * 跟快排一样也利用了分治思想
     * <p>
     * mergeSort方法：
     * 将数组nums分成左边一半和右边一半，两边分别排序
     * 将已排序好的左边一半和右边一半合并
     * mergeTwoArrays方法：
     * 建立一个临时数组tmp用于存储排序后的数组分片
     * 进入循环，分别从两个数组分片的头部开始遍历，比较大小，加到tmp中
     * 两个数组分片未必完全等分，所以在循环完成后将剩余的值也加到tmp中
     * 将tmp的值依次替换原本nums的对应位置的值
     *
     * @param nums
     * @return
     */
    public int[] mergeSort(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            mergeOfTwoSortedArray(nums, left, mid, right);
        }
        return nums;
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            nums[x + left] = temp[x];
        }
    }

    /**
     * 计数排序
     * 计数排序适用于最大值和最小值相差不大的数组的排序
     * 建立一个长度为100001数组allNums，记录每种数字出现的次数；-50000对应索引为0，50000对应索引为100001
     * 遍历allNums数组，如果记录的某数字次数大于0，将相应次数的当前数字赋值给nums数组
     *
     * @param nums
     * @return
     */
    public int[] countSort(int[] nums) {
        int[] allNums = new int[100001];
        for (int num : nums) {
            allNums[num + 50000]++;
        }
        int index = 0;
        for (int num = 0; num < allNums.length; num++) {
            if (allNums[num] == 0) {
                continue;
            }
            for (int i = 0; i < allNums[num]; i++) {
                nums[index] = num - 50000;
                index++;
            }
        }
        return nums;
    }

    /**
     * 冒泡排序
     * 第1个元素和第2个元素比较，如果第1个元素比第2个元素大，两者交换
     * 第2个元素和第3个元素比较，如果第2个元素比第3个元素大，两者交换
     * ……
     * 第n-1个元素和第n个元素比较，如果第n-1个元素比第n个大，两者交换
     *
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            boolean unChanged = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    unChanged = false;
                    swap(nums, j, j + 1);
                }
            }
            if (unChanged) {
                break;
            }
        }
        return nums;
    }

    /**
     * 插入排序
     * 类似打扑克牌的时候，每次会把新摸的牌插入到已经排好序的牌里
     * <p>
     * 从第2个元素开始遍历，和前面的数字比较
     * 将比当前数大的元素依次后移，然后把当前数放在最后一个比它大的数字的原位置
     * 对从第2个元素开始每个数都进行以上操作
     * </p>
     *
     * @param nums
     * @return
     */
    public int[] insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 第1次选一个最小的数放在数组的第1个位置
     * 第2次选剩下的数里的最小数放到第2个位置
     * ……
     * 第n - 1次选剩下2个数里的最小数放到n - 1位置
     * 剩下的第n个数自然就是最大的数放在最后
     *
     * @param nums
     * @return
     */
    public int[] chooseSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
