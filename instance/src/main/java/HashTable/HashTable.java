package HashTable;

/**
 * @author Jianshu
 * @time 20200802
 */
public class HashTable {

    HashItem[] hashItems;
    Integer size;
    int HASHSIZE;

    public HashTable(int size) {
        this.HASHSIZE=size;
        hashItems=new HashItem[HASHSIZE];
        for(int i=0;i<HASHSIZE;i++) {
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
        int addr=key%HASHSIZE;//求散列地址
        //如果不为空，则冲突
        while(!hashItems[addr].key.equals(HashItem.NULL)){
            addr=(addr+1)%HASHSIZE;//开放地址法的线性探测
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
        int addr=key%HASHSIZE;
        while(!hashItems[addr].key.equals(key)){
            addr=(addr+1)%HASHSIZE;
            //在HashTable中找了一个循环仍然未找到
            if(hashItems[addr].key.equals(HashItem.NULL)||addr==key%HASHSIZE){
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
