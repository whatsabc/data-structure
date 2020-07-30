package Tree.BinaryTree;

/**
 * @author Jianshu
 * @time 20200727
 */
public class TreeMain {
    public static void main(String[] args){

        String[] data=new String[]{"1","2","null","3","4","5","6"};
        Tree tree=new Tree();
        tree.stringToTreeNode(data);

        System.out.println("\n先序遍历：");
        tree.preOrderTraverse(tree.root);
        System.out.println("\n中序遍历：");
        tree.midOrderTraverse(tree.root);
        System.out.println("\n后序遍历：");
        tree.postOrderTraverse(tree.root);
        System.out.println("\n广度优先遍历：");
        tree.BFS();
    }
}
