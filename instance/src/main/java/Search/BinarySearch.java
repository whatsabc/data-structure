package Search;

/**
 * 二分查找
 * @author Jianshu
 * @time 20200728
 */
public class BinarySearch {

    /**
     * 最基本的二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchNormal(int[] nums,int target){
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(target<nums[mid]){
                right=mid-1;
            }
            else if(target>nums[mid]){
                left=mid+1;
            }
            else if(target==nums[mid]){
                return mid;
            }
        }
        return -1;//找不到这个值
    }

    /**
     * 用于在数组内有多个查找值的情况下找到查找值的左边界索引
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLeft(int[] nums,int target){
        int left=0;
        int right=nums.length;

        while(left<right){
            int mid=left+(right-left)/2;
            if(target<nums[mid]){
                right=mid;//始终保持左闭右开
            }
            else if(target>nums[mid]){
                left=mid+1;
            }
            else if(target==nums[mid]){
                right=mid;//区间向左收缩
            }
        }
        return left;
    }

    /**
     * 用于在数组内有多个查找值的情况下找到查找值的右边界索引
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchRight(int[] nums,int target){

        int left=0;
        int right=nums.length;//这里的闭合情况属于左闭右开

        while(left<right){
            int mid=left+(right-left)/2;
            if(target<nums[mid]){
                right=mid;//始终保持左闭右开
            }
            else if(target>nums[mid]){
                left=mid+1;
            }
            else if(target==nums[mid]){
                left=mid+1;//使区间向右收缩
            }
        }
        return right-1;
    }

}
