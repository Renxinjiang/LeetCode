/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: Node
 * @Description:
 * @author: 呆呆
 * @date: 2019/10/10
 */
public class Node {
    public int val;
    public Node next;
    public Node random;
    public Node(){

    }
    public Node (int val,Node next,Node random){
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
