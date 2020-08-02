package HashTable;

/**
 * @author Jianshu
 * @time 20200802
 */
public class HashTable {

    HashItem[] hashItems;
    Integer initSize;//初始化表的大小（表的最大长度）

    Integer size;//其中存储数据的表项大小

    public HashTable(int initSize) {
        this.initSize =initSize;
        hashItems=new HashItem[initSize];
        /*
         * 必须有数组内类型的初始化，否则该数组内没有实际初始化的类型
         */
        for(int i = 0; i< initSize; i++) {
            hashItems[i]=new HashItem();
        }
        size=0;
    }

    /**
     * 在HashTable中放入数据，使用开放地址法
     * @param key
     * @param value
     */
    public void put(Integer key,Integer value){
        int addr=key% initSize;//求散列地址
        //如果不为空，则冲突
        while(!hashItems[addr].key.equals(HashItem.NULL)){
            addr=(addr+1)% initSize;//开放地址法的线性探测
        }
        //直到有空位后插入关键字
        hashItems[addr].set(key,value);
        size++;
    }

    /**
     * 找到HashTable中是否含有这个key
     * @return
     */
    public boolean contains(Integer key){
        int addr=key% initSize;
        while(!hashItems[addr].key.equals(key)){
            addr=(addr+1)% initSize;
            //在HashTable中找了一个循环仍然未找到
            if(hashItems[addr].key.equals(HashItem.NULL)||addr==key% initSize){
                return false;
            }
        }
        return true;
    }

    /**
     * 输出HashTable
     */
    public void printHashTable(){
        for(HashItem hashItem:hashItems) {
            if(!hashItem.key.equals(HashItem.NULL))
                System.out.println(hashItem.key+"="+hashItem.value);
        }
    }

}
