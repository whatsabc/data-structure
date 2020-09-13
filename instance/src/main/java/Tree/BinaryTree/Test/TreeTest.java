package Tree.BinaryTree.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeTest {

    /**
     * 递归进行先序遍历
     * @param root
     */
    public static void preOrderTraverse(TreeNodeTest root){
        if(root!=null){
            root.visitedNum++;
            System.out.print("[Num: "+ root.visitedNum+"]");
            System.out.print(root.val+" ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    /**
     * 递归进行中序遍历
     * @param root
     */
    public static void midOrderTraverse(TreeNodeTest root){
        if(root!=null){
            root.visitedNum++;
            System.out.print("[Num: "+ root.visitedNum+"]");
            midOrderTraverse(root.left);
            System.out.print(root.val+" ");
            midOrderTraverse(root.right);
        }
    }

    /**
     * 递归进行后序遍历
     * @param root
     */
    public static void postOrderTraverse(TreeNodeTest root){
        if(root!=null){
            root.visitedNum++;
            System.out.print("[Num: "+ root.visitedNum+"]");
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val+" ");
        }
    }

    /**
     * 二叉树的BFS反序列化
     * @param data 输入数据
     */
    public TreeNodeTest deSerializeBFS(String[] data){
        TreeNodeTest root;
        String item = data[0];
        root = new TreeNodeTest(Integer.parseInt(item));//第一个元素放入树根
        //同时准备一个队列依次对节点插入他的左右子树
        Deque<TreeNodeTest> deque = new ArrayDeque<>();
        deque.add(root);

        int index=1;
        while(!deque.isEmpty()) {

            TreeNodeTest node=deque.remove();

            if(index==data.length) {
                break;
            }

            item=data[index++];item=item.trim();
            if(!item.equals("null")) {
                node.left=new TreeNodeTest(Integer.parseInt(item));
                deque.add(node.left);
            }

            if(index==data.length) {
                break;
            }

            item=data[index++];item=item.trim();
            if (!item.equals("null")) {
                node.right=new TreeNodeTest(Integer.parseInt(item));
                deque.add(node.right);
            }
        }
        return root;
    }
}

class TreeNodeTest {
    int val = 0;
    TreeNodeTest left = null;
    TreeNodeTest right = null;
    int visitedNum = 0;

    public TreeNodeTest(int val) {
        this.val = val;
    }
}