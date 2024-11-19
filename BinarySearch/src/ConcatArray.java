import java.util.Arrays;

public class ConcatArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        nums3 = compare(nums1, nums2, nums3, 0, 0, m, n);
        nums1 = nums3;
        System.out.println(Arrays.toString(nums1));
    }

    public int[] compare(int[] compareNums1, int[] compareNums2, int[] compareNums3, int position1, int position2, int validLength1, int validLength2) {

        if (position1 == validLength1 && position2 == validLength2) {
            return compareNums3;
        } else if (position1 == validLength1) {
            compareNums3[position1 + position2] = compareNums2[position2];
            position2++;
            compareNums3 = compare(compareNums1, compareNums2, compareNums3, position1, position2, validLength1, validLength2);
        } else if (position2 == validLength2) {
            compareNums3[position1 + position2] = compareNums1[position1];
            position1++;
            compareNums3 = compare(compareNums1, compareNums2, compareNums3, position1, position2, validLength1, validLength2);
        } else if (compareNums1[position1] < compareNums2[position2]) {
            compareNums3[position1 + position2] = compareNums1[position1];
            position1++;
            compareNums3 = compare(compareNums1, compareNums2, compareNums3, position1, position2, validLength1, validLength2);
        } else if (compareNums1[position1] >= compareNums2[position2]) {
            compareNums3[position1 + position2] = compareNums2[position2];
            position2++;
            compareNums3 = compare(compareNums1, compareNums2, compareNums3, position1, position2, validLength1, validLength2);
        }
        return compareNums3;
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            add(nums1, nums2[i], m, i);
        }
        System.out.println(Arrays.toString(nums1));
    }

    public void add(int[] num1, int addNum, int m, int n) {
        if (m == 0) {
            num1[n] = addNum;
        } else {
            for (int i = 0; i < num1.length; i++) {
                if (i == m + n) {
                    num1[i] = addNum;
                    break;
                } else if (addNum <= num1[i]) {
                    System.arraycopy(num1, i, num1, i + 1, m - i + n);
                    num1[i] = addNum;
                    break;
                }
            }
        }
    }
}
