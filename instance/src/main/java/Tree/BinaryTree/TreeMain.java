package Tree.BinaryTree;

/**
 * @author Jianshu
 * @time 20200727
 */
public class TreeMain {
    public static void main(String[] args){

        String[] dataBFS=new String[]{"1","2","3","null","null","4","5"};

        String[] dataDFS=new String[]{"1","2","null","null","3","4","null","null","5"};
        Tree treeBFS=new Tree();

        treeBFS.deSerializeBFS(dataBFS);//BFS反序列化
        System.out.println(treeBFS.SerializeBFS(treeBFS.root));//BFS序列化

        Tree treeDFS=new Tree();
        treeDFS.deSerializeDFS(dataDFS);//DFS反序列化
        System.out.println(treeDFS.SerializeDFS(treeDFS.root));//DFS序列化

        /**
         *
        System.out.println("\n先序遍历：");
        treeBFS.preOrderTraverse(treeBFS.root);
        System.out.println("\n中序遍历：");
        treeBFS.midOrderTraverse(treeBFS.root);
        System.out.println("\n后序遍历：");
        treeBFS.postOrderTraverse(treeBFS.root);
        System.out.println("\n广度优先遍历：");
        treeBFS.BFS();
         */
    }
}
