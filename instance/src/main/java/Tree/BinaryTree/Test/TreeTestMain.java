package Tree.BinaryTree.Test;


public class TreeTestMain {
    public static void main(String[] args){
        String[] dataBFS=new String[]{"1","2","3","null","null","4","5"};


        TreeTest treeBFS=new TreeTest();
        TreeNodeTest root1=treeBFS.deSerializeBFS(dataBFS);//BFS反序列化

        TreeNodeTest root2=treeBFS.deSerializeBFS(dataBFS);//BFS反序列化
        TreeNodeTest root3=treeBFS.deSerializeBFS(dataBFS);//BFS反序列化


        System.out.print("\n递归先序遍历 ");
        TreeTest.preOrderTraverse(root1);
        System.out.print("\n递归中序遍历 ");
        TreeTest.midOrderTraverse(root2);
        System.out.print("\n递归后序遍历 ");
        TreeTest.postOrderTraverse(root3);

    }
}
