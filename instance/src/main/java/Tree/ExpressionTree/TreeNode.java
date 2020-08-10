package Tree.ExpressionTree;

/**
 * @author Jianshu
 * @time 20200810
 */
public class TreeNode {
    int val=-100000;
    char operator;
    TreeNode left=null;
    TreeNode right=null;

    public TreeNode(int val) {
        this.val=val;
    }

    public TreeNode(char operator){
        this.operator=operator;
    }
}
