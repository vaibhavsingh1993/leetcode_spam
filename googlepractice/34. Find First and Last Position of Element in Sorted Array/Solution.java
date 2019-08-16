/* FB question*/
class Solution {
    enum SearchType {
        FIRST, LAST;
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int first = binSearch(nums, target, 0, nums.length, SearchType.FIRST);
        int last = binSearch(nums, target, 0, nums.length, SearchType.LAST);
        
        if (first == -1|| last == -1) return new int[]{-1, -1};
        return new int[]{first, last};
    }
    
    private int binSearch(int[] nums, int target, int left, int right, SearchType type) {
        if (target > nums[nums.length - 1] || target < nums[0]) return -1;
        if (nums.length == 0 || left >= right) return -1;
        int mid = left + (right - left) / 2;
        if (mid == left || mid == right) {
            if (nums[mid] != target) return -1;
        }
        
        if (nums[mid] < target) {
            return binSearch(nums, target, mid, right, type);
        } else if (nums[mid] > target) {
            return binSearch(nums, target, left, mid, type);
        } else {
            if (type == SearchType.FIRST) {
                if (mid - 1 >= 0 && nums[mid - 1] == target) {
                    return binSearch(nums, target, left, mid, type);
                } else {
                    return mid;
                }
            }
            if (type == SearchType.LAST) {
                if (mid + 1 < nums.length && nums[mid + 1] == target) {
                    return binSearch(nums, target, mid, right, type);
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
