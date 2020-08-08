package Sort.AdvanceSort;

/**
 * @author Jianshu
 * @time 20200808
 */
public class AdvanceSortMain {
    public static void main(String[] args){
        int[] arr=new int[]{10,4,6,85,14,1,2,11,7,4,101};
        //AdvanceSort.mergeSort(arr);
        AdvanceSort.quickSort(arr);

        for(int a:arr){
            System.out.println(a);
        }
    }
}
