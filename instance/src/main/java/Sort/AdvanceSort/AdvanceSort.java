package Sort.AdvanceSort;

/**
 * @author Jianshu
 * @time 20200808
 * 如果没有特殊说明，以下排序算法都是升序排序
 */
public class AdvanceSort {

    /**
     * 归并排序，（自顶向下的归并排序）
     * @param a
     */
    public static void mergeSort(int[] a){
        merger_sort(a,0,a.length-1);
    }

    public static void merger_sort(int[] a,int low,int high){
        if(high<=low)
            return;
        int mid=low+(high-low)/2;
        merger_sort(a,low,mid);//将左半边排序
        merger_sort(a,mid+1,high);//将右半边排序
        merge(a,low,mid,high);//归并结果
    }

    public static void merge(int[] a,int low,int mid,int high){
        int[] aux=new int[a.length];
        int i=low,j=mid+1;
        //分配一个辅助数组
        for(int k=low;k<=high;k++)
            aux[k]=a[k];

        for(int k=low;k<=high;k++){
            if(i>mid)
                a[k]=aux[j++];
            else if(j>high)
                a[k]=aux[i++];
            else if(aux[j]<aux[i])
                a[k]=aux[j++];
            else
                a[k]=aux[i++];
        }
    }

    /**
     * 快速排序，不稳定排序
     * @param arr
     */
    public static void quickSort(int[] arr){
        quick_sort(arr,0,arr.length-1);
    }

    public static void quick_sort(int[] a,int low,int high){
        if(high<=low)
            return;
        int j=partition(a,low,high);//
        quick_sort(a,low,j-1);//先排左半部分
        quick_sort(a,j+1,high);//再排右半部分
    }

    /**
     * 此函数有两种写法，将exchange方法换为注释掉的方法是另一种写法
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] a,int low,int high){
        int lowIndex=low;
        int keyNum=a[low];
        while(low<high){
            //找到左边大于keyNum和右边小于keyNum的
            while(low<high&&a[high]>=keyNum)
                high--;
            //a[low]=a[high];
            while(low<high&&a[low]<=keyNum)
                low++;
            //a[high]=a[low];
            /*
             * 交换这两个值
             */
            exchange(a,low,high);//
        }
        //a[low]=keyNum;
        /*
         * 交换预存的本次循环最低索引和low值
         */
        exchange(a,lowIndex,low);//
        return high;
    }

    public static void exchange(int[] a,int aIndex,int bIndex){
        int temp=a[aIndex];
        a[aIndex]=a[bIndex];
        a[bIndex]=temp;
    }
}
