public class Test {
        //定义一个内部类为结点类
        private static class Node{
            private char val;
            private Node left;
            private Node right;
            public Node(char val){
                this.val = val;
                this.left = null;
                this.right = null;
            }
        }
        //找到二叉树中某节点
        public Node find(Node root,int val){
            if (root == null){
                return null;
            }
            if (root.val == val){
                return root;
            }
            Node n = find(root.left,val);
            if(n != null){
                return n;
            }
            return find(root.right,val);
        }
        //二叉树中是否有某节点
        public boolean find2(Node root,int val){
            if (root == null ){
                return false;
            }
            if (root.val == val){
                return true;
            }
        /*
        if(find(root.left,val) != null || find(root.right,val) != null){
            return true;
        }
        return false;
        */
            return (find(root.left,val) != null || find(root.right,val) != null);
        }
        //两个二叉树是否相等
        public boolean isSameTree(Node p, Node q) {
            if (p == null && q == null){
                return true;
            }else if(p == null || q == null){
                return false;
            }
            return p.val ==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        //两个二叉树是否镜像
        public boolean isMirrorTree(Node p, Node q){
            if (p == null && q == null){
                return true;
            }else if(p == null || q == null){
                return false;
            }
            return p.val == q.val && isMirrorTree(p.left,q.right) && isMirrorTree(p.right,q.left);
        }
    }

