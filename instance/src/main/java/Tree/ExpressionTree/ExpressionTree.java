package Tree.ExpressionTree;

/**
 * @author Jianshu
 * @time 20200810
 */
import java.util.Stack;

public class ExpressionTree {

    String[] expression;//输入的后缀表达式

    public ExpressionTree(String[] expression) {
        this.expression = expression;
    }

    /**
     * 逆波兰表达式求值
     * @return
     */
    public int calculateResult() {
        Stack<Integer> numStack=new Stack<>();
        Integer op1,op2;
        for(String s:expression){
            switch(s){
                case "+":
                    op2=numStack.pop();
                    op1=numStack.pop();
                    numStack.push(op1+op2);
                    break;
                case "-":
                    op2=numStack.pop();
                    op1=numStack.pop();
                    numStack.push(op1-op2);
                    break;
                case "*":
                    op2=numStack.pop();
                    op1=numStack.pop();
                    numStack.push(op1*op2);
                    break;
                case "/":
                    op2=numStack.pop();
                    op1=numStack.pop();
                    numStack.push(op1/op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }

    /**
     * 逆波兰表达式转换为表达式树
     * @return
     */
    public TreeNode expressionToTree(){
        Stack<TreeNode> treeNodeStack=new Stack<>();
        TreeNode treeNodeRoot=null;
        for(String s:expression){
            //如果遇到符号，弹出栈中两个节点，构造根节点，树生长，根节点压入
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                treeNodeRoot=new TreeNode(s.charAt(0));
                treeNodeRoot.right=treeNodeStack.pop();
                treeNodeRoot.left=treeNodeStack.pop();
                treeNodeStack.push(treeNodeRoot);
            }
            else{
                //如果是数字，压入栈中
                treeNodeStack.push(new TreeNode(Integer.parseInt(s)));
            }
        }
        return treeNodeRoot;
    }

    /**
     * 递归进行中序遍历（表达式树的中序遍历就是常用的算数表达式）
     * @param root
     */
    public void midOrderTraverse(TreeNode root){
        if(root!=null){
            midOrderTraverse(root.left);
            if(root.val!=-100000)
                System.out.print(root.val);
            else
                System.out.print(root.operator);
            midOrderTraverse(root.right);
        }
    }
}
