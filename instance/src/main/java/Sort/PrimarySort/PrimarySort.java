package Sort.PrimarySort;

/**
 * @author Jianshu
 * @time 20200807
 * 如果没有特殊说明，以下排序算法都是升序排序
 */
public class PrimarySort {

    /**
     * 选择排序，不稳定排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(i!=minIndex){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
    }

    /**
     * 插入排序，稳定排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        int j;
        int target;
        for(int i=1;i<arr.length;i++){
            target=arr[i];
            j=i;
            //将target插入从i索引到0之前的正确位置，所以每次排序前，target前都是有序的
            while(j>0&&target<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=target;
        }
    }

    /**
     * 希尔排序。稳定排序，插入排序的改进版
     * @param arr
     */
    public static void shellSort(int[] arr){
        int N=arr.length;
        int j,target;
        int h=1;
        //
        while(h<N/3){
            h=3*h+1;
        }
        while(h>=1){
            for(int i=h;i<N;i++){
                target=arr[i];
                j=i;
                //将target插入到a[i-h] a[i-2*h] a[i-3*h]当中去
                while(j>=h&&target<arr[j-h]){
                    arr[j]=arr[j-h];
                    j-=h;
                }
                arr[j]=target;
            }
            h=h/3;
        }
    }
}
