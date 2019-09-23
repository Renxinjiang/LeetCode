import java.util.*;

public class LevelTraversal {
    /**
     *给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     */
    public static class NodeLevel{
        //一个队列中放既有结点又有层的类对象
        Node node;
        int level;
        NodeLevel(Node node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public static void levelOrder1(Node root){
        if (root == null){
            return ;
        }
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.offer(new NodeLevel(root,0));
        while(!queue.isEmpty()){
            NodeLevel front = queue.poll();
            System.out.println(front.level+":"+front.node.val);
            if (front.node.left != null){
                queue.offer(new NodeLevel(front.node.left,front.level+1));
            }
            if (front.node.right != null){
                queue.offer(new NodeLevel(front.node.right,front.level+1));
            }
        }
    }

    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.offer(new NodeLevel(root,0));
        while (!queue.isEmpty()){
            NodeLevel front = queue.poll();
            if (result.size() == front.level){
                result.add(new ArrayList<>());
            }
            List<Integer> list = result.get(front.level);
            list.add(front.node.val);
            if (front.node.left != null){
                queue.offer(new NodeLevel(front.node.left,front.level+1));
            }
            if (front.node.right != null){
                queue.offer(new NodeLevel(front.node.right,front.level+1));
            }
        }
        return result;
    }
}
