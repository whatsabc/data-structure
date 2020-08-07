package Sort.StableSort;

/**
 * @author Jianshu
 * @time 20200807
 */
public class SimpleSort {
    public static void selectSort(Key[] keys){
        for(int i=0;i<keys.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<keys.length;j++){
                if(keys[j].k2<keys[minIndex].k2){
                    minIndex=j;
                }
            }
            if(i!=minIndex){
                Key temp=keys[i];
                keys[i]=keys[minIndex];
                keys[minIndex]=temp;
            }
        }
    }

    public static void insertSort(Key[] keys){
        int i,j;
        int n=keys.length;
        Key target;
        for(i=1;i<n;i++){
            j=i;
            target=keys[i];
            while(j>0&&target.k1<keys[j-1].k1){
                keys[j]=keys[j-1];
                j--;
            }
            keys[j]=target;
        }
    }
}
