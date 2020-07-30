package Tree.SortTree;

/**
 * @author Jianshu
 * @time 20200727
 * 二叉排序树（二叉查找树，二叉搜索树）
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class SortTree {

    TreeNode root;

    /**
     * 在一个二叉树插入一个元素（迭代实现）
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
        if(searchBST(root,val)!=null){
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
     * 在一个二叉树插入一个元素（递归实现）
     * ==来自leetcode==
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        // insert into the right subtree
        if (val > root.val) root.right = insertIntoBST(root.right, val);
            // insert into the left subtree
        else root.left = insertIntoBST(root.left, val);
        return root;
    }

    /**
     * 递归找到二叉树中的某个值
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val){
        if(root==null){
            return null;
        }
        else if(val>root.val){
            return searchBST(root.right,val);
        }
        else if(val<root.val){
            return searchBST(root.left,val);
        }
        else{
            return root;
        }
    }

    /**
     * 查找最大值
     */
    public int searchMax(){
        TreeNode treeNode=root;
        while(treeNode.right!=null){
            treeNode=treeNode.right;
        }
        return treeNode.val;
    }

    /**
     * 查找最小值
     */
    public int searchMin(){
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

        Deque<TreeNode> deque=new ArrayDeque<>();//
        if(root==null){
            return;
        }

        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode treeNode=deque.remove();
            System.out.print("-->"+treeNode.val);//
            if(treeNode.left!=null){
                deque.add(treeNode.left);
            }
            if(treeNode.right!=null){
                deque.add(treeNode.right);
            }
        }
    }


    /**
     * 二叉排序树的删除
     * 1.只有一个节点：如果要删除的节点A只有一个子节点，就直接将A的子节点连到A的父节点，并将A删除；
     * 2.如果A有两个子节点，我们就以该节点右子树的最小节点取代A；
     * ====疑问点，未解决====
     * 注意：此函数不可用，由于Java的参数是按值传递的，因此，我们只能修改treeNode=的复制值，修改不了原root
     * @param treeNode
     * @param val
     */
    public void deleteBSTNode(TreeNode treeNode, int val){
        TreeNode parent=null;
        if(treeNode==null){
            return;
        }
        else if(treeNode.val==val){
            //是一个叶子节点；
            if(treeNode.left==null&&treeNode.right==null){
                treeNode=null;
            }
            //只有左节点；
            else if(treeNode.right==null&&treeNode.left!=null){
                treeNode=treeNode.left;
            }
            //只有右节点；
            else if(treeNode.right!=null&&treeNode.left==null){
                treeNode=treeNode.right;
            }
            //两个节点均存在
            else{
                TreeNode s=treeNode.right;
                //如果p的右子树s没有左子树
                if(s.left==null){
                    s.left=treeNode.left;
                }
                //如果p的右子树s有左子树
                else{
                    //在左子树找到最小的节点；
                    while(s.left!=null){
                        parent=s;//记录下这个最小的节点；
                        s=s.left;
                    }
                    treeNode.left=s.right;
                    s.left=treeNode.left;
                    s.right=treeNode.right;
                }
                treeNode=s;
            }
        }
        //向右找
        else if(val>treeNode.val){
            deleteBSTNode(treeNode.right,val);
        }
        //向左找
        else if(val<treeNode.val){
            deleteBSTNode(treeNode.left,val);
        }
    }

    /**
     * 二叉树的删除（该代码主要来自LeetCode）
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null)
            return null;
        //向右边找
        if(key>root.val)
            root.right=deleteNode(root.right,key);
        //向左边找
        else if(key<root.val)
            root.left=deleteNode(root.left, key);
        //找到了要删除的节点
        else{
            //节点是一个叶子节点
            if(root.left==null&&root.right==null)
                root=null;
            //不是叶子节点并且有一个右孩子
            else if(root.right!=null){
                root.val=successor(root);
                root.right=deleteNode(root.right,root.val);
            }
            //不是叶子节点，没有右孩子，但是有一个左孩子
            else{
                root.val=predecessor(root);
                root.left=deleteNode(root.left,root.val);
            }
        }
        return root;
    }

    /**
     * 找到该节点右节点开始的子树的最小值
     * @param root
     * @return
     */
    public int successor(TreeNode root){
        root=root.right;
        while(root.left!=null)
            root=root.left;
        return root.val;
    }

    /**
     * 找到该节点左节点开始的子树的最大值
     * @param root
     * @return
     */
    public int predecessor(TreeNode root){
        root=root.left;
        while(root.right!=null)
            root=root.right;
        return root.val;
    }
}
