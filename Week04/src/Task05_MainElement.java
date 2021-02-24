import java.util.Arrays;
import java.util.HashMap;

public class Task05_MainElement {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int[] nums2 = {3, 2};

        long start = System.nanoTime();

//        System.out.println(getMainElemAfterSort(nums1));
//        System.out.println(getMainElemWithHashMap(nums1));
        System.out.println(getMainElemWithMooreVote(nums1));

        long end = System.nanoTime();
        System.out.println("cost:" + (end - start) + "ns");
    }

    // 排序判断中间的值有没有一半
    public static int getMainElemAfterSort(int[] nums) {
//        Arrays.sort(nums);
        quickSort(nums, 0, nums.length-1);
        int mainElem = nums[nums.length / 2];
        int counter = 0;
        for (int num : nums) {
            if (num == mainElem)
                counter++;
        }
        if (counter > nums.length/2)
            return mainElem;
        return -1;
    }

    // 哈希表计数
    public static int getMainElemWithHashMap(int[] nums) {
        int halfLength = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        //map计数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);    // getOrDefault 有就用key的值，没有就用默认值
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > halfLength) {
                return key;
            }
        }
        return -1;
    }

    public static int getMainElemWithMooreVote(int[] nums) {
        int temp = 0, counter = 0;
        for (int num : nums) {
            if (counter == 0) {
                temp = num;
                counter = 1;
            } else {
                if (temp == num) {
                    counter++;
                } else {
                    counter--;
                }
            }
        }

        // counter只能>=0，如果大于0，那就说明有个没消掉
        if (counter != 0) {
            int n = 0;
            for (int num :
                    nums) {
                if (num == temp)
                    n++;
            }
            if (n > nums.length / 2)
                return temp;
        }
        return -1;
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
}
