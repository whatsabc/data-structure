package Sort.PrimarySort;

/**
 * @author Jianshu
 * @time 20200807
 * 如果没有特殊说明，以下排序算法都是升序排序
 */
public class PrimarySortMain {
    public static void main(String[] args){
        int[] arr=new int[]{10,4,6,85,14,1,2,11,7,4,101};
        //PrimarySort.selectSort(arr);
        //PrimarySort.insertSort(arr);
        PrimarySort.shellSort(arr);

        for(int a:arr){
            System.out.print(a+" ");
        }
    }
}
