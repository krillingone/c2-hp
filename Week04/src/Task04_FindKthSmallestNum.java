import java.util.Comparator;
import java.util.PriorityQueue;

public class Task04_FindKthSmallestNum {
    public static void main(String[] args) {
        int[] nums = {4, 0, 1, 0, 2, 3};
        int k = 3;

//        // 偷懒版本 1375200ns
//        long start = System.nanoTime();
//        Arrays.sort(nums);
//        System.out.println(nums[k - 1]);
//        long end = System.nanoTime();
//        System.out.println("used " + (end - start) + "ns");

        // 自己写的快排 200700ns
        long start = System.nanoTime();
        quickSort(nums, 0, nums.length - 1);
        System.out.println(nums[k-1]);
        long end = System.nanoTime();
        System.out.println("used " + (end - start) + "ns");

//        // 1928900ns
//        long start = System.nanoTime();
//        System.out.println(getKthMin(nums, k));
//        long end = System.nanoTime();
//        System.out.println("used " + (end - start) + "ns");
    }

    // 用PriorityQueue整一个大顶堆，当这个堆的节点多余k并且下一个数小于当前堆顶就把堆顶拆了
    // poll() add()的时间复杂度O(log(n))  peek() size()的时间复杂度常量
    public static int getKthMin(int[] nums, int k) {
        if (nums.length == 0) {
            System.out.println("数组为空");
            System.exit(-1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        for (int num : nums) {
            if (maxHeap.size() < k) {
                maxHeap.add(num);
            } else {
                if (num < maxHeap.peek()) {
                    maxHeap.add(num);
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }

    public static void quickSort(int[] arr, int _left, int _right) {
        int left = _left;
        int right = _right;
        int temp = 0;

        if (left <= right) {
            temp = arr[left];
            while (left != right) {
                while (left < right && arr[right] >= temp) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left] <= temp) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[right] = temp;
            quickSort(arr, _left, left - 1);
            quickSort(arr, right + 1, _right);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
