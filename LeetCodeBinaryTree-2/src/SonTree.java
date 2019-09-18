public class SonTree {
    public boolean isSametree(Node p, Node q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val==q.val && isSametree(p.left,q.left) && isSametree(p.right,q.right);
    }
    public boolean isSubtree(Node s, Node t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null){
            return false;
        }
        return isSametree(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }
}
