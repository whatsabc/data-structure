package Tree.ExpressionTree;

/**
 * 逆波兰表达式的求值和转换成树
 * @author Jianshu
 * @time 20200810
 */
public class ExpressionTreeMain {
    public static void main(String[] args){
        String[] exception=new String[]{"2", "1", "+", "3", "*"};
        ExpressionTree expressionTree=new ExpressionTree(exception);
        System.out.print("该表达式的结果为：");
        System.out.println(expressionTree.calculateResult());
        TreeNode root=expressionTree.expressionToTree();
        System.out.print("该表达式的中缀形式为：");
        expressionTree.midOrderTraverse(root);
    }
}
