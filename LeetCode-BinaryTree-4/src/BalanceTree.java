public class BalanceTree {
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

    //求二叉树的高
    private static int getHigh(Node root){
        if (root == null){
            return 0;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.max(left,right) + 1;
    }
    //是否是平衡二叉树
    public boolean isBalanced(Node root) {
        if (root == null){
            return true;
        }
        if (!isBalanced(root.left)){
            return false;
        }
        if (!isBalanced(root.right)){
            return false;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        int diff = left - right;
        if (diff >= -1 && diff <= 1){
            return true;
        }
        return false;
    }
}
