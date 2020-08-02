package HashTable;

/**
 * @author Jianshu
 * @time 20200802
 */
public class HashMain {
    public static void main(String[] args){
        int initSize=10;
        HashTable hashTable=new HashTable(initSize);
        hashTable.put(1,100);
        hashTable.put(2,100);
        hashTable.printHashTable();
        int searchKey=1;
        System.out.println("该HashTable中是否包含1："+hashTable.contains(searchKey));
        System.out.println("HashTable中表项的数量是："+hashTable.size);
    }
}
