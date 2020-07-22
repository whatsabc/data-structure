package Stack;

/**
 * @author Jianshu
 * @time 2020/07/22
 */
public class StackMain {
    public static void main(String args[]){
        StackNode stackNode=new StackNode(0);
        Stack stack=new Stack(stackNode);

        stack.push(1);
        System.out.println("栈顶元素是："+stack.peek());
        System.out.println("出栈元素是："+stack.pop());
        System.out.println("栈顶元素是："+stack.peek());
    }
}
