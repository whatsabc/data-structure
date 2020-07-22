package List;

/**
 * @author Jianshu
 * @time 2020/07/21
 */
public class List {

    ListNode head;
    public int size;

    public List(ListNode head){
        this.head=head;
        size=1;
    }

    /**
     * 用于默认在链表末尾插入值
     * @param val 插入值
     */
    public void add(int val){

        ListNode p=head;
        ListNode q=new ListNode(val);

        while(p.next!=null){//指向最后一个节点
            p=p.next;
        }
        p.next=q;

        size++;
    }

    /**
     * 用于在链表的指定的位置插入值
     * @param index 索引表项从0开始
     * @param val 插入值
     */
    public boolean add(int index,int val){

        if(index>size||index<0){
            System.out.println("插入索引"+index+"超过了插入索引[0-"+size+"]");
            return false;
        }

        ListNode p=head;
        ListNode q=new ListNode(val);//准备这个要插入的节点

        if(index==0){
            q.next=p;
            head=q;
        }
        else{
            ListNode pre=null;
            int count=0;
            while(p!=null&&count<index){//p指的是index的位置
                pre=p;//保存前一个节点的值
                p=p.next;
                count++;
            }
            q.next=p;
            pre.next=q;
        }

        size++;
        return true;
    }

    /**
     * 删除链表指定位置的表项
     * @param index 索引表项从0开始
     */
    public boolean delete(int index){

        if(index>=size||index<0){
            System.out.println("删除索引"+index+"超过了删除索引[0-"+(size-1)+"]");
            return false;
        }

        ListNode p=head;

        if(isEmpty()){
            System.out.println("该表为空，删除失败");
            return false;
        }

        if(index==0){//头节点删除特殊处理
            p.next=p;
            head=p;
        }

        else{
            ListNode pre=null;
            int count=0;
            while(p!=null&&count<index){
                pre=p;//保存前一个节点的值
                p=p.next;
                count++;
            }
            pre.next=p.next;
        }

        size--;
        return true;
    }

    /*
     * 判断链表是否为空表
     */
    public boolean isEmpty(){
        return head == null;
    }

    /*
     * 遍历整个链表，并打印
     */
    public void print(){

        ListNode p=head;
        while(p!=null){
            System.out.print(" --> "+p.val);
            p=p.next;
        }
        System.out.println("\n");
    }

}
