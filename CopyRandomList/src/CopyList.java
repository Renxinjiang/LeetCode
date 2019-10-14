import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: CopyList
 * @Description:
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 * @author: 呆呆
 * @date: 2019/10/12
 */
public class CopyList {
    /**
     * 思路：
     * 方法一：
     * 按照链表的方式复制
     * 难点：（Random）指向找到新链表的节点（Random）指向
     * 1.将旧链表结点复制一份
     * 2.将新旧链表连起来
     * 3.根据旧链表的Random找新链表的Random
     * 4.结束后将新旧链表分开
     *
     * 方法二：
     * 通过Map保存新旧链表的映射关系
     * 旧链表中的结点作为key，新链表中的结点作为value；
     * 新链表node，旧链表cur
     * node.random = map.get(cur.random)
     * 解释：cur.random是key，get(cur.random)是key对应的value。
     */
    public Node copyRandomList(Node head){
        Node cur = head;
        while (cur != null){
            Node node = new Node();
            node.val = cur.val;

            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        //复制random
        while (cur != null){
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }else {
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        cur = head;
        if (head == null){
            return null;
        }
        Node newHead = head.next;
        //拆新旧链表
        while (cur != null){
          Node node = cur.next;
          cur.next = node.next;
          if (node.next != null) {
              node.next = node.next.next;
          }
          cur = cur.next;
        }
        return newHead;
    }

    // 因为Map的key内部比较大小，得有Comparable或者比较器
    // Node作为引用数据类型里面都没有所以，无法比较
    // 写一个比较器
    private static class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.val - o2.val;
        }
    }
    public Node copyRandomList2(Node head){
        //要传入比较器
        Map<Node,Node> map = new TreeMap<>(new NodeComparator());
        Node newHead = null;
        Node newLast = null;
        Node cur = head;
        while (cur != null){
            Node node = new Node();
            node.val = cur.val;

            //node尾插到newHead
            if (newHead == null){
                newHead = node;
            }else {
                newLast.next = node;
            }
            newLast = node;

            map.put(cur,node);

            cur = cur.next;
        }

        cur = head;
        Node node = newHead;
        while (node != null){
            if (cur.random != null) {
                node.random = map.get(cur.random);
            }else {
                node.random = null;
            }
            cur = cur.next;
            node = node.next;
        }
        return newHead;
    }
}
