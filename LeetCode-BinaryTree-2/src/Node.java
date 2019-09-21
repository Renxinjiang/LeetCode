public class Node {
        public char val;
        public Node left;
        public Node right;
        public Node(char val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return String.format("%c", val);
        }
}
