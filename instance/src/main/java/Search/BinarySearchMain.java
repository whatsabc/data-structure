package Search;

/**
 * 二分查找，用于有序数组的查找
 * @author Jianshu
 * @time 20200728
 */
public class BinarySearchMain {
    public static void main(String[] args){
        int[] nums=new int[]{0,1,5,5,5,5,5,5,9,10,11,12,13,15};//有序数组
        int target=7;

        System.out.println(target+"在数组中的任意查找索引是："+ BinarySearch.binarySearchNormal(nums,target));//当数组中有多个5时，找到的索引不确定
        System.out.println(target+"在数组中的左边界索引是："+ BinarySearch.binarySearchLeft(nums,target));
        System.out.println(target+"在数组中的右边界索引是："+ BinarySearch.binarySearchRight(nums,target));
    }
}
