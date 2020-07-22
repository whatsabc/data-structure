package List;

/**
 * @author Jianshu
 * @time 2020/07/21
 */
public class ListMain {
    public static void main(String args[]){

        /*
        创建头节点，初始化链表
         */
        ListNode head=new ListNode(1);
        List list=new List(head);

        /*
        测试函数
         */
        list.add(3);
        list.add(4);
        list.add(0,0);
        list.add(2,2);//0 1 2 3 4

        list.add(2,100);
        list.add(10,100);//非法操作
        list.delete(4);
        list.delete(10);//非法操作

        list.print();
    }
}
