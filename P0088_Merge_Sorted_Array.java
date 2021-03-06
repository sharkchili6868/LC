class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        
        while(i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[p] = nums2[j];
                j--;
                p--;
            } else {
                int temp = nums1[p];
                nums1[p] = nums1[i];
                nums1[i] = temp;
                i--;
                p--;
            }
        }
        
        while(j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }
}