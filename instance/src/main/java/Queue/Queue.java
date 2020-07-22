package Queue;

/**
 * @author Jianshu
 * @time 2020/07/22
 */
public class Queue {

    QueueNode front;
    QueueNode rear;
    public int size;

    public Queue(QueueNode front){
        this.front=this.rear=front;//生成节点作为头节点，队头和队尾指针指向此节点
        size=1;
    }

    /**
     * 入队
     * @param val
     */
    public void EnQueue(int val){
        QueueNode q=new QueueNode(val);
        rear.next=q;
        rear=q;//修改队尾指针值，使其指向最后一个节点；

        size++;
    }


    /**
     * 删除链表指定位置的表项
     */
    public int DeQueue(){

        if(isEmpty()){
            System.out.println("队列是空的");
            return -1;
        }

        QueueNode p=front;
        int val=front.val;

        p=p.next;
        front=p;

        size--;
        return val;
    }

    /*
     * 判断链表是否为空表
     */
    public boolean isEmpty(){
        return front == null;
    }

    /*
     * 遍历整个链表，并打印
     */
    public void print(){
        QueueNode p=front;
        while(p!=null){
            System.out.print(" --> "+p.val);
            p=p.next;
        }
        System.out.println("\n");
    }
}
