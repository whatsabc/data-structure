package Sort.AdvanceSort;

/**
 * @author Jianshu
 * @time 20200808
 */
public class AdvanceSortMain {
    public static void main(String[] args){
        int[] arr=new int[]{10,4,6,85,14,1,2,11,7,4,101};
        //AdvanceSort.mergeSort(arr);

        /*
         * 快速排序
         */
        AdvanceSort.quickSort(arr);
        for(int a:arr)
            System.out.print(a+" ");

        System.out.println();


        /*
         * 以下是堆排序
         */
        int[] arr2=new int[arr.length+1];
        for(int i=1;i<arr.length+1;i++){
            arr2[i]=arr[i-1];
        }

        AdvanceSort.headSort(arr2);
        for(int a:arr2)
            System.out.print(a+" ");
    }
}
