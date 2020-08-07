package Sort.PrimarySort;

public class PrimarySortMain {
    public static void main(String[] args){
        int[] arr=new int[]{10,4,6,85,14,1,2,11,7};
        //PrimarySort.selectSort(arr);
        //PrimarySort.insertSort(arr);
        PrimarySort.shellSort(arr);

        for(int a:arr){
            System.out.println(a);
        }
    }
}
