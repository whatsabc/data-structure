package HashTable;

/**
 * @author Jianshu
 * @time 20200802
 */
public class HashItem {

    static final Integer NULL=-10000;

    Integer key=NULL;
    Integer value;

    public void set(Integer key, Integer value){
        this.key=key;
        this.value=value;
    }
}
