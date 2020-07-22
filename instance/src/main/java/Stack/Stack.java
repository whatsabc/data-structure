package Stack;

/**
 * @author Jianshu
 * @time 2020/07/22
 */
public class Stack {

    StackNode stackNode;
    public Stack(StackNode stackNode){
        this.stackNode=stackNode;
    }

    /**
     * 出栈
     * @return val 栈顶元素的值
     */
    public int pop(){
        if(isEmpty()){
            System.out.println("空栈，弹出失败");
            return -1;
        }

        int val=peek();
        StackNode p=stackNode;

        p=p.next;
        stackNode=p;

        return val;
    }

    /**
     * 入栈
     * @param val 入站元素的值
     */
    public void push(int val){
        StackNode p=new StackNode(val);
        p.next=stackNode;
        stackNode=p;
    }

    /**
     * 取出栈顶元素
     * @return
     */
    public int peek(){
        return stackNode.val;
    }


    public boolean isEmpty(){
        return stackNode == null;
    }

}
