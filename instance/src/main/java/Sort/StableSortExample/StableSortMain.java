package Sort.StableSortExample;

/**
 * @author Jianshu
 * @time 20200807
 */
public class StableSortMain {
    public static void main(String[] args){

        Key[] keys=new Key[9];
        keys[0]=new Key(2,1);
        keys[1]=new Key(5,9);
        keys[2]=new Key(6,4);
        keys[3]=new Key(11,0);
        keys[4]=new Key(9,3);
        keys[5]=new Key(2,31);
        keys[6]=new Key(9,5);
        keys[7]=new Key(2,32);
        keys[8]=new Key(4,7);

        Data data=new Data(keys);
        Sort.selectSort(data.keys);
        Sort.insertSort(data.keys);
    }
}
