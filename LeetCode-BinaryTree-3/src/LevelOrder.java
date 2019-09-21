import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    //二叉树的层序遍历
    //1.根入队
    //2.持续下列操作直到队空
    //  2.1出队首结点
    //  2.2带所出结点的孩子入队
    public void levelOrderTraversal(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node front = queue.poll();
            System.out.print(front.val + " ");
            if (front.left != null){
                queue.offer(front.left);
            }
            if (front.right != null){
                queue.offer(front.right);
            }
        }
    }
}
