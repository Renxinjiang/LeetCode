import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    // 判断一棵树是不是完全二叉树
    //1.将二叉树根结点入队
    //2.持续下列操作直到队头为空
    //  2.1出队首结点
    //  2.2带所出结点的孩子入队（无论孩子是否为空，都入队）
    //3.判断队是否为空，若为空则是完全二叉树，若不为空则返回false
    boolean isCompleteTree(Node root){
        if (root == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        //1
        queue.offer(root);
        //2
        while(true){
            Node front = queue.poll();
            if (front == null){
                break;
            }
            queue.offer(front.left);
            queue.offer(front.right);
        }
        //3
        while (!queue.isEmpty()){
            if (queue.poll() != null){
                return false;
            }
        }
        return true;
    }
}
