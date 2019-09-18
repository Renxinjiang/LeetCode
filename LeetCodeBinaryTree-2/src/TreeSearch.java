//关于二叉树中的四种查找
public class TreeSearch {
    //查找树中是否包含值为val的结点，找到返回该结点的引用
    Node search1(Node root,int val){
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        Node left = search1(root.left,val);
        //如果left为空，则表示没找到，若不为空则找到并返回left；
        if (left != null){
            return left;
        }
        return search1(root.right,val);
    }
    //查找树中是否包含值为val的结点，找到返回true
    boolean search2(Node root,int val){
        if (root == null){
            return false;
        }
        if (root.val == val){
            return true;
        }
        //如果left为空，则表示没找到，若不为空则找到并返回left；
        if (search2(root.left,val)){
            return true;
        }
        return search2(root.right,val);
    }
    //subRoot判断是否为root的子树
    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }
        return p.val ==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    boolean search3(Node root,Node subRoot){
        if (root == null){
            return false;
        }
        if (isSameTree(root,subRoot)){
            return true;
        }
        if (search3(root.left,subRoot)){
            return true;
        }
        return search3(root.right,subRoot);
    }
    //结点node是root的左子树还是右子树
    boolean search4(Node root,Node node){
        if (root == null){
            return false;
        }
        if (root == node){
            return true;
        }
        if (search4(root.left,node)){
            return true;
        }
        return  search4(root.right,node);
    }
}