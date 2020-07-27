package Tree.BinaryTree;

/**
 * @author Jianshu
 * @time 20200727
 * 这是最基本的二叉树
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Tree {

    TreeNode root;

    /**
     * 代码来源：leetcode，原意是按照输入数据的顺序依次根据层数来构建一个二叉树
     * 当某个数据为null的时候，该节点置为空
     * @param data 输入数据
     */
    public void stringToTreeNode(String[] data){
        String item = data[0];
        root = new TreeNode(Integer.parseInt(item));//第一个元素放入树根
        //同时准备一个队列依次对节点插入他的左右子树
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        int index=1;
        while(!deque.isEmpty()) {

            TreeNode node=deque.remove();

            if(index==data.length) {
                break;
            }

            item=data[index++];item=item.trim();
            if(!item.equals("null")) {
                node.left=new TreeNode(Integer.parseInt(item));
                deque.add(node.left);
            }

            if(index==data.length) {
                break;
            }

            item=data[index++];item=item.trim();
            if (!item.equals("null")) {
                node.right=new TreeNode(Integer.parseInt(item));
                deque.add(node.right);
            }
        }
    }

    /**
     * 递归进行先序遍历
     * @param root
     */
    public void PreOrderTraverse(TreeNode root){
        if(root!=null){
            System.out.print("-->"+root.val);
            PreOrderTraverse(root.left);
            PreOrderTraverse(root.right);
        }
    }

    /**
     * 递归进行中序遍历
     * @param root
     */
    public void MidOrderTraverse(TreeNode root){
        if(root!=null){
            MidOrderTraverse(root.left);
            System.out.print("-->"+root.val);
            MidOrderTraverse(root.right);
        }
    }

    /**
     * 递归进行后序遍历
     * @param root
     */
    public void PostOrderTraverse(TreeNode root){
        if(root!=null){
            PostOrderTraverse(root.left);
            PostOrderTraverse(root.right);
            System.out.print("-->"+root.val);
        }
    }


    /**
     * 广度优先遍历算法
     */
    public void BFS(){

        Deque<TreeNode> deque=new ArrayDeque<>();
        if(root==null){
            return;
        }

        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode treeNode=deque.remove();
            System.out.print("-->"+treeNode.val);
            if(treeNode.left!=null){
                deque.add(treeNode.left);
            }
            if(treeNode.right!=null){
                deque.add(treeNode.right);
            }
        }
    }
}
