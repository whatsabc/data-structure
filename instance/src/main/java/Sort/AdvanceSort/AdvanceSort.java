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
        //分治的结束条件
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
        //分配一个辅助数组，用于将左右两边排好序的数组一起排序并放入
        for(int k=low;k<=high;k++)
            aux[k]=a[k];

        for(int k=low;k<=high;k++){
            if(i>mid)//比较完毕，右边还有剩余
                a[k]=aux[j++];
            else if(j>high)//比较完毕，左边还有剩余
                a[k]=aux[i++];
            //根据左右两边大小有序放入辅助数组
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
        int j=partition(a,low,high);//进行切分
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
            //找到左边大于keyNum的并找到右边小于keyNum的
            while(low<high&&a[high]>=keyNum)
                high--;
            //a[low]=a[high];
            while(low<high&&a[low]<=keyNum)
                low++;
            //a[high]=a[low];
            exchange(a,low,high);//将这两个值交换
        }
        //a[low]=keyNum;
        exchange(a,lowIndex,low);//交换预存的本次循环最低索引和low值
        return high;
    }

    public static void exchange(int[] a,int aIndex,int bIndex){
        int temp=a[aIndex];
        a[aIndex]=a[bIndex];
        a[bIndex]=temp;
    }

    /**
     * 上浮操作
     * @param a
     * @param k
     */
    public static void swim(int[] a,int k){
        while(k>1&&(k/2)<k){
            exchange(a,(k/2),k);
            k=k/2;
        }
    }

    /**
     * 下沉操作
     * @param a
     * @param k
     * @param N
     */
    public static void sink(int[] a,int k,int N){
        while(2*k<=N){
            int j=2*k;
            //如果左子结点小于右子结点，k指向右子结点
            if(j<N&&a[j]<a[j+1])
                j++;
            //如果子节点大于父节点，子节点和父节点进行交换
            if(a[j]>a[k]){
                exchange(a,j,k);
                k=j;//指向下一个节点
            }
            else
                break;
        }
    }

    /**
     * 堆排序
     * @param a
     */
    public static void headSort(int[] a){
        int N=a.length-1;//该长度是数据长度，非数组长度
        //下沉法建立最大堆（自底向上建立最大堆，从N/2开始，N/2指的是从第一个非叶子节点开始）
        for(int k=N/2;k>=1;k--)
            sink(a,k,N);
        while(N>1){
            exchange(a,1,N--);
            sink(a,1,N);
        }
    }
}
