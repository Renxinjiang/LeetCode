public class TreeToString {
    //你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    //空节点则用一对空括号 "()" 表示。
    // 而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
    //示例 1:
    //输入: 二叉树: [1,2,3,4]
    //       1
    //     /   \
    //    2     3
    //   /
    //  4
    //输出: "1(2(4))(3)"
    //解释: 原本将是“1(2(4)())(3())”，在你省略所有不必要的空括号对之后，它将是“1(2(4))(3)”。
    //示例 2:
    //输入: 二叉树: [1,2,3,null,4]
    //       1
    //     /   \
    //    2     3
    //     \
    //      4
    //
    //输出: "1(2()(4))(3)"，除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
    //链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
    public static String beforetreeTostr(Node root) {
        //思路：
        // 左右都为空,能省略
        // 左不为空，右为空，能省略
        // 左为空，右不为空，不能省略
        String s = "";
        if (root != null) {
            s += "(";
            s += root.val;
            if (root.left == null && root.right == null) {
            } else if (root.left != null && root.right == null) {
                beforetreeTostr(root.left);
            } else if (root.left == null && root.right != null) {
                s += "()";
                s += beforetreeTostr(root.right);
            } else {
                s += beforetreeTostr(root.left);
                s += beforetreeTostr(root.right);
            }
            s += ")";
        }
        return s;
    }
    public static String treeTostr(Node root){
        if (root == null){
            return "";
        }
        String s = beforetreeTostr(root);
        return s.substring(1,s.length()-1);
    }
}
