import java.util.Arrays;

public class Task02_2_SortCollection {

    public static void main(String[] args) {
        Integer[] list = {5, 3, 7, 2, 35, 1, 9};
//        Integer[] list = {};
        heapSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i].compareTo(list[j]) < 0) {
                    swap(list, i, j);
                }
            }
        }
    }
    

    public static <T extends Comparable<T>> void insertSort(T[] list) {
        for (int i = 1; i < list.length; i++) {
            T temp = list[i];
            int j = i;
            while (j > 0 && (list[j - 1].compareTo(temp)) > 0) {
                list[j] = list[j - 1];
                j--;
            }

            list[j] = temp;
        }
    }



    public static <T extends Comparable<T>> void quickSort(T[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] list, int _left, int _right) {
        int left = _left;
        int right = _right;
        T temp = null;

        if (left <= right) {
            temp = list[left];
            while (left != right) {
                while ((left < right) && (list[right].compareTo(temp) > 0)) {
                    right--;
                }
                list[left] = list[right];
                while ((left < right) && (list[left].compareTo(temp) < 0)) {
                    left++;
                }
                list[right] = list[left];
            }
            list[right] = temp;
            quickSort(list, _left, left - 1);
            quickSort(list, right + 1, _right);
        }
    }



    public static <T extends Comparable<T>> void mergeSort(T[] list) {
        mergeSort(list, 0, list.length - 1);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] list, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            mergeSort(list, low, mid);
            mergeSort(list, mid + 1, high);
            merge(list, low, mid, high);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] list, int low, int mid, int high) {
        T[] temp = (T[]) new Comparable[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;
        while ((i <= mid) && (j <= high)) {
            if (list[i].compareTo(list[j]) > 0) {
                temp[k++] = list[i++];
            } else {
                temp[k++] = list[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = list[i++];
        }
        while (j <= high) {
            temp[k++] = list[j++];
        }
        // load sorted data into originList
        for (int l = 0; l < temp.length; l++) {
            list[l + low] = temp[l];
        }
    }



    public static <T extends Comparable<T>> void heapSort(T[] list) {
        if (list == null || list.length <= 1) {
            return;
        }
        
        buildHeap(list);

        for (int i = list.length - 1; i >0; i--) {
            swap(list, 0, i);
            heapify(list, 0, i);
        }
    }

    private static <T extends Comparable<T>> void buildHeap(T[] list) {
        for (int i = list.length / 2; i >= 0; i--) {
            heapify(list, i, list.length);
        }
    }

    private static <T extends Comparable<T>> void heapify(T[] list, int index, int len) {
        int child;
        T temp;

        for (temp = list[index]; getLeftChild(index) < len; index = child) {
            child = getLeftChild(index);
            if (child != len - 1 && list[child].compareTo(list[child + 1]) < 0) {
                child++;
            }
            if (list[child].compareTo(temp) > 0) {
                list[index] = list[child];
            } else {
                break;
            }
        }
        list[index] = temp;
    }

    private static Integer getLeftChild(int i) {
        return (i << 1) + 1;
    }

    public static <T> void swap(T[] list, int m, int n) {
        T temp = list[m];
        list[m] = list[n];
        list[n] = temp;
    }
}
