package Tree.BinaryTree;

/**
 * @author Jianshu
 * @time 20200727
 * 最基本的二叉树
 */

import java.util.*;

public class Tree {

    TreeNode root;

    /**
     * 递归进行先序遍历
     * @param root
     */
    public void preOrderTraverse(TreeNode root){
        if(root!=null){
            System.out.print("-->"+root.val);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    /**
     * 递归进行中序遍历
     * @param root
     */
    public void midOrderTraverse(TreeNode root){
        if(root!=null){
            midOrderTraverse(root.left);
            System.out.print("-->"+root.val);
            midOrderTraverse(root.right);
        }
    }

    /**
     * 递归进行后序遍历
     * @param root
     */
    public void postOrderTraverse(TreeNode root){
        if(root!=null){
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
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

    /**
     * 二叉树的序列化和反序列化，序列化是指将树转换为字符串，反序列化是指将字符串转化为树
     * 有两种方式DFS和BFS
     */

    /**
     * 二叉树的BFS反序列化
     * @param data 输入数据
     */
    public void deSerializeBFS(String[] data){
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
     * 二叉树的BFS序列化
     * @param treeNode
     * @return
     */
    public String SerializeBFS(TreeNode treeNode){
        StringBuilder res=new StringBuilder();
        //注意，这里的队列不能使用ArrayDeque，因为ArrayDeque不能存放null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode rnode=queue.remove();
            if(rnode==null){
                res.append("null ");
            }
            else{
                res.append(rnode.val+" ");
                queue.add(rnode.left);
                queue.add(rnode.right);
            }
        }
        return res.toString();
    }

    /**
     * 二叉树的DFS序列化
     * @param treeNode
     * @return
     */
    public String SerializeDFS(TreeNode treeNode){
        return Serialize_DFS(treeNode,"");
    }

    public String Serialize_DFS(TreeNode treeNode,String res){
        if(treeNode==null){
            res+="null ";
        }
        else{
            res+=treeNode.val+" ";
            res=Serialize_DFS(treeNode.left,res);
            res=Serialize_DFS(treeNode.right,res);
        }
        return res;
    }

    /**
     * 二叉树的DFS反序列化
     * @param data
     */
    public void deSerializeDFS(String[] data){
        ArrayDeque<String> arrayDeque=new ArrayDeque<>();
        arrayDeque.addAll(Arrays.asList(data));//将String转换为双端队列
        root=deSerialize_DFS(arrayDeque);
    }

    public TreeNode deSerialize_DFS(ArrayDeque<String> arrayDeque){
        //如果队列空了，依次退出函数
        if(arrayDeque.isEmpty())
            return null;

        String node=arrayDeque.remove();
        if(node.equals("null")){
            return null;
        }
        TreeNode newNode=new TreeNode(Integer.parseInt(node));
        newNode.left=deSerialize_DFS(arrayDeque);
        newNode.right=deSerialize_DFS(arrayDeque);
        return newNode;
    }
}
