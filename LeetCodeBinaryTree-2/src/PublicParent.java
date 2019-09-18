/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *公共祖先的定义为：
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * 给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 */
public class PublicParent {
    //写一个查找方法，判断p和q位置
    public boolean search(Node r,Node t){
        if (r == null){
            return false;
        }
        if (r == t){
            return true;
        }
        if (search(r.left,t)){
            return true;
        }
        return search(r.right,t);
    }
    /**
     * 1.p或q就是root，return root；
     * 2.p和q都在左子树，递归到左子树去解决
     * 3.p和q都在右子树，递归到右子树去解决
     * 4.p和q不在一棵子树，return root；
     */
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        //1.p或q就是root，return root；
        if(p == root || q == root){
            return root;
        }
        boolean pInleft = search(root.left,p);
        boolean qInleft = search(root.left,q);
        //2.p和q都在左子树，递归到左子树去解决
        if (pInleft && qInleft){
            return lowestCommonAncestor(root.left,p,q);
        }
        //3.p和q都在右子树，递归到右子树去解决
        if (!pInleft && !qInleft){
            return lowestCommonAncestor(root.right,p,q);
        }
        //4.p和q不在一棵子树，return root;
        return root;
    }
}
