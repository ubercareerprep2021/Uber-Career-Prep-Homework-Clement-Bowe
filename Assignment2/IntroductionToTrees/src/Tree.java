public class Tree {
    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
    
        public TreeNode(int data, TreeNode left, TreeNode right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }

      public TreeNode root;
      public Tree(TreeNode root){
          this.root = root; 
      }
      public void preorderTraversal(){
          TreeNode rootNode = root; 
          preorderTraversalUtility(rootNode);
          System.out.println();
      }
      
      private void preorderTraversalUtility(TreeNode rootNode) {
          if(rootNode != null){
              System.out.print(rootNode.data + " ");

              preorderTraversalUtility(rootNode.left);
              preorderTraversalUtility(rootNode.right);
          }
    }
    public void inorderTraversal(){
        TreeNode rootNode = root;
        inorderTraversalUtility(rootNode);
        System.out.println();
      }
      private void inorderTraversalUtility(TreeNode rootNode){
          if(rootNode != null){
            
            inorderTraversalUtility(rootNode.left);
            System.out.print(rootNode.data + " ");
          }
      }
      
      public void postorderTraversal(){
          TreeNode rootNode = root;
          postorderTraversalUtility(rootNode);
          System.out.println();
      }
    private void postorderTraversalUtility(TreeNode rootNode) {
        if(rootNode != null){

            postorderTraversalUtility(rootNode.left);
            postorderTraversalUtility(rootNode.right);
            System.out.print(rootNode + " ");
        }
    }
}
    
