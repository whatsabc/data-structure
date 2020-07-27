package Tree.SortTree;

/**
 * @author Jianshu
 * @time 20200727
 * 二叉排序树
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SortTree {

    TreeNode root;

    /**
     * 一次插入一个元素构建二叉树
     * @param val
     */
    public void InsertBST(int val){

        TreeNode treeNode=new TreeNode(val);
        //如果从根节点开始，根节点直接赋值
        if(root==null){
            root=treeNode;
            return;
        }

        //如果在排序二叉树里面找到了这个值，跳过
        if(SearchBST(root,val)!=null){
            return;
        }

        TreeNode node=null,tempRoot=root;
        while(tempRoot!=null){
            node=tempRoot;
            if(val<tempRoot.val)
                tempRoot=tempRoot.left;
            else
                tempRoot=tempRoot.right;
        }
        //根据大小插入到找到的节点的左/右子树中
        if(val<node.val)
            node.left=treeNode;
        else
            node.right=treeNode;
    }

    /**
     * 递归找到二叉树中的某个值
     * @param root
     * @param val
     * @return
     */
    public TreeNode SearchBST(TreeNode root, int val){
        if(root==null){
            return null;
        }
        else if(val>root.val){
            return SearchBST(root.right,val);
        }
        else if(val<root.val){
            return SearchBST(root.left,val);
        }
        else{
            return root;
        }
    }

    /**
     *
     */
    public int SearchMax(){
        TreeNode treeNode=root;
        while(treeNode.right!=null){
            treeNode=treeNode.right;
        }
        return treeNode.val;
    }

    /**
     *
     */
    public int SearchMin(){
        TreeNode treeNode=root;
        while(treeNode.left!=null){
            treeNode=treeNode.left;
        }
        return treeNode.val;
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
