package JAVA.SHASHCODE.LECTURE21;

public class Bitonic_array {
    public static void main(String[] args) {

    }

    // LEETCODE => 941
    // GIVEN AN ARRAY OF INTEGER arr, RETURN true IF AND ONLY IF IT IS A VALID
    // MOUNTAIN ARRAY.
    public boolean validMountainArray(int[] arr) {
        int index = 0;
        int n = arr.length;

        // FIND ALL INCREASING SEQ (FIND THE PEAK)
        while (index < n - 1) {
            if (arr[index] < arr[index + 1]) {
                index++;
            } else {
                break;
            }
        }
        if (index == 0 || index == n - 1) {
            return false;
        }
        // FIND ALL DECREASING SEQ (FIND THE END OF THE ARRAY)
        while (index < n - 1) {
            if (arr[index] > arr[index + 1]) {
                index++;
            } else {
                break;
            }
        }
        return (index == n - 1);
    }

    // FIND THE PEAK ELEMENT IN MOUNTAIN ARRAY / BITONIC
    // Ex => [2,5];
    // Ex => [4,1];
    // Ex => [2,5,9,11,7,4,1];
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid != 0 && mid != n - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid != n - 1 && arr[mid] < arr[mid + 1]) {
                // increasing
                start = mid + 1;
            } else {
                // decreasing
                end = mid - 1;
            }
        }
        return -1; // never be returned
    }

    // 1095. Find in Mountain Array =>
    // https://leetcode.com/problems/find-in-mountain-array/description/
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int start = 0;
        int end = n - 1;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int cur = mountainArr.get(mid);
            if (mid != 0 && mid != n - 1 && cur > mountainArr.get(mid - 1) && cur > mountainArr.get(mid + 1)) {
                if (cur == target) {
                    return mid;
                }
                break;
            } else if (mid != n - 1 && cur < mountainArr.get(mid + 1)) {
                // increase
                start = mid + 1;
            } else {
                // decrease
                end = mid - 1;
            }
        }

        // find in first half (increasing)
        start = 0;
        end = mid - 1;
        while (start <= end) {
            int m = start + (end - start) / 2;
            int cur = mountainArr.get(m);
            if (cur == target) {
                return m;
            } else if (target < cur) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }

        // find in seconcd half (decreasing array)

        start = mid+1;
        end = n - 1;
        while (start <= end) {
            int m = start + (end - start) / 2;
            int cur = mountainArr.get(m);
            if (cur == target) {
                return m;
            } else if (target < cur) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }
        return -1;
    }

}
