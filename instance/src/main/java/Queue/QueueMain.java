package Queue;

/**
 * @author Jianshu
 * @time 2020/07/22
 */
public class QueueMain {
    public static void main(String args[]){
        QueueNode front=new QueueNode(0);
        Queue queue=new Queue(front);

        queue.EnQueue(1);
        queue.EnQueue(2);
        queue.EnQueue(3);

        queue.print();

        queue.DeQueue();
        queue.DeQueue();

        queue.print();
    }
}
